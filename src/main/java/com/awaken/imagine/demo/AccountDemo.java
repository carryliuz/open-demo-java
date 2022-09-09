package com.awaken.imagine.demo;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.awaken.imagine.model.PageResult;
import com.awaken.imagine.model.account.AddPrestoreReq;
import com.awaken.imagine.model.account.PrestoreModel;
import com.awaken.imagine.model.account.PrestoreQuery;
import com.awaken.imagine.utils.SignUtil;

/**
 * 交易账户
 * @author Carry.Liu
 */
public class AccountDemo extends AbstractDemo {

	/**
	 *  余额查询(所有账户余额汇总)
	 */
	public static void getBalance() {
		String result = doGet(API_ACCOUNT_GETBALANCE.replace("{providerId}", PROVIDER_ID), null, getToken());
		System.out.println("result：" + result);
	}
	
	/**
	 *  余额查询(分账户返回余额)
	 */
	public static void getBalanceAccount() {
		String result = doGet(API_ACCOUNT_GETBALANCEACCOUNT.replace("{providerId}", PROVIDER_ID), null, getToken());
		System.out.println("result：" + result);
	}
	
	/**
	 * 预充值汇款账号查询
	 */
	public static void getPrestoreAccount() {
		String result = doGet(API_ACCOUNT_GETPRESTOREACCOUNT.replace("{providerId}", PROVIDER_ID), null, getToken());
		System.out.println("result：" + result);
	}
	
	/**
	 * 创建充值申请
	 * 该接口有ip白名单校验
	 */
	public static void addPrestore() {
		AddPrestoreReq req = new AddPrestoreReq();
		req.setProviderId(PROVIDER_ID);
		req.setSerialNumber("P0000001"); // 银行流水号，可选
		req.setAmount(new BigDecimal("2"));
		req.setBank("中国农业银行");
		req.setBankNo("6228480038789xxxxxx");
		req.setBankName("江西xx科技股份有限公司");
		req.setPayType(0); // 支付类型,0,银行转账 1,支付宝
		req.setPayTime("2022-09-04");
		req.setNotifyUrl("https://www.baidu.com");
		req.setNonce(getUUid());
		req.setSign(SignUtil.createSign(req, APP_KEY));
		String result = doPostJson(API_ACCOUNT_ADDPRESTORE, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		PrestoreModel resp = JSON.parseObject(result, PrestoreModel.class);
		if (resp.getId() != null) {
			logger.info("创建充值申请成功，prestoreId：{}", resp.getId());
		} else {
			logger.info("创建充值申请失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 查询充值申请信息
	 */
	public static void getPrestore() {
		String prestoreId = "745339491614457856";
		String result = doGet(API_ACCOUNT_GETPRESTORE.replace("{id}", prestoreId), null, getToken());
		System.out.println("result：" + result);
		PrestoreModel resp = JSON.parseObject(result, PrestoreModel.class);
		if (resp.getId() != null) {
			logger.info("查询充值申请信息成功，prestoreId：{}", resp.getId());
		} else {
			logger.info("查询充值申请信息失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 查询充值申请列表
	 */
	public static void listPrestore() {
		PrestoreQuery req = new PrestoreQuery();
		req.setProviderId(PROVIDER_ID);
		req.setStartDate("20220801000000");
		req.setEndDate("20220906235959");
//		req.setPageNum(1); // 页码，默认1
//		req.setPageSize(5); // 每页行数，默认10
		String result = doPostJson(API_ACCOUNT_LISTPRESTORE, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		PageResult<PrestoreModel> resp = JSON.parseObject(result, PageResult.class);
		logger.info("查询充值申请列表，总页数：{}，resp：{}", resp.getPages(), JSON.toJSONString(resp));
		List<PrestoreModel> prestoreList = resp.getList();
	}
	
	public static void main(String[] args) {
		// 余额查询
//		getBalance();
		// 余额查询(分账户返回余额)
//		getBalanceAccount();
		// 预充值汇款账号查询
//		getPrestoreAccount();
		// 创建充值申请
//		addPrestore();
		// 查询充值申请信息
//		getPrestore();
		// 查询充值申请列表
		listPrestore();
	}
	
}
