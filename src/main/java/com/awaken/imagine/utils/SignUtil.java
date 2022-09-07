package com.awaken.imagine.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * gzlle-api参数签名
 */
public class SignUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

	/**
	 * 获取对象字段名数组
	 * @param o
	 * @return
	 */
    private static String[] getFiledName(Object o) {
        Class tempClass = o.getClass();
        List<String> fieldNameList = new ArrayList<>();
        //递归获取该类包括父类在内的所有field
        while (tempClass != null) {
            Field[] fields = tempClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                fieldNameList.add(fields[i].getName());
            }
            tempClass = tempClass.getSuperclass();
        }
        String[] fieldNames = new String[fieldNameList.size()];
        fieldNameList.toArray(fieldNames);
        return fieldNames;
    }

    /**
     * 根据对象字段名获取值
     * @param fieldName 字段名
     * @param o
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成签名字符串
     * @param object 待签名对象
     * @param key
     * @return
     */
    public static String createSign(Object object, String key) {
        SortedMap<String, String> sortedMap = getSortedMap(object);
        String sortedString = getSortedString(sortedMap, key);
        String sign = sha256HMAC(sortedString, key);
        logger.info("===签名字符串：{}，签名结果sign：{}", sortedString, sign);
        return sign;
    }

    /**
     * 生成签名字符串
     * @param parameters 待签名map参数
     * @param key
     * @return
     */
    public static String createSign(SortedMap<String, String> parameters, String key) {
        String sortedString = getSortedString(parameters, key);
        String sign = sha256HMAC(sortedString, key);
        logger.info("===签名字符串：{}，签名结果sign：{}", sortedString, sign);
        return sign;
    }

    /**
     * 参数排序
     * @param object
     * @return
     */
    public static SortedMap<String, String> getSortedMap(Object object) {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        String[] fieldNames = getFiledName(object);
        String tmp = "";
        Object obj = null;
        for (int j = 0; j < fieldNames.length; j++) {
            String name = fieldNames[j];
            obj = getFieldValueByName(name, object);
            if (obj == null) {
                continue;
            }
            tmp = String.valueOf(obj);
            if (null != tmp && !tmp.trim().equals("")) {
                sortedMap.put(name, tmp);
            }
        }
        return sortedMap;
    }

    /**
     * 参数排序拼接字符串（末尾拼接key）
     * @param parameters
     * @param key
     * @return
     */
    public static String getSortedString(SortedMap<String, String> parameters, String key) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        return sb.toString();
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    /**
     * sha256_HMAC加密
     *
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    private static String sha256HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            logger.error("###error，HmacSHA256加密异常，message：{}，secret：{}，异常：{}", message, secret, e.getMessage());
        }
        return hash;
    }

    public static void main(String[] args) {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("contactAddress", "湖南长沙");
        sortedMap.put("nonce", "290498c05583bb8396ac3d263b8ece82");
        sortedMap.put("name", "令狐冲");
        sortedMap.put("phone", "15000000001");
        sortedMap.put("papersNo", "430703199999999999");
        String sign = createSign(sortedMap, "687724246335488000");
        System.out.println("sign：" + sign);
    }

}
