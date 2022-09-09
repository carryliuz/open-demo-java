package com.awaken.imagine.demo;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.awaken.imagine.model.PageResult;
import com.awaken.imagine.model.order.AddHistoryOrderReq;
import com.awaken.imagine.model.order.AddOrderReq;
import com.awaken.imagine.model.order.OrderModel;
import com.awaken.imagine.model.order.OrderQuery;
import com.awaken.imagine.utils.SignUtil;

/**
 * 提现订单
 * @author Carry.Liu
 */
public class OrderDemo extends AbstractDemo {

	/**
	 * 添加提现订单
	 * 该接口有ip白名单校验
	 */
	public static void addOrder() {
		AddOrderReq req = new AddOrderReq();
		req.setProviderId(PROVIDER_ID);
		req.setTradeNo("T20220906000001");
		req.setBizFee(new BigDecimal("0.01"));
		req.setBankCardNo("6217003230005xxxxxx");
		req.setPaymentType(1); // 收款方式，选填 1:银行卡，2:支付宝
		req.setBankPhone("1581681xxxx");
		req.setName("李二牛");
		req.setPapersNo("43112619850824xxxx");
		req.setPapersType(0); // 证件类型，0:身份证 1:护照 2:军官证 3:港澳台身份证
		req.setNotifyUrl("https://www.baidu.com");
		req.setExtendParams("{\"uid\":\"U0001\"}");
		req.setNonce(getUUid());
		req.setSign(SignUtil.createSign(req, APP_KEY));
		String result = doPostJson(API_ORDER_ADD, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		OrderModel resp = JSON.parseObject(result, OrderModel.class);
		if (resp.getId() != null) {
			logger.info("添加提现订单成功，orderId：{}", resp.getId());
		} else {
			logger.info("添加提现订单失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 *  订单详情查询
	 */
	public static void getOrder() {
		String tradeNo = "T20220906000001";
		String result = doGet(API_ORDER_GET.replace("{tradeNo}", tradeNo), null, getToken());
		System.out.println("result：" + result);
		OrderModel resp = JSON.parseObject(result, OrderModel.class);
		if (resp.getId() != null) {
			logger.info("查询订单成功，orderId：{}", resp.getId());
		} else {
			logger.info("查询订单失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 查询提现订单列表
	 */
	public static void listOrder() {
		OrderQuery req = new OrderQuery();
		req.setProviderId(PROVIDER_ID);
//		req.setTradeNo("123");
//		req.setPapersNoList(Arrays.asList("431126198508200000"));
//		req.setStatus(1);
		req.setStartDate("2022-08-01 00:00:00");
		req.setEndDate("2022-09-06 23:59:59");
//		req.setPageNum(1); // 页码，默认1
//		req.setPageSize(5); // 每页行数，默认10
		String result = doPostJson(API_ORDER_LIST, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		PageResult<OrderModel> resp = JSON.parseObject(result, PageResult.class);
		logger.info("查询提现订单列表，总页数：{}，resp：{}", resp.getPages(), JSON.toJSONString(resp));
		List<OrderModel> orderList = resp.getList();
	}
	
	/**
	 * 导入历史订单
	 * 该接口有ip白名单校验
	 */
	public static void addHistoryOrder() {
		AddHistoryOrderReq req = new AddHistoryOrderReq();
		req.setProviderId(PROVIDER_ID);
		req.setTradeNo("T20220906000002");
		req.setBizFee(new BigDecimal("200"));
		req.setBaseFee(new BigDecimal("5"));
		req.setChannelFee(new BigDecimal("0.5"));
		req.setPayMonth("2022-09-05 09:21:35");
		req.setPayTime("2022-09-05 10:21:35");
		req.setBankCardNo("6217003230005xxxxxx");
		req.setPaymentType(1); // 收款方式，选填 1:银行卡，2:支付宝
		req.setBankPhone("1581681xxxx");
		req.setName("王麻子");
		req.setPapersNo("43112619850824xxxx");
		req.setPapersType(0); // 证件类型，0:身份证 1:护照 2:军官证 3:港澳台身份证
		req.setNotifyUrl("https://www.baidu.com");
//		req.setPurpose("支付服务费");
		req.setNonce(getUUid());
		req.setSign(SignUtil.createSign(req, APP_KEY));
		String result = doPostJson(API_ORDER_ADDHISTORY, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		OrderModel resp = JSON.parseObject(result, OrderModel.class);
		if (resp.getId() != null) {
			logger.info("导入历史提现订单成功，orderId：{}", resp.getId());
		} else {
			logger.info("导入历史提现订单失败，error：{}", resp.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// 添加提下您订单
//		addOrder();
		// 订单详情查询
//		getOrder();
		// 查询提现订单列表
		listOrder();
		// 导入历史订单
//		addHistoryOrder();
		
	}
	
}
