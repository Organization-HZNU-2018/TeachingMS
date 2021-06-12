package cn.hznu.controller;


import cn.hznu.service.TbStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/tb-student")
public class TbStudentController {
    @Autowired
    private TbStudentService tbStudentService;

    @PostMapping("/login")
    public Map<String, Object> searchTicket(@RequestBody HashMap<String, String> requestMap) {

        String stuid = requestMap.get("stuid");
        String spassword = requestMap.get("spassword");

        if (stuid == null || stuid.length() == 0
                || spassword == null || spassword.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "账号密码不能为空！");
            return resultMap;
        }

        return tbStudentService.login(stuid, spassword);
    }
}

