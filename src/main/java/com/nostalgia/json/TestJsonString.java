package com.nostalgia.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/7/31
 * @description
 */
public class TestJsonString {


    @Test
    public void run(){
        System.out.println(System.currentTimeMillis());

    }

    @Test
    public void run1(){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("method","qihoo.sdk.user.partner.login");
        Map<String,String> bizContent = new HashMap<>();
        bizContent.put("partnerCode","RZJ");
        bizContent.put("mobileNo","18665961368");
        bizContent.put("authenticationToken","40277147255b427aa87381ec0c0e47d1");
        bizContent.put("geoInfo",null);

        requestMap.put("bizContent",bizContent);
        requestMap.put("appVersion","1.0.1");
        requestMap.put("channelSource","CH_001");
        requestMap.put("charset","UTF-8");

        Map<String,String> deviceInfo = new HashMap<>();
        deviceInfo.put("terminalType","APP");
        deviceInfo.put("deviceSn","POSTMAN1-F54E-4A67-9E0F-E70B51EB6265");
        deviceInfo.put("deviceOs","ios");
        deviceInfo.put("deviceOsVersion","v4.2");
        requestMap.put("deviceInfo",deviceInfo);

        requestMap.put("hostApp","360MSG");
        requestMap.put("productCode","360HAOJIE");
        requestMap.put("signType","RSA");
        requestMap.put("sourceType","SDK");
        requestMap.put("version","1.0.0");
        requestMap.put("timestamp",System.currentTimeMillis()+"");

        Map<String, String> bizContentMap = (Map<String, String>)requestMap.get("bizContent");


    }

    @Test
    public void run2(){
        HashMap<String,Object> dataMap = new HashMap();
        HashMap<String,String> input = new HashMap();
        input.put("mobileNo","13838389438");
        input.put("partnerCode","weilaijishi");
        dataMap.put("input",input);
        System.out.println(JSON.toJSONString(dataMap));



    }



    @Test
    public void run3(){

        HashMap<String,String> input = new HashMap();
        input.put("mobileNo","13838389438");
        input.put("partnerCode","weilaijishi");
        input.put("nullString",null);
        System.out.println(JSON.toJSONString(input));















    }


    @Test
    public void run4(){
        /*String jsonStr = "{\"activityInfo\":\"null\",\"appName\":\"null\",\"appVersion\":\"1.6.5\",\"bizContent\":\"{\\\"partnerCode\\\":\\\"weilaijishi\\\",\\\"mobileNo\\\":\\\"15635784526\\\",\\\"authenticationToken\\\":\\\"0e26327c17204819ab73e96e8e842386\\\",\\\"geoInfo\\\":\\\"{\\\\\\\"longitude\\\\\\\":\\\\\\\"113.960175\\\\\\\",\\\\\\\"latitude\\\\\\\":\\\\\\\"22.542666\\\\\\\",\\\\\\\"country\\\\\\\":\\\\\\\"中国\\\\\\\",\\\\\\\"city\\\\\\\":\\\\\\\"深圳市\\\\\\\",\\\\\\\"province\\\\\\\":\\\\\\\"广东省\\\\\\\",\\\\\\\"district\\\\\\\":\\\\\\\"南山区\\\\\\\",\\\\\\\"addrInfo\\\\\\\":\\\\\\\"广东省深圳市南山区科技南十+路\\\\\\\"}\\\",\\\"deviceTokenInfo\\\":\\\"{\\\\\\\"mobile\\\\\\\":\\\\\\\"13899786678\\\\\\\",\\\\\\\"carrier\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"basebandVersion\\\\\\\":\\\\\\\"-8976_GEN_PACK-1.59907.1.60121.1\\\\\\\",\\\\\\\"mcc\\\\\\\":\\\\\\\"460\\\\\\\",\\\\\\\"mnc\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"cellLocation\\\\\\\":\\\\\\\"9526\\\\\\\",\\\\\\\"cellIp\\\\\\\":\\\\\\\"111843845\\\\\\\",\\\\\\\"simSerial\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"serialNo\\\\\\\":\\\\\\\"dfebed7\\\\\\\",\\\\\\\"deviceMobileNum\\\\\\\":\\\\\\\"+8618576626946\\\\\\\",\\\\\\\"udid\\\\\\\":\\\\\\\"de4a07e1c05b20d0\\\\\\\",\\\\\\\"deviceName\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"deviceBand\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"deviceModel\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"cpuAbi\\\\\\\":\\\\\\\"armeabi-v7a\\\\\\\",\\\\\\\"cpuSerial\\\\\\\":\\\\\\\"0000000000000000\\\\\\\",\\\\\\\"screenRes\\\\\\\":\\\\\\\"1080x1920\\\\\\\",\\\\\\\"totalMemory\\\\\\\":\\\\\\\"3785011200\\\\\\\",\\\\\\\"availableMemery\\\\\\\":\\\\\\\"1639641088\\\\\\\",\\\\\\\"SDTotalSize\\\\\\\":\\\\\\\"119060455424\\\\\\\",\\\\\\\"availableStorage\\\\\\\":\\\\\\\"90781839360\\\\\\\",\\\\\\\"wifiMac\\\\\\\":\\\\\\\"3CB6B75AA1A8\\\\\\\",\\\\\\\"wifiIp\\\\\\\":\\\\\\\"148.10.168.192\\\\\\\",\\\\\\\"isVpnUsed\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"gateway\\\\\\\":\\\\\\\"1.10.168.192\\\\\\\",\\\\\\\"dnsAddress\\\\\\\":\\\\\\\"133.134.96.202;86.128.96.202\\\\\\\",\\\\\\\"startTime\\\\\\\":\\\\\\\"603638640\\\\\\\",\\\\\\\"uptime\\\\\\\":\\\\\\\"206535500\\\\\\\",\\\\\\\"isRoot\\\\\\\":\\\\\\\"N\\\\\\\",\\\\\\\"currentTime\\\\\\\":\\\\\\\"2016-08-10+15:19:53\\\\\\\",\\\\\\\"networkType\\\\\\\":\\\\\\\"WIFI\\\\\\\",\\\\\\\"osVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"bundleId\\\\\\\":\\\\\\\"LMY47V\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"c43ddcc44bedc4c1c96b2e09ebbe5456\\\\\\\",\\\\\\\"os\\\\\\\":\\\\\\\"Android\\\\\\\",\\\\\\\"trueIp\\\\\\\":\\\\\\\"192.168.10.148\\\\\\\",\\\\\\\"userAgent\\\\\\\":\\\\\\\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\\\\\\\",\\\\\\\"countryIso\\\\\\\":\\\\\\\"cn\\\\\\\",\\\\\\\"display\\\\\\\":\\\\\\\"LMY47V+release-keys\\\\\\\",\\\\\\\"firmVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"hardware\\\\\\\":\\\\\\\"qcom\\\\\\\",\\\\\\\"host\\\\\\\":\\\\\\\"compiler01104\\\\\\\",\\\\\\\"language\\\\\\\":\\\\\\\"zh\\\\\\\",\\\\\\\"model\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"product\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roDevice\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roName\\\\\\\":\\\\\\\"compiler\\\\\\\",\\\\\\\"tag\\\\\\\":\\\\\\\"release-keys\\\\\\\",\\\\\\\"board\\\\\\\":\\\\\\\"msm8952\\\\\\\",\\\\\\\"simOperator\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"timeZone\\\\\\\":\\\\\\\"GMT+08:00Asia/Shanghai\\\\\\\",\\\\\\\"brightness\\\\\\\":\\\\\\\"98\\\\\\\",\\\\\\\"ssid\\\\\\\":\\\\\\\"\\\\\\\\\\\\\\\"qibu-dev\\\\\\\\\\\\\\\"\\\\\\\",\\\\\\\"bssid\\\\\\\":\\\\\\\"74:3e:2b:4f:27:c8\\\\\\\",\\\\\\\"iccid\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"manufacturer\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"density\\\\\\\":\\\\\\\"3.0\\\\\\\",\\\\\\\"deviceType\\\\\\\":\\\\\\\"mobilephone\\\\\\\",\\\\\\\"cpuCount\\\\\\\":\\\\\\\"8\\\\\\\",\\\\\\\"cpuHardware\\\\\\\":\\\\\\\"Qualcomm+Technologies,+Inc+MSM8976\\\\\\\",\\\\\\\"cpuSpeed\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"blueMac\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"00000000-78ef-1565-be24-15520b102783\\\\\\\",\\\\\\\"imei\\\\\\\":\\\\\\\"860576034610459\\\\\\\",\\\\\\\"imsi+\\\\\\\":\\\\\\\"460016627505874\\\\\\\",\\\\\\\"clientMac\\\\\\\":\\\\\\\"3cb6b75aa1a8\\\\\\\",\\\\\\\"buildSeril\\\\\\\":\\\\\\\"dfebed7\\\\\\\"}\\\"}\",\"channelId\":\"APK_CH_001\",\"channelSource\":\"CH_001\",\"charset\":\"UTF-8\",\"custNo\":\"null\",\"deviceInfo\":\"{\\\"buildSerial\\\":\\\"f11fb8c5c376940af13780e6cc952973\\\",\\\"imsi\\\":\\\"460016627505874\\\",\\\"deviceName\\\":\\\"liao的 iPhone\\\",\\\"wifiMac\\\":\\\"3CB6B75AA1A8\\\",\\\"isJailbreaking\\\":\\\"N\\\",\\\"brand\\\":\\\"iPhone\\\",\\\"deviceSn\\\":\\\"B8451623-E488-8C81-D62A-2843F4E30164\\\",\\\"deviceIp\\\":\\\"192.168.1.185\\\",\\\"uuid\\\":\\\"00000000-78ef-1565-be24-15520b102783\\\",\\\"bssid\\\":\\\"74:3e:2b:f:27:cc\\\",\\\"deviceFingerPrintM2\\\":\\\"68a2ac66-9e23-45dc-b12a-d6777d1f2456\\\",\\\"deviceFingerPrintTd\\\":\\\"ewogICJ0b2tlbklkIiA6ICIzNjBqaWViYmQyNDlkODEwMGIxYTM1ZGE2NDQ4ZDUzYjM0MWZlNyIsCiAgIm9zIiA6ICJpT1MiLAogICJwcm9maWxlVGltZSIgOiA2MDQsCiAgInZlcnNpb24iIDogIjIuMS40Igp9\\\",\\\"wifiName\\\":\\\"qibu-public\\\",\\\"networkType\\\":\\\"WIFI\\\",\\\"model\\\":\\\"iPhone\\\",\\\"deviceOsVersion\\\":\\\"iOS 10.0.2\\\",\\\"isEmulator\\\":\\\"N\\\",\\\"usedStorage\\\":\\\"8.50G\\\",\\\"deviceOs\\\":\\\"IOS\\\",\\\"deviceFingerPrintBr\\\":\\\"-\\\",\\\"terminalType\\\":\\\"app\\\",\\\"totalStorage\\\":\\\"11.04G\\\"}\",\"hostApp\":\"360LOAN\",\"method\":\"qihoo.sdk.user.partner.login\",\"productCode\":\"360JIETIAO\",\"requestIp\":\"121.34.29.23\",\"sign\":\"null\",\"signType\":\"RSA\",\"sourceType\":\"APK\",\"subChannel\":\"null\",\"timestamp\":\"1565253710825\",\"token\":\"null\",\"userNo\":\"null\",\"version\":\"1.6.5\"}";
        //String json = "\"bizContent\":\"{\\\"partnerCode\\\":\\\"weilaijishi\\\",\\\"mobileNo\\\":\\\"15635784526\\\",\\\"authenticationToken\\\":\\\"0e26327c17204819ab73e96e8e842386\\\",\\\"geoInfo\\\":\\\"{\\\\\\\"longitude\\\\\\\":\\\\\\\"113.960175\\\\\\\",\\\\\\\"latitude\\\\\\\":\\\\\\\"22.542666\\\\\\\",\\\\\\\"country\\\\\\\":\\\\\\\"中国\\\\\\\",\\\\\\\"city\\\\\\\":\\\\\\\"深圳市\\\\\\\",\\\\\\\"province\\\\\\\":\\\\\\\"广东省\\\\\\\",\\\\\\\"district\\\\\\\":\\\\\\\"南山区\\\\\\\",\\\\\\\"addrInfo\\\\\\\":\\\\\\\"广东省深圳市南山区科技南十+路\\\\\\\"}\\\",\\\"deviceTokenInfo\\\":\\\"{\\\\\\\"mobile\\\\\\\":\\\\\\\"13899786678\\\\\\\",\\\\\\\"carrier\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"basebandVersion\\\\\\\":\\\\\\\"-8976_GEN_PACK-1.59907.1.60121.1\\\\\\\",\\\\\\\"mcc\\\\\\\":\\\\\\\"460\\\\\\\",\\\\\\\"mnc\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"cellLocation\\\\\\\":\\\\\\\"9526\\\\\\\",\\\\\\\"cellIp\\\\\\\":\\\\\\\"111843845\\\\\\\",\\\\\\\"simSerial\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"serialNo\\\\\\\":\\\\\\\"dfebed7\\\\\\\",\\\\\\\"deviceMobileNum\\\\\\\":\\\\\\\"+8618576626946\\\\\\\",\\\\\\\"udid\\\\\\\":\\\\\\\"de4a07e1c05b20d0\\\\\\\",\\\\\\\"deviceName\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"deviceBand\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"deviceModel\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"cpuAbi\\\\\\\":\\\\\\\"armeabi-v7a\\\\\\\",\\\\\\\"cpuSerial\\\\\\\":\\\\\\\"0000000000000000\\\\\\\",\\\\\\\"screenRes\\\\\\\":\\\\\\\"1080x1920\\\\\\\",\\\\\\\"totalMemory\\\\\\\":\\\\\\\"3785011200\\\\\\\",\\\\\\\"availableMemery\\\\\\\":\\\\\\\"1639641088\\\\\\\",\\\\\\\"SDTotalSize\\\\\\\":\\\\\\\"119060455424\\\\\\\",\\\\\\\"availableStorage\\\\\\\":\\\\\\\"90781839360\\\\\\\",\\\\\\\"wifiMac\\\\\\\":\\\\\\\"3CB6B75AA1A8\\\\\\\",\\\\\\\"wifiIp\\\\\\\":\\\\\\\"148.10.168.192\\\\\\\",\\\\\\\"isVpnUsed\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"gateway\\\\\\\":\\\\\\\"1.10.168.192\\\\\\\",\\\\\\\"dnsAddress\\\\\\\":\\\\\\\"133.134.96.202;86.128.96.202\\\\\\\",\\\\\\\"startTime\\\\\\\":\\\\\\\"603638640\\\\\\\",\\\\\\\"uptime\\\\\\\":\\\\\\\"206535500\\\\\\\",\\\\\\\"isRoot\\\\\\\":\\\\\\\"N\\\\\\\",\\\\\\\"currentTime\\\\\\\":\\\\\\\"2016-08-10+15:19:53\\\\\\\",\\\\\\\"networkType\\\\\\\":\\\\\\\"WIFI\\\\\\\",\\\\\\\"osVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"bundleId\\\\\\\":\\\\\\\"LMY47V\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"c43ddcc44bedc4c1c96b2e09ebbe5456\\\\\\\",\\\\\\\"os\\\\\\\":\\\\\\\"Android\\\\\\\",\\\\\\\"trueIp\\\\\\\":\\\\\\\"192.168.10.148\\\\\\\",\\\\\\\"userAgent\\\\\\\":\\\\\\\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\\\\\\\",\\\\\\\"countryIso\\\\\\\":\\\\\\\"cn\\\\\\\",\\\\\\\"display\\\\\\\":\\\\\\\"LMY47V+release-keys\\\\\\\",\\\\\\\"firmVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"hardware\\\\\\\":\\\\\\\"qcom\\\\\\\",\\\\\\\"host\\\\\\\":\\\\\\\"compiler01104\\\\\\\",\\\\\\\"language\\\\\\\":\\\\\\\"zh\\\\\\\",\\\\\\\"model\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"product\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roDevice\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roName\\\\\\\":\\\\\\\"compiler\\\\\\\",\\\\\\\"tag\\\\\\\":\\\\\\\"release-keys\\\\\\\",\\\\\\\"board\\\\\\\":\\\\\\\"msm8952\\\\\\\",\\\\\\\"simOperator\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"timeZone\\\\\\\":\\\\\\\"GMT+08:00Asia/Shanghai\\\\\\\",\\\\\\\"brightness\\\\\\\":\\\\\\\"98\\\\\\\",\\\\\\\"ssid\\\\\\\":\\\\\\\"\\\\\\\\\\\\\\\"qibu-dev\\\\\\\\\\\\\\\"\\\\\\\",\\\\\\\"bssid\\\\\\\":\\\\\\\"74:3e:2b:4f:27:c8\\\\\\\",\\\\\\\"iccid\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"manufacturer\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"density\\\\\\\":\\\\\\\"3.0\\\\\\\",\\\\\\\"deviceType\\\\\\\":\\\\\\\"mobilephone\\\\\\\",\\\\\\\"cpuCount\\\\\\\":\\\\\\\"8\\\\\\\",\\\\\\\"cpuHardware\\\\\\\":\\\\\\\"Qualcomm+Technologies,+Inc+MSM8976\\\\\\\",\\\\\\\"cpuSpeed\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"blueMac\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"00000000-78ef-1565-be24-15520b102783\\\\\\\",\\\\\\\"imei\\\\\\\":\\\\\\\"860576034610459\\\\\\\",\\\\\\\"imsi+\\\\\\\":\\\\\\\"460016627505874\\\\\\\",\\\\\\\"clientMac\\\\\\\":\\\\\\\"3cb6b75aa1a8\\\\\\\",\\\\\\\"buildSeril\\\\\\\":\\\\\\\"dfebed7\\\\\\\"}\\\"}\",\"channelId\":\"APK_CH_001\",\"channelSource\":\"CH_001\",\"charset\":\"UTF-8\",\"custNo\":\"null\",\"deviceInfo\":\"{\\\"buildSerial\\\":\\\"f11fb8c5c376940af13780e6cc952973\\\",\\\"imsi\\\":\\\"460016627505874\\\",\\\"deviceName\\\":\\\"liao的 iPhone\\\",\\\"wifiMac\\\":\\\"3CB6B75AA1A8\\\",\\\"isJailbreaking\\\":\\\"N\\\",\\\"brand\\\":\\\"iPhone\\\",\\\"deviceSn\\\":\\\"B8451623-E488-8C81-D62A-2843F4E30164\\\",\\\"deviceIp\\\":\\\"192.168.1.185\\\",\\\"uuid\\\":\\\"00000000-78ef-1565-be24-15520b102783\\\",\\\"bssid\\\":\\\"74:3e:2b:f:27:cc\\\",\\\"deviceFingerPrintM2\\\":\\\"68a2ac66-9e23-45dc-b12a-d6777d1f2456\\\",\\\"deviceFingerPrintTd\\\":\\\"ewogICJ0b2tlbklkIiA6ICIzNjBqaWViYmQyNDlkODEwMGIxYTM1ZGE2NDQ4ZDUzYjM0MWZlNyIsCiAgIm9zIiA6ICJpT1MiLAogICJwcm9maWxlVGltZSIgOiA2MDQsCiAgInZlcnNpb24iIDogIjIuMS40Igp9\\\",\\\"wifiName\\\":\\\"qibu-public\\\",\\\"networkType\\\":\\\"WIFI\\\",\\\"model\\\":\\\"iPhone\\\",\\\"deviceOsVersion\\\":\\\"iOS 10.0.2\\\",\\\"isEmulator\\\":\\\"N\\\",\\\"usedStorage\\\":\\\"8.50G\\\",\\\"deviceOs\\\":\\\"IOS\\\",\\\"deviceFingerPrintBr\\\":\\\"-\\\",\\\"terminalType\\\":\\\"app\\\",\\\"totalStorage\\\":\\\"11.04G\\\"}\",\"hostApp\":\"360LOAN\",\"method\":\"qihoo.sdk.user.partner.login\",\"productCode\":\"360JIETIAO\",\"requestIp\":\"121.34.29.23\",\"sign\":\"null\",\"signType\":\"RSA\",\"sourceType\":\"APK\",\"subChannel\":\"null\",\"timestamp\":\"1565253710825\",\"token\":\"null\",\"userNo\":\"null\",\"version\":\"1.6.5\"}";
        JSONObject obj = JSONObject.parseObject(jsonStr);
        JSONObject bizContent = obj.getJSONObject("bizContent");
        System.out.println(bizContent.toJSONString());*/
        String jsonObj = "{\"partnerCode\":\"weilaijishi\",\"geoInfo\":\"{\\\"longitude\\\":\\\"113.960175\\\",\\\"latitude\\\":\\\"22.542666\\\",\\\"country\\\":\\\"中国\\\",\\\"city\\\":\\\"深圳市\\\",\\\"province\\\":\\\"广东省\\\",\\\"district\\\":\\\"南山区\\\",\\\"addrInfo\\\":\\\"广东省深圳市南山区科技南十+路\\\"}\",\"mobileNo\":\"15635784526\",\"authenticationToken\":\"0e26327c17204819ab73e96e8e842386\",\"deviceTokenInfo\":\"{\\\"mobile\\\":\\\"13899786678\\\",\\\"carrier\\\":\\\"ChinaUnicom\\\",\\\"basebandVersion\\\":\\\"-8976_GEN_PACK-1.59907.1.60121.1\\\",\\\"mcc\\\":\\\"460\\\",\\\"mnc\\\":\\\"1\\\",\\\"cellLocation\\\":\\\"9526\\\",\\\"cellIp\\\":\\\"111843845\\\",\\\"simSerial\\\":\\\"89860113851049777700\\\",\\\"serialNo\\\":\\\"dfebed7\\\",\\\"deviceMobileNum\\\":\\\"+8618576626946\\\",\\\"udid\\\":\\\"de4a07e1c05b20d0\\\",\\\"deviceName\\\":\\\"vivo+X6S+A\\\",\\\"deviceBand\\\":\\\"vivo\\\",\\\"deviceModel\\\":\\\"vivo+X6S+A\\\",\\\"cpuAbi\\\":\\\"armeabi-v7a\\\",\\\"cpuSerial\\\":\\\"0000000000000000\\\",\\\"screenRes\\\":\\\"1080x1920\\\",\\\"totalMemory\\\":\\\"3785011200\\\",\\\"availableMemery\\\":\\\"1639641088\\\",\\\"SDTotalSize\\\":\\\"119060455424\\\",\\\"availableStorage\\\":\\\"90781839360\\\",\\\"wifiMac\\\":\\\"3CB6B75AA1A8\\\",\\\"wifiIp\\\":\\\"148.10.168.192\\\",\\\"isVpnUsed\\\":\\\"false\\\",\\\"gateway\\\":\\\"1.10.168.192\\\",\\\"dnsAddress\\\":\\\"133.134.96.202;86.128.96.202\\\",\\\"startTime\\\":\\\"603638640\\\",\\\"uptime\\\":\\\"206535500\\\",\\\"isRoot\\\":\\\"N\\\",\\\"currentTime\\\":\\\"2016-08-10+15:19:53\\\",\\\"networkType\\\":\\\"WIFI\\\",\\\"osVersion\\\":\\\"5.1.1\\\",\\\"bundleId\\\":\\\"LMY47V\\\",\\\"deviceId\\\":\\\"c43ddcc44bedc4c1c96b2e09ebbe5456\\\",\\\"os\\\":\\\"Android\\\",\\\"trueIp\\\":\\\"192.168.10.148\\\",\\\"userAgent\\\":\\\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\\\",\\\"countryIso\\\":\\\"cn\\\",\\\"display\\\":\\\"LMY47V+release-keys\\\",\\\"firmVersion\\\":\\\"5.1.1\\\",\\\"hardware\\\":\\\"qcom\\\",\\\"host\\\":\\\"compiler01104\\\",\\\"language\\\":\\\"zh\\\",\\\"model\\\":\\\"vivo+X6S+A\\\",\\\"product\\\":\\\"PD1415BA\\\",\\\"roDevice\\\":\\\"PD1415BA\\\",\\\"roName\\\":\\\"compiler\\\",\\\"tag\\\":\\\"release-keys\\\",\\\"board\\\":\\\"msm8952\\\",\\\"simOperator\\\":\\\"ChinaUnicom\\\",\\\"timeZone\\\":\\\"GMT+08:00Asia/Shanghai\\\",\\\"brightness\\\":\\\"98\\\",\\\"ssid\\\":\\\"\\\\\\\"qibu-dev\\\\\\\"\\\",\\\"bssid\\\":\\\"74:3e:2b:4f:27:c8\\\",\\\"iccid\\\":\\\"89860113851049777700\\\",\\\"manufacturer\\\":\\\"vivo\\\",\\\"density\\\":\\\"3.0\\\",\\\"deviceType\\\":\\\"mobilephone\\\",\\\"cpuCount\\\":\\\"8\\\",\\\"cpuHardware\\\":\\\"Qualcomm+Technologies,+Inc+MSM8976\\\",\\\"cpuSpeed\\\":\\\"\\\",\\\"blueMac\\\":\\\"\\\",\\\"uuid\\\":\\\"00000000-78ef-1565-be24-15520b102783\\\",\\\"imei\\\":\\\"860576034610459\\\",\\\"imsi+\\\":\\\"460016627505874\\\",\\\"clientMac\\\":\\\"3cb6b75aa1a8\\\",\\\"buildSeril\\\":\\\"dfebed7\\\"}\"}";
        JSONObject stringObj = JSONObject.parseObject(jsonObj);
        System.out.println(stringObj.toJSONString());
        UnionLoginInputVO vo2 = JSON.parseObject(jsonObj, new TypeReference<UnionLoginInputVO>() {
        });
        System.out.println(vo2);
        /*UnionLoginInputVO vo = JSONObject.toJavaObject(stringObj, UnionLoginInputVO.class);
        System.out.println(vo);
        System.out.println(vo.getGeoInfo().getLongitude());*/


    }


    @Test
    public void run5(){
        String jsonObj = "{\"partnerCode\":\"weilaijishi\",\"geoInfo\":\"{\\\"longitude\\\":\\\"113.960175\\\",\\\"latitude\\\":\\\"22.542666\\\",\\\"country\\\":\\\"中国\\\",\\\"city\\\":\\\"深圳市\\\",\\\"province\\\":\\\"广东省\\\",\\\"district\\\":\\\"南山区\\\",\\\"addrInfo\\\":\\\"广东省深圳市南山区科技南十+路\\\"}\",\"mobileNo\":\"15635784526\",\"authenticationToken\":\"0e26327c17204819ab73e96e8e842386\",\"deviceTokenInfo\":\"{\\\"mobile\\\":\\\"13899786678\\\",\\\"carrier\\\":\\\"ChinaUnicom\\\",\\\"basebandVersion\\\":\\\"-8976_GEN_PACK-1.59907.1.60121.1\\\",\\\"mcc\\\":\\\"460\\\",\\\"mnc\\\":\\\"1\\\",\\\"cellLocation\\\":\\\"9526\\\",\\\"cellIp\\\":\\\"111843845\\\",\\\"simSerial\\\":\\\"89860113851049777700\\\",\\\"serialNo\\\":\\\"dfebed7\\\",\\\"deviceMobileNum\\\":\\\"+8618576626946\\\",\\\"udid\\\":\\\"de4a07e1c05b20d0\\\",\\\"deviceName\\\":\\\"vivo+X6S+A\\\",\\\"deviceBand\\\":\\\"vivo\\\",\\\"deviceModel\\\":\\\"vivo+X6S+A\\\",\\\"cpuAbi\\\":\\\"armeabi-v7a\\\",\\\"cpuSerial\\\":\\\"0000000000000000\\\",\\\"screenRes\\\":\\\"1080x1920\\\",\\\"totalMemory\\\":\\\"3785011200\\\",\\\"availableMemery\\\":\\\"1639641088\\\",\\\"SDTotalSize\\\":\\\"119060455424\\\",\\\"availableStorage\\\":\\\"90781839360\\\",\\\"wifiMac\\\":\\\"3CB6B75AA1A8\\\",\\\"wifiIp\\\":\\\"148.10.168.192\\\",\\\"isVpnUsed\\\":\\\"false\\\",\\\"gateway\\\":\\\"1.10.168.192\\\",\\\"dnsAddress\\\":\\\"133.134.96.202;86.128.96.202\\\",\\\"startTime\\\":\\\"603638640\\\",\\\"uptime\\\":\\\"206535500\\\",\\\"isRoot\\\":\\\"N\\\",\\\"currentTime\\\":\\\"2016-08-10+15:19:53\\\",\\\"networkType\\\":\\\"WIFI\\\",\\\"osVersion\\\":\\\"5.1.1\\\",\\\"bundleId\\\":\\\"LMY47V\\\",\\\"deviceId\\\":\\\"c43ddcc44bedc4c1c96b2e09ebbe5456\\\",\\\"os\\\":\\\"Android\\\",\\\"trueIp\\\":\\\"192.168.10.148\\\",\\\"userAgent\\\":\\\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\\\",\\\"countryIso\\\":\\\"cn\\\",\\\"display\\\":\\\"LMY47V+release-keys\\\",\\\"firmVersion\\\":\\\"5.1.1\\\",\\\"hardware\\\":\\\"qcom\\\",\\\"host\\\":\\\"compiler01104\\\",\\\"language\\\":\\\"zh\\\",\\\"model\\\":\\\"vivo+X6S+A\\\",\\\"product\\\":\\\"PD1415BA\\\",\\\"roDevice\\\":\\\"PD1415BA\\\",\\\"roName\\\":\\\"compiler\\\",\\\"tag\\\":\\\"release-keys\\\",\\\"board\\\":\\\"msm8952\\\",\\\"simOperator\\\":\\\"ChinaUnicom\\\",\\\"timeZone\\\":\\\"GMT+08:00Asia/Shanghai\\\",\\\"brightness\\\":\\\"98\\\",\\\"ssid\\\":\\\"\\\\\\\"qibu-dev\\\\\\\"\\\",\\\"bssid\\\":\\\"74:3e:2b:4f:27:c8\\\",\\\"iccid\\\":\\\"89860113851049777700\\\",\\\"manufacturer\\\":\\\"vivo\\\",\\\"density\\\":\\\"3.0\\\",\\\"deviceType\\\":\\\"mobilephone\\\",\\\"cpuCount\\\":\\\"8\\\",\\\"cpuHardware\\\":\\\"Qualcomm+Technologies,+Inc+MSM8976\\\",\\\"cpuSpeed\\\":\\\"\\\",\\\"blueMac\\\":\\\"\\\",\\\"uuid\\\":\\\"00000000-78ef-1565-be24-15520b102783\\\",\\\"imei\\\":\\\"860576034610459\\\",\\\"imsi+\\\":\\\"460016627505874\\\",\\\"clientMac\\\":\\\"3cb6b75aa1a8\\\",\\\"buildSeril\\\":\\\"dfebed7\\\"}\"}";
        JSONObject stringObj = JSONObject.parseObject(jsonObj);
        JSONObject geoInfo = stringObj.getJSONObject("geoInfo");
        System.out.println(geoInfo.toString());
        Geo geo = JSON.toJavaObject(geoInfo, Geo.class);
        System.out.println(geo);
        System.out.println("================================");
        JSONObject deviceTokenInfo = stringObj.getJSONObject("deviceTokenInfo");
        System.out.println(deviceTokenInfo.toString());
        Device device = JSON.toJavaObject(deviceTokenInfo, Device.class);
        /*Device device = JSONObject.pa
        System.out.println(device);*/
        System.out.println("================================");

        UnionLoginInputVO unionLoginInputVO = JSON.toJavaObject(stringObj, UnionLoginInputVO.class);
        System.out.println(unionLoginInputVO);
    }

    @Test
    public void run6(){
        String json = "{\"dnsAddress\":\"133.134.96.202;86.128.96.202\",\"isRoot\":\"N\",\"clientMac\":\"3cb6b75aa1a8\",\"language\":\"zh\",\"imsi+\":\"460016627505874\",\"mcc\":\"460\",\"deviceName\":\"vivo+X6S+A\",\"deviceId\":\"c43ddcc44bedc4c1c96b2e09ebbe5456\",\"uuid\":\"00000000-78ef-1565-be24-15520b102783\",\"iccid\":\"89860113851049777700\",\"wifiIp\":\"148.10.168.192\",\"basebandVersion\":\"-8976_GEN_PACK-1.59907.1.60121.1\",\"cellIp\":\"111843845\",\"host\":\"compiler01104\",\"simOperator\":\"ChinaUnicom\",\"blueMac\":\"\",\"model\":\"vivo+X6S+A\",\"roDevice\":\"PD1415BA\",\"tag\":\"release-keys\",\"cpuHardware\":\"Qualcomm+Technologies,+Inc+MSM8976\",\"cpuCount\":\"8\",\"hardware\":\"qcom\",\"deviceType\":\"mobilephone\",\"roName\":\"compiler\",\"isVpnUsed\":\"false\",\"SDTotalSize\":\"119060455424\",\"cpuSerial\":\"0000000000000000\",\"timeZone\":\"GMT+08:00Asia/Shanghai\",\"simSerial\":\"89860113851049777700\",\"deviceBand\":\"vivo\",\"serialNo\":\"dfebed7\",\"currentTime\":\"2016-08-10+15:19:53\",\"trueIp\":\"192.168.10.148\",\"cpuSpeed\":\"\",\"cellLocation\":\"9526\",\"deviceMobileNum\":\"+8618576626946\",\"bssid\":\"74:3e:2b:4f:27:c8\",\"ssid\":\"qibu-dev\",\"manufacturer\":\"vivo\",\"osVersion\":\"5.1.1\",\"countryIso\":\"cn\",\"startTime\":\"603638640\",\"udid\":\"de4a07e1c05b20d0\",\"networkType\":\"WIFI\",\"screenRes\":\"1080x1920\",\"product\":\"PD1415BA\",\"mnc\":\"1\",\"os\":\"Android\",\"density\":\"3.0\",\"display\":\"LMY47V+release-keys\",\"mobile\":\"13899786678\",\"bundleId\":\"LMY47V\",\"userAgent\":\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\",\"uptime\":\"206535500\",\"cpuAbi\":\"armeabi-v7a\",\"carrier\":\"ChinaUnicom\",\"totalMemory\":\"3785011200\",\"brightness\":\"98\",\"buildSeril\":\"dfebed7\",\"availableStorage\":\"90781839360\",\"imei\":\"860576034610459\",\"deviceModel\":\"vivo+X6S+A\",\"wifiMac\":\"3CB6B75AA1A8\",\"availableMemery\":\"1639641088\",\"gateway\":\"1.10.168.192\",\"board\":\"msm8952\",\"firmVersion\":\"5.1.1\"}";
        Device device = JSON.parseObject(json, Device.class);
        System.out.println(device);
    }


    @Test
    public void run7(){
        String str = "{\"partnerCode\":\"weilaijishi\",\"geoInfo\":\"{\\\"longitude\\\":\\\"113.960175\\\",\\\"latitude\\\":\\\"22.542666\\\",\\\"country\\\":\\\"中国\\\",\\\"city\\\":\\\"深圳市\\\",\\\"province\\\":\\\"广东省\\\",\\\"district\\\":\\\"南山区\\\",\\\"addrInfo\\\":\\\"广东省深圳市南山区科技南十+路\\\"}\",\"mobileNo\":\"15635784526\",\"authenticationToken\":\"0e26327c17204819ab73e96e8e842386\"}";
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.toString());
        UnionLoginInputVO unionLoginInputVO = JSON.parseObject(str, UnionLoginInputVO.class);
        System.out.println(unionLoginInputVO);
    }

    @Test
    public void run8(){
        String str = "{\\\"longitude\\\":\\\"113.960175\\\",\\\"latitude\\\":\\\"22.542666\\\",\\\"country\\\":\\\"中国\\\",\\\"city\\\":\\\"深圳市\\\",\\\"province\\\":\\\"广东省\\\",\\\"district\\\":\\\"南山区\\\",\\\"addrInfo\\\":\\\"广东省深圳市南山区科技南十+路\\\"}";
        Geo geo = JSONObject.parseObject(str, Geo.class);
        System.out.println(geo);


    }

    @Test
    public void run9(){
        String str = "{\"geoInfo\":{\"latitude\":\"1111\",\"longitude\":\"222222\"},\"mobileNo\":\"15979622463\",\"smsCode\":\"025730\",\"userName\":\"15979622463\",\"cdKey\":\"39446632252944384\"}";
        UnionLoginInputVO vo = JSONObject.parseObject(str, UnionLoginInputVO.class);
        System.out.println(vo);


    }

    @Test
    public void run10(){
        String json = "{\"activityInfo\":\"null\",\"appName\":\"null\",\"appVersion\":\"1.6.5\",\"bizContent\":{\"partnerCode\":\"weilaijishi\",\"mobileNo\":\"15635784526\",\"authenticationToken\":\"0e26327c17204819ab73e96e8e842386\",\"geoInfo\":{\"longitude\":\"113.960175\",\"latitude\":\"22.542666\",\"country\":\"中国\",\"city\":\"深圳市\",\"province\":\"广东省\",\"district\":\"南山区\",\"addrInfo\":\"广东省深圳市南山区科技南十+路\"},\"deviceTokenInfo\":{\"mobile\":\"13899786678\",\"carrier\":\"ChinaUnicom\",\"basebandVersion\":\"-8976_GEN_PACK-1.59907.1.60121.1\",\"mcc\":\"460\",\"mnc\":\"1\",\"cellLocation\":\"9526\",\"cellIp\":\"111843845\",\"simSerial\":\"89860113851049777700\",\"serialNo\":\"dfebed7\",\"deviceMobileNum\":\"+8618576626946\",\"udid\":\"de4a07e1c05b20d0\",\"deviceName\":\"vivo+X6S+A\",\"deviceBand\":\"vivo\",\"deviceModel\":\"vivo+X6S+A\",\"cpuAbi\":\"armeabi-v7a\",\"cpuSerial\":\"0000000000000000\",\"screenRes\":\"1080x1920\",\"totalMemory\":\"3785011200\",\"availableMemery\":\"1639641088\",\"SDTotalSize\":\"119060455424\",\"availableStorage\":\"90781839360\",\"wifiMac\":\"3CB6B75AA1A8\",\"wifiIp\":\"148.10.168.192\",\"isVpnUsed\":\"false\",\"gateway\":\"1.10.168.192\",\"dnsAddress\":\"133.134.96.202;86.128.96.202\",\"startTime\":\"603638640\",\"uptime\":\"206535500\",\"isRoot\":\"N\",\"currentTime\":\"2016-08-10+15:19:53\",\"networkType\":\"WIFI\",\"osVersion\":\"5.1.1\",\"bundleId\":\"LMY47V\",\"deviceId\":\"c43ddcc44bedc4c1c96b2e09ebbe5456\",\"os\":\"Android\",\"trueIp\":\"192.168.10.148\",\"userAgent\":\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\",\"countryIso\":\"cn\",\"display\":\"LMY47V+release-keys\",\"firmVersion\":\"5.1.1\",\"hardware\":\"qcom\",\"host\":\"compiler01104\",\"language\":\"zh\",\"model\":\"vivo+X6S+A\",\"product\":\"PD1415BA\",\"roDevice\":\"PD1415BA\",\"roName\":\"compiler\",\"tag\":\"release-keys\",\"board\":\"msm8952\",\"simOperator\":\"ChinaUnicom\",\"timeZone\":\"GMT+08:00Asia/Shanghai\",\"brightness\":\"98\",\"ssid\":\"\\\"qibu-dev\\\"\",\"bssid\":\"74:3e:2b:4f:27:c8\",\"iccid\":\"89860113851049777700\",\"manufacturer\":\"vivo\",\"density\":\"3.0\",\"deviceType\":\"mobilephone\",\"cpuCount\":\"8\",\"cpuHardware\":\"Qualcomm+Technologies,+Inc+MSM8976\",\"cpuSpeed\":\"\",\"blueMac\":\"\",\"uuid\":\"00000000-78ef-1565-be24-15520b102783\",\"imei\":\"860576034610459\",\"imsi+\":\"460016627505874\",\"clientMac\":\"3cb6b75aa1a8\",\"buildSeril\":\"dfebed7\"}},\"channelId\":\"APK_CH_001\",\"channelSource\":\"CH_001\",\"charset\":\"UTF-8\",\"custNo\":\"null\",\"deviceInfo\":{\"buildSerial\":\"f11fb8c5c376940af13780e6cc952973\",\"imsi\":\"460016627505874\",\"deviceName\":\"liao的 iPhone\",\"wifiMac\":\"3CB6B75AA1A8\",\"isJailbreaking\":\"N\",\"brand\":\"iPhone\",\"deviceSn\":\"B8451623-E488-8C81-D62A-2843F4E30164\",\"deviceIp\":\"192.168.1.185\",\"uuid\":\"00000000-78ef-1565-be24-15520b102783\",\"bssid\":\"74:3e:2b:f:27:cc\",\"deviceFingerPrintM2\":\"68a2ac66-9e23-45dc-b12a-d6777d1f2456\",\"deviceFingerPrintTd\":\"ewogICJ0b2tlbklkIiA6ICIzNjBqaWViYmQyNDlkODEwMGIxYTM1ZGE2NDQ4ZDUzYjM0MWZlNyIsCiAgIm9zIiA6ICJpT1MiLAogICJwcm9maWxlVGltZSIgOiA2MDQsCiAgInZlcnNpb24iIDogIjIuMS40Igp9\",\"wifiName\":\"qibu-public\",\"networkType\":\"WIFI\",\"model\":\"iPhone\",\"deviceOsVersion\":\"iOS 10.0.2\",\"isEmulator\":\"N\",\"usedStorage\":\"8.50G\",\"deviceOs\":\"IOS\",\"deviceFingerPrintBr\":\"-\",\"terminalType\":\"app\",\"totalStorage\":\"11.04G\"},\"hostApp\":\"360LOAN\",\"method\":\"qihoo.sdk.user.partner.login\",\"productCode\":\"360JIETIAO\",\"requestIp\":\"121.34.29.23\",\"sign\":\"null\",\"signType\":\"RSA\",\"sourceType\":\"APK\",\"subChannel\":\"null\",\"timestamp\":\"1565253710825\",\"token\":\"null\",\"userNo\":\"null\",\"version\":\"1.6.5\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject);
        JSONObject bizContent = jsonObject.getJSONObject("bizContent");
        UnionLoginInputVO vo = JSON.toJavaObject(bizContent, UnionLoginInputVO.class);
        System.out.println("vo类打印:====================="+vo);
    }


    @Test
    public void run11(){
        String json = "{\"activityInfo\":\"null\",\"appName\":\"null\",\"appVersion\":\"1.6.5\",\"bizContent\":\"{\\\"partnerCode\\\":\\\"weilaijishi\\\",\\\"mobileNo\\\":\\\"15635784526\\\",\\\"authenticationToken\\\":\\\"0e26327c17204819ab73e96e8e842386\\\",\\\"geoInfo\\\":\\\"{\\\\\\\"longitude\\\\\\\":\\\\\\\"113.960175\\\\\\\",\\\\\\\"latitude\\\\\\\":\\\\\\\"22.542666\\\\\\\",\\\\\\\"country\\\\\\\":\\\\\\\"中国\\\\\\\",\\\\\\\"city\\\\\\\":\\\\\\\"深圳市\\\\\\\",\\\\\\\"province\\\\\\\":\\\\\\\"广东省\\\\\\\",\\\\\\\"district\\\\\\\":\\\\\\\"南山区\\\\\\\",\\\\\\\"addrInfo\\\\\\\":\\\\\\\"广东省深圳市南山区科技南十+路\\\\\\\"}\\\",\\\"deviceTokenInfo\\\":\\\"{\\\\\\\"mobile\\\\\\\":\\\\\\\"13899786678\\\\\\\",\\\\\\\"carrier\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"basebandVersion\\\\\\\":\\\\\\\"-8976_GEN_PACK-1.59907.1.60121.1\\\\\\\",\\\\\\\"mcc\\\\\\\":\\\\\\\"460\\\\\\\",\\\\\\\"mnc\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"cellLocation\\\\\\\":\\\\\\\"9526\\\\\\\",\\\\\\\"cellIp\\\\\\\":\\\\\\\"111843845\\\\\\\",\\\\\\\"simSerial\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"serialNo\\\\\\\":\\\\\\\"dfebed7\\\\\\\",\\\\\\\"deviceMobileNum\\\\\\\":\\\\\\\"+8618576626946\\\\\\\",\\\\\\\"udid\\\\\\\":\\\\\\\"de4a07e1c05b20d0\\\\\\\",\\\\\\\"deviceName\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"deviceBand\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"deviceModel\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"cpuAbi\\\\\\\":\\\\\\\"armeabi-v7a\\\\\\\",\\\\\\\"cpuSerial\\\\\\\":\\\\\\\"0000000000000000\\\\\\\",\\\\\\\"screenRes\\\\\\\":\\\\\\\"1080x1920\\\\\\\",\\\\\\\"totalMemory\\\\\\\":\\\\\\\"3785011200\\\\\\\",\\\\\\\"availableMemery\\\\\\\":\\\\\\\"1639641088\\\\\\\",\\\\\\\"SDTotalSize\\\\\\\":\\\\\\\"119060455424\\\\\\\",\\\\\\\"availableStorage\\\\\\\":\\\\\\\"90781839360\\\\\\\",\\\\\\\"wifiMac\\\\\\\":\\\\\\\"3CB6B75AA1A8\\\\\\\",\\\\\\\"wifiIp\\\\\\\":\\\\\\\"148.10.168.192\\\\\\\",\\\\\\\"isVpnUsed\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"gateway\\\\\\\":\\\\\\\"1.10.168.192\\\\\\\",\\\\\\\"dnsAddress\\\\\\\":\\\\\\\"133.134.96.202;86.128.96.202\\\\\\\",\\\\\\\"startTime\\\\\\\":\\\\\\\"603638640\\\\\\\",\\\\\\\"uptime\\\\\\\":\\\\\\\"206535500\\\\\\\",\\\\\\\"isRoot\\\\\\\":\\\\\\\"N\\\\\\\",\\\\\\\"currentTime\\\\\\\":\\\\\\\"2016-08-10+15:19:53\\\\\\\",\\\\\\\"networkType\\\\\\\":\\\\\\\"WIFI\\\\\\\",\\\\\\\"osVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"bundleId\\\\\\\":\\\\\\\"LMY47V\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"c43ddcc44bedc4c1c96b2e09ebbe5456\\\\\\\",\\\\\\\"os\\\\\\\":\\\\\\\"Android\\\\\\\",\\\\\\\"trueIp\\\\\\\":\\\\\\\"192.168.10.148\\\\\\\",\\\\\\\"userAgent\\\\\\\":\\\\\\\"Mozilla/5.0+(Linux;+Android+5.1.1;+vivo+X6S+A+Build/LMY47V)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Version/4.0+Chrome/39.0.0.0+Mobile+Safari/537.36+WebView\\\\\\\",\\\\\\\"countryIso\\\\\\\":\\\\\\\"cn\\\\\\\",\\\\\\\"display\\\\\\\":\\\\\\\"LMY47V+release-keys\\\\\\\",\\\\\\\"firmVersion\\\\\\\":\\\\\\\"5.1.1\\\\\\\",\\\\\\\"hardware\\\\\\\":\\\\\\\"qcom\\\\\\\",\\\\\\\"host\\\\\\\":\\\\\\\"compiler01104\\\\\\\",\\\\\\\"language\\\\\\\":\\\\\\\"zh\\\\\\\",\\\\\\\"model\\\\\\\":\\\\\\\"vivo+X6S+A\\\\\\\",\\\\\\\"product\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roDevice\\\\\\\":\\\\\\\"PD1415BA\\\\\\\",\\\\\\\"roName\\\\\\\":\\\\\\\"compiler\\\\\\\",\\\\\\\"tag\\\\\\\":\\\\\\\"release-keys\\\\\\\",\\\\\\\"board\\\\\\\":\\\\\\\"msm8952\\\\\\\",\\\\\\\"simOperator\\\\\\\":\\\\\\\"ChinaUnicom\\\\\\\",\\\\\\\"timeZone\\\\\\\":\\\\\\\"GMT+08:00Asia/Shanghai\\\\\\\",\\\\\\\"brightness\\\\\\\":\\\\\\\"98\\\\\\\",\\\\\\\"ssid\\\\\\\":\\\\\\\"\\\\\\\\\\\\\\\"qibu-dev\\\\\\\\\\\\\\\"\\\\\\\",\\\\\\\"bssid\\\\\\\":\\\\\\\"74:3e:2b:4f:27:c8\\\\\\\",\\\\\\\"iccid\\\\\\\":\\\\\\\"89860113851049777700\\\\\\\",\\\\\\\"manufacturer\\\\\\\":\\\\\\\"vivo\\\\\\\",\\\\\\\"density\\\\\\\":\\\\\\\"3.0\\\\\\\",\\\\\\\"deviceType\\\\\\\":\\\\\\\"mobilephone\\\\\\\",\\\\\\\"cpuCount\\\\\\\":\\\\\\\"8\\\\\\\",\\\\\\\"cpuHardware\\\\\\\":\\\\\\\"Qualcomm+Technologies,+Inc+MSM8976\\\\\\\",\\\\\\\"cpuSpeed\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"blueMac\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"00000000-78ef-1565-be24-15520b102783\\\\\\\",\\\\\\\"imei\\\\\\\":\\\\\\\"860576034610459\\\\\\\",\\\\\\\"imsi+\\\\\\\":\\\\\\\"460016627505874\\\\\\\",\\\\\\\"clientMac\\\\\\\":\\\\\\\"3cb6b75aa1a8\\\\\\\",\\\\\\\"buildSeril\\\\\\\":\\\\\\\"dfebed7\\\\\\\"}\\\"}\",\"channelId\":\"APK_CH_001\",\"channelSource\":\"CH_001\",\"charset\":\"UTF-8\",\"custNo\":\"null\",\"deviceInfo\":\"{\\\"buildSerial\\\":\\\"f11fb8c5c376940af13780e6cc952973\\\",\\\"imsi\\\":\\\"460016627505874\\\",\\\"deviceName\\\":\\\"liao的 iPhone\\\",\\\"wifiMac\\\":\\\"3CB6B75AA1A8\\\",\\\"isJailbreaking\\\":\\\"N\\\",\\\"brand\\\":\\\"iPhone\\\",\\\"deviceSn\\\":\\\"B8451623-E488-8C81-D62A-2843F4E30164\\\",\\\"deviceIp\\\":\\\"192.168.1.185\\\",\\\"uuid\\\":\\\"00000000-78ef-1565-be24-15520b102783\\\",\\\"bssid\\\":\\\"74:3e:2b:f:27:cc\\\",\\\"deviceFingerPrintM2\\\":\\\"68a2ac66-9e23-45dc-b12a-d6777d1f2456\\\",\\\"deviceFingerPrintTd\\\":\\\"ewogICJ0b2tlbklkIiA6ICIzNjBqaWViYmQyNDlkODEwMGIxYTM1ZGE2NDQ4ZDUzYjM0MWZlNyIsCiAgIm9zIiA6ICJpT1MiLAogICJwcm9maWxlVGltZSIgOiA2MDQsCiAgInZlcnNpb24iIDogIjIuMS40Igp9\\\",\\\"wifiName\\\":\\\"qibu-public\\\",\\\"networkType\\\":\\\"WIFI\\\",\\\"model\\\":\\\"iPhone\\\",\\\"deviceOsVersion\\\":\\\"iOS 10.0.2\\\",\\\"isEmulator\\\":\\\"N\\\",\\\"usedStorage\\\":\\\"8.50G\\\",\\\"deviceOs\\\":\\\"IOS\\\",\\\"deviceFingerPrintBr\\\":\\\"-\\\",\\\"terminalType\\\":\\\"app\\\",\\\"totalStorage\\\":\\\"11.04G\\\"}\",\"hostApp\":\"360LOAN\",\"method\":\"qihoo.sdk.user.partner.login\",\"productCode\":\"360JIETIAO\",\"requestIp\":\"121.34.29.23\",\"sign\":\"null\",\"signType\":\"RSA\",\"sourceType\":\"APK\",\"subChannel\":\"null\",\"timestamp\":\"1565253710825\",\"token\":\"null\",\"userNo\":\"null\",\"version\":\"1.6.5\"}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject bizContent = jsonObject.getJSONObject("bizContent");
        UnionLoginInputVO vo = JSON.toJavaObject(bizContent, UnionLoginInputVO.class);
        System.out.println("====================");
        /*Geo geo = JSON.parseObject(vo.getGeoInfo(),Geo.class);
        System.out.println(geo);*/
        String geoInfo = vo.getGeoInfo();
        Map geoInfoMap =(Map) JSON.parse(geoInfo);
        System.out.println(geoInfoMap);
        System.out.println("====================");
        Map<String, String> geoMap = (Map<String, String>)JSON.parse(geoInfo);
        System.out.println(geoMap);
        System.out.println("====================");
        /*Device device = JSON.parseObject(vo.getDeviceTokenInfo(),Device.class);
        System.out.println(device);*/

    }

}
