package com.awaken.imagine.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.awaken.imagine.model.BaseResp;
import com.awaken.imagine.model.contract.AddEmployeeResp;
import com.awaken.imagine.model.contract.EmployeeModel;
import com.awaken.imagine.model.contract.EmployeeSignReq;
import com.awaken.imagine.model.contract.EmployeeUserTokenResp;
import com.awaken.imagine.model.contract.GenerateContractReq;
import com.awaken.imagine.utils.SignUtil;

/**
 * 自由职业者签约相关
 * @author Carry.Liu
 */
public class ContractDemo extends AbstractDemo {

	/**
	 * 添加自由职业者
	 */
	public static void addEmployees() {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setProviderId(PROVIDER_ID);
		employeeModel.setName("王麻子");
		employeeModel.setPhone("1821999xxxx");
		employeeModel.setEmployeeNo("N00001");
		employeeModel.setPapersType(0);
		employeeModel.setPapersNo("44068319970627xxxx");
//		employeeModel.setBankCardNo("");
//		employeeModel.setBankPhone("");
		employeeModel.setExtra("{\"orderId\":\"123\"}");
		employeeModel.setNonce(getUUid());
		employeeModel.setSign(SignUtil.createSign(employeeModel, APP_KEY));
		String result = doPostJson(API_CONTRACT_ADDEMPLOYEES, JSON.toJSONString(employeeModel), getToken());
		System.out.println("result：" + result);
		// result：{"extra":"{\"orderId\":\"123\"}","employeeId":"744972744520630272"}
		AddEmployeeResp resp = JSON.parseObject(result, AddEmployeeResp.class);
		if (resp.getEmployeeId() != null) {
			logger.info("自由职业者添加成功，employeeId：{}", resp.getEmployeeId());
		} else {
			logger.info("自由职业者添加失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 获取自由职业者信息
	 */
	public static void getEmployee() {
		String employeeId = "744972744520630272";
		String result = doGet(API_CONTRACT_GETEMPLOYEE.replace("{employeeId}", employeeId), null, getToken());
		System.out.println("result：" + result);
		EmployeeModel resp = JSON.parseObject(result, EmployeeModel.class);
		if (resp != null && resp.getId() != null && !resp.getId().trim().equals("")) {
			logger.info("获取自由职业者成功，employeeId：{}", resp.getId());
		} else {
			logger.info("获取自由职业者失败");
		}
	}
	
	/**
	 * 获取自由职业者签约userToken，有效期2个小时
	 * 跳转签约页面时使用
	 */
	public static void getUserToken() {
		String employeeId = "744972744520630272";
		String result = doGet(API_CONTRACT_GETUSERTOKEN.replace("{employeeId}", employeeId), null, getToken());
		System.out.println("result：" + result);
		// result：{"userToken":"a0cbbb4065030f8ad73078112eaa6d11","expiresIn":7200}
		EmployeeUserTokenResp resp = JSON.parseObject(result, EmployeeUserTokenResp.class);
		if (resp.getUserToken() != null) {
			logger.info("获取自由职业者token成功，userToken：{}", resp.getUserToken());
		} else {
			logger.info("获取自由职业者token失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 生成签约跳转页面url
	 */
	public static void generateSignUrl() {
		String employeeId = "744972744520630272";
		// 通过getUserToken方法获取token
		String userToken = "f7236d53530e9e470f286f852a06f72d";
		StringBuffer urlSb = new StringBuffer(SIGN_URL);
		urlSb.append("?employeeId=" + employeeId);
		urlSb.append("&corpId=" + CORP_ID);
		urlSb.append("&userToken=" + userToken);
		urlSb.append("&callbackUrl=https://www.baidu.com");
		urlSb.append("#contract_sign_page");
		System.out.println("signUrl：" + urlSb.toString());
	}
	
	/**
	 * 生成合同
	 */
	public static void generateContract() {
		String employeeId = "744972744520630272";
		// 通过getUserToken方法获取token
		String userToken = "f7236d53530e9e470f286f852a06f72d";
		GenerateContractReq req = new GenerateContractReq();
		req.setEmployeeId(employeeId);
		req.setUserToken(userToken);
		req.setBankCardNo("6217857500004xxxxxx");
		// 建议照片大小控制在100kb-300kb
		req.setIdCardFrontBase64("data:image/png;base64,iVBORw..."); // 身份证正面照片base64字符 
		req.setIdCardBackBase64("data:image/png;base64,iVBORw..."); // 身份证反面照片base64字符
		String result = doPostJson(API_CONTRACT_GENERATE, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		BaseResp resp = JSON.parseObject(result, BaseResp.class);
		if (!resp.getError().equals(ERROR_BASE)) {
			logger.info("生成合同成功");
		} else {
			logger.info("生成合同失败，error：{}", resp.getMessage());
		}
	}
	
	/**
	 * 快捷签约（静默签约）
	 */
	public static void sign() {
		EmployeeSignReq req = new EmployeeSignReq();
		req.setProviderId(PROVIDER_ID);
		// 项目id（可选）
//		req.setProjectId("");
		req.setEmployeeNo("N00002");
		req.setName("张黑子");
		req.setPhone("1821999xxxx");
		req.setPapersNo("43112619850824xxxx");
		req.setBankCardNo("6217857500004xxxxxx"); // 银行卡号（可选）
		req.setBankName("中国农业银行"); // 银行名称（可选，与银行卡号一起）
		// 建议照片大小控制在100kb-300kb
		req.setIdCardFrontBase64("data:image/png;base64,iVBORw..."); // 身份证正面照片base64字符 
		req.setIdCardBackBase64("data:image/png;base64,iVBORw..."); // 身份证反面照片base64字符
		req.setNotifyUrl("https://www.baidu.com");
		String result = doPostJson(API_CONTRACT_SIGN, JSON.toJSONString(req), getToken());
		System.out.println("result：" + result);
		// result：{"employeeId":"722517982860804295","employeeNo":"N00002"}
		JSONObject resp = JSON.parseObject(result);
		String employeeId = resp.getString("employeeId");
		if (employeeId != null) {
			logger.info("快捷签约成功");
		} else {
			logger.info("快捷签约失败，error：{}", resp.getString("message"));
		}
	}
	
	public static void main(String[] args) {
		// 添加自由职业者
//		addEmployees();
		// 获取自由职业者信息
		getEmployee();
		// 获取自由职业者签约userToken
//		getUserToken();
		// 生成签约跳转页面url
//		generateSignUrl();
		// 生成合同
//		generateContract();
		// 快捷签约（静默签约）
//		sign();
	}
	
	
}
