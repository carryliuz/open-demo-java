package com.awaken.imagine.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.awaken.imagine.model.PageResult;
import com.awaken.imagine.model.invoice.InvoiceBatchModel;
import com.awaken.imagine.model.invoice.InvoiceBatchQuery;
import com.awaken.imagine.model.invoice.InvoiceDetailContentModel;
import com.awaken.imagine.model.invoice.InvoiceDetailModel;
import com.awaken.imagine.model.invoice.InvoiceOrderModel;
import com.awaken.imagine.model.invoice.InvoiceOrderQuery;
import com.awaken.imagine.model.invoice.InvoiceSettingModel;

/**
 * 发票
 * @author Carry.Liu
 */
public class InvoiceDemo extends AbstractDemo {

	/**
	 * 查询开票配置
	 */
	public static void getBalance() {
		String result = doGet(API_INVOICE_GETSETTING.replace("{providerId}", PROVIDER_ID), null, getToken());
		System.out.println("result：" + result);
		InvoiceSettingModel resp = JSON.parseObject(result, InvoiceSettingModel.class);
		if (resp.getProviderId() != null) {
			logger.info("查询开票配置成功，providerId：{}", resp.getProviderId());
		} else {
			logger.info("查询开票配置，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 查询开票订单列表
	 */
	public static void listInvoiceOrder() {
		InvoiceOrderQuery req = new InvoiceOrderQuery();
		req.setProviderId(PROVIDER_ID);
		req.setStatus(10);
//		req.setStartDate("20220801");
//		req.setEndDate("20220906");
//		req.setPageNum(1); // 页码，默认1
		req.setPageSize(5); // 每页行数，默认10
		String result = doPostJson(API_INVOICE_LISTORDER, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		PageResult<InvoiceOrderModel> resp = JSON.parseObject(result, PageResult.class);
		logger.info("查询开票订单列表，总页数：{}，resp：{}", resp.getPages(), JSON.toJSONString(resp));
		List<InvoiceOrderModel> invoiceOrderList = resp.getList();
	}
	
	/**
	 * 创建发票申请
	 * 该接口有ip白名单校验
	 */
	public static void addInvoiceBatch() {
		InvoiceBatchModel req = new InvoiceBatchModel();
		req.setProviderId(PROVIDER_ID);
		req.setBatchNo(String.valueOf(System.currentTimeMillis())); // 批次号，每次请求唯一
		req.setCorpName("企业抬头名称");
		req.setBizLicenseCode("91110105306000000A"); // 信用代码
		req.setInvoiceType(1); // 发票类型: 0 企业增值税普通发票  1 增值税专用发票
		req.setBank("中国农业银行");
		req.setBankNo("6228480038789xxxxxx");
		req.setRegisteredAddress("北京市朝阳区三里屯街区001号");
		req.setRegisteredPhone("1821701xxxx");
		req.setExpressName("张三");
		req.setExpressPhone("1821701xxxx");
		req.setExpressPostcode("100100");
		req.setExpressAddress("收件详细地址1");
//		req.setEmail("123@163.com"); // 邮箱地址
		req.setInvoiceOrderIdList(Arrays.asList("728292076315213824")); // 此处为开票订单id
		req.setNotifyUrl("https://www.baidu.com");
		
		InvoiceDetailModel invoiceDetailModel = new InvoiceDetailModel();
		invoiceDetailModel.setDetailNo("D00001");
		invoiceDetailModel.setContentList(new ArrayList<InvoiceDetailContentModel>() {{
			add(new InvoiceDetailContentModel(new BigDecimal("0.15"), "*现代服务*技术开发费"));
			add(new InvoiceDetailContentModel(new BigDecimal("0.05"), "*现代服务*软件服务费"));
		}});
		req.setDetailList(Arrays.asList(invoiceDetailModel));
		
		String result = doPostJson(API_INVOICE_ADDBATCH, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		InvoiceBatchModel resp = JSON.parseObject(result, InvoiceBatchModel.class);
		if (resp.getId() != null) {
			logger.info("创建发票申请成功，invoiceBatchId：{}", resp.getId());
		} else {
			logger.info("创建发票申请失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 查询发票申请列表
	 */
	public static void listInvoiceBatch() {
		InvoiceBatchQuery req = new InvoiceBatchQuery();
		req.setProviderId(PROVIDER_ID);
		req.setBatchNo("1662538675449");
//		req.setStartDate("20220801");
//		req.setEndDate("20220906");
//		req.setPageNum(1); // 页码，默认1
//		req.setPageSize(5); // 每页行数，默认10
		String result = doPostJson(API_INVOICE_LISTBATCH, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		PageResult<InvoiceBatchModel> resp = JSON.parseObject(result, PageResult.class);
		logger.info("查询开票订单列表，总页数：{}，resp：{}", resp.getPages(), JSON.toJSONString(resp));
		List<InvoiceBatchModel> invoiceBatchList = resp.getList();
	}
	public static void main(String[] args) {
		// 查询开票配置
//		getBalance();
		// 查询开票订单列表
//		listInvoiceOrder();
		// 创建发票申请
//		addInvoiceBatch();
		// 查询发票申请列表
		listInvoiceBatch();
	}
	
}
