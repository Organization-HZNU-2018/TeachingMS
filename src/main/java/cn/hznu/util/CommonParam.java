package cn.hznu.util;

import java.util.Map;

public class CommonParam {
    public final static int FAILCODE = -1;
    public final static String SUCCESSMSG = "成功！";

    //统一的错误处理（懒得写AOP了～）
    public static Map<String, Object> checkResult(int len, String msg) {
        if (len == 0) {
            return ReturnResult.buildFailedResult(msg);
        }
        return ReturnResult.buildSuccessResult(len, null);
    }
}
