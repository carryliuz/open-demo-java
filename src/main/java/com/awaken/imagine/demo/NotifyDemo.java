package com.awaken.imagine.demo;

import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.awaken.imagine.model.contract.EmployeeModel;
import com.awaken.imagine.model.order.OrderModel;
import com.awaken.imagine.utils.SignUtil;

/**
 * 异步通知
 * @author Carry.Liu
 */
@RestController
@RequestMapping("/notify")
public class NotifyDemo extends AbstractDemo {

	/**
	 * 回调统一处理
	 * @param body
	 * @return
	 * @throws Exception
	 */
    @PostMapping("/callback/gzlle")
    public String callbackGzlle(@RequestBody String body) throws Exception {
    	logger.info("=============gzlle回调通知，body：{}", body);
    	if (body == null || body.trim().equals("")) {
    		throw new Exception("回调通知参数为空");
    	}
    	// 验签，校验参数是否被篡改
    	JSONObject bodyJson = JSON.parseObject(body);
    	SortedMap<String, String> signMap = new TreeMap<>();
    	bodyJson.getInnerMap().forEach((k, v) -> signMap.put(k, String.valueOf(v)));
    	String notifySign = bodyJson.getString("sign");
    	String sign = SignUtil.createSign(signMap, APP_KEY);
    	if (!notifySign.equals(sign)) {
    		throw new Exception("验签失败");
    	}
    	
    	// 通知类型：1职业职业者签约状态通知，2提现状态通知，3批量订单状态通知，4充值状态通知，5开票状态通知
    	Integer notifyType = bodyJson.getInteger("noticeType");
    	try {
			// 平台处理业务
    		if (notifyType == 1) {
    			logger.info("开始处理签约回调通知");
    			EmployeeModel employeeModel = JSON.parseObject(body, EmployeeModel.class);
    			processSign(employeeModel);
    			
    		} else if (notifyType == 2) {
    			logger.info("开始处理提现回调通知");
    			OrderModel orderModel = JSON.parseObject(body, OrderModel.class);
    			processOrder(orderModel);
    			
    		} else if (notifyType == 3) {
    			logger.info("开始处理批量订单回调通知");
    			
    		} else if (notifyType == 4) {
    			logger.info("开始处理充值回调通知");
    			processPrestore();
    			
    		} else if (notifyType == 5) {
    			logger.info("开始处理开票回调通知");
    			
    		}
    		
		} catch (Exception e) {
			// 被通知方本地业务处理异常，由被通知方自行捕获处理
			logger.error("业务处理异常");
			e.printStackTrace();
		}
    	logger.info("=============gzlle回调通知，处理完成");
        return "success";
    }
	
    private void processSign(EmployeeModel employeeModel) {
    	// TODO 处理签约相关业务
    	
    }
    
    private void processOrder(OrderModel orderModel) {
    	// TODO 处理提现相关业务
    	
    }
    
    private void processPrestore() {
    	// TODO 处理充值相关业务
    	
    }
    
}
