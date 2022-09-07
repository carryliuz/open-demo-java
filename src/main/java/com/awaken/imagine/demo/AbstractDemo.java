package com.awaken.imagine.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.awaken.imagine.model.AccessTokenModel;
import com.awaken.imagine.utils.HttpUtil;

/**
 * @author Carry.Liu
 */
public class AbstractDemo {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractDemo.class);

	/* 对接参数，联系职乐技术人员获取 */
	public static final String APP_KEY = "687724246335488000";
	public static final String APP_SECRET = "2C8C3BA3052FE5764F469DA4754F57D9";
	public static final String PROVIDER_ID = "686873738108469248"; // 服务商ID
	public static final String CORP_ID = "684061554710151168"; // 企业主体ID
	
	/* token */
	private static final String AUTHORIZATION = "Authorization";
	private static final String BEARER = "Bearer ";
	
	/* 请求url，此处为测试域名，正式域名请联系职乐技术获取 */
	private static final String BASE_URL = "http://openapi-test.gzlle.com";
	protected static final String SIGN_URL = "​https://webapp-test.gzlle.com/contract-open/spa.html";
	/* 请求api-签约相关 */
	protected static final String API_TOKEN = "/token"; // 获取token令牌
	protected static final String API_CONTRACT_ADDEMPLOYEES = "/contracts/employees/add"; // 添加自由职业者
	protected static final String API_CONTRACT_GETUSERTOKEN = "/contracts/employees/userToken/{employeeId}"; // 获取自由职业者签约userToken
	protected static final String API_CONTRACT_GETEMPLOYEE = "/contracts/get/{employeeId}"; // 获取自由职业者信息
	protected static final String API_CONTRACT_GENERATE = "/contracts/employees/generate"; // 生成合同
	protected static final String API_CONTRACT_SIGN = "/contracts/employees/sign"; // 快捷签约
	protected static final String API_CONTRACT_LISTEMPLOYEES = "/contracts/employees/list"; // 查询自由职业者列表
	/* 请求api-提现订单相关 */
	protected static final String API_ORDER_ADD = "/orders/add"; // 添加提现订单
	protected static final String API_ORDER_GET = "/orders/get/{tradeNo}"; // 查询订单详情
	protected static final String API_ORDER_LIST = "/orders/list"; // 查询订单列表
	protected static final String API_ORDER_ADDHISTORY = "/orders/history/add"; // 历史订单同步
	/* 请求api-账户相关 */
	protected static final String API_ACCOUNT_GETBALANCE = "/account/balance/{providerId}"; // 余额查询(所有账户余额汇总)
	protected static final String API_ACCOUNT_GETBALANCEACCOUNT = "/account/balanceAccount/{providerId}"; // 余额查询(分账户返回余额)
	protected static final String API_ACCOUNT_GETPRESTOREACCOUNT = "/account/prestore/providerAccount/{providerId}"; // 预充值汇款账号查询
	protected static final String API_ACCOUNT_ADDPRESTORE = "/account/prestore/add"; // 创建充值申请
	protected static final String API_ACCOUNT_GETPRESTORE = "/account/prestore/get/{id}"; // 查询充值详情
	protected static final String API_ACCOUNT_LISTPRESTORE = "/account/prestore/list"; // 查询充值申请列表
	/* 请求api-发票相关 */
	protected static final String API_INVOICE_GETSETTING = "/invoice/setting/get/{providerId}"; // 查询开票配置
	protected static final String API_INVOICE_LISTORDER = "/invoice/order/list"; // 查询开票订单列表
	protected static final String API_INVOICE_ADDBATCH = "/invoice/batch/add"; // 创建发票申请
	protected static final String API_INVOICE_LISTBATCH = "/invoice/batch/list"; // 查询发票申请列表
	
	/* 错误码 */
	protected static final String ERROR_BASE = "BadRequest";
	
	/**
	 * 获取token令牌
	 * token有效期2小时，建议获取后放入缓存，失效后再重新获取
	 * @return
	 */
	public static String getToken() {
		try {
			// TODO 从缓存获取token，如果已失效则从接口远程获取
			
			Map<String, String> reqParam = new HashMap<String, String>();
			reqParam.put("appKey", APP_KEY);
			reqParam.put("appSecret", APP_SECRET);
			reqParam.put("grantType", "client_credentials");
			String result = doPostJson(API_TOKEN, JSON.toJSONString(reqParam), null);
			if (result == null || result.trim().equals("")) {
				logger.info("###获取token失败，请检查请求参数");
				return null;
			}
			String token = JSON.parseObject(result, AccessTokenModel.class).getAccessToken();
			if (token != null && !token.trim().equals("")) {
				// TODO 将token存入缓存，存放时间不超过2小时
				return token;
			} else {
				logger.info("###获取token失败，请检查请求参数");
			}
		} catch (Exception e) {
			logger.error("###error，获取token失败", e);
		}
		return null;
//		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiaW1hZ2luZS1tYWluIiwiaW1hZ2luZS1vcGVuIiwiaW1hZ2luZS1hdXRoIl0sInNjb3BlIjpbInByb2ZpbGUiXSwiZXhwIjoxNjYyNTQ1Njk5LCJqdGkiOiI2NGJjZjU3My00MmU4LTRmZmYtYjUxYi02ZmE5MWEzYzYyMzAiLCJjbGllbnRfaWQiOiI2ODc3MjQyNDYzMzU0ODgwMDAifQ.canVZghnXgzb72Hrc5ZR0xnE9H7cgctX0iwvl49vsS5vPpksvyNAQnkFIpwpNzyxath0ovqiSvVmEy_DKKZ4_vv3sWYAjC9ciwfoi9K6w4gkkyFuyC4lu3F1x8Q9BFWrb1lkZ-tTUE3UiqznKYiPXfWBMQRrJRE19F8lbn20Q3Q";
//		return token;
	}
	
	public static String doPostJson(String api, String jsonParam, String token) {
		logger.info("###gzlle-open请求，api：{}，jsonParam：{}", api, jsonParam);
		String result = HttpUtil.doPost(BASE_URL + api, jsonParam, token != null ? new LinkedHashMap<String, String>() {{put(AUTHORIZATION, BEARER + token);}} : null);
		logger.info("###gzlle-open响应，api：{}，result：{}", api, result);
		return result;
	}
	
	public static String doGet(String api, Map<String, String> queryParam, String token) {
		logger.info("###gzlle-open请求，api：{}，queryParam：{}", api, JSON.toJSONString(queryParam));
		String result = HttpUtil.doGet(BASE_URL + api, token != null ? new LinkedHashMap<String, String>() {{put(AUTHORIZATION, BEARER + token);}} : null, queryParam);
		logger.info("###gzlle-open响应，api：{}，result：{}", api, result);
		return result;
	}
	
	public static String getUUid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getToken());
	}
	
}
