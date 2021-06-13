package cn.hznu.util;

import java.util.HashMap;
import java.util.Map;

import static cn.hznu.util.CommonParam.*;

public class ReturnResult {
    private int result;
    private String info;
    private Object data;

    public ReturnResult() {

    }

    public ReturnResult(int result, String info, Object data) {
        this.result = result;
        this.info = info;
        this.data = data;
    }

    public static Map<String, Object> buildSuccessResult(int result, Object data) {
        ReturnResult res = new ReturnResult(result, SUCCESSMSG, data);
        return convertToMap(res);
    }

    public static Map<String, Object> buildFailedResult(String info) {
        ReturnResult res = new ReturnResult(FAILCODE, info, null);
        return convertToMap(res);
    }

    public static Map<String, Object> buildFailedResult(int result, String info) {
        ReturnResult res = new ReturnResult(result, info, null);
        return convertToMap(res);
    }

    private static Map<String, Object> convertToMap(ReturnResult res) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("result", res.result);
        resMap.put("info", res.info);
        resMap.put("data", res.data);
        return resMap;
    }
}
