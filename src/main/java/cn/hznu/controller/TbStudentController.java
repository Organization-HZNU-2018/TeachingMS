package cn.hznu.controller;


import cn.hznu.service.TbStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private TbStudentService tbStudentService;

    @SneakyThrows
    @PostMapping("/login")
    public String login(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        String spassword = requestMap.get("spassword");

        if (stuid == null || stuid.length() == 0
                || spassword == null || spassword.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "账号密码不能为空！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.login(stuid, spassword);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/get-course-class-list")
    public String getCourseClassList(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        // 学年 + 学期，确定某个具体学期的课程班列表
        String teachingyearname = "2004-2005学年";
        String termid = "T1";

        if (stuid == null || stuid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getCourseClassList(stuid, teachingyearname, termid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/

    @SneakyThrows
    @GetMapping("/get-course-class-list")
    public String getCourseClassList(@RequestParam("stuid") String stuid) {
        // String stuid = requestMap.get("stuid");
        // 学年 + 学期，确定某个具体学期的课程班列表
        String teachingyearname = "2004-2005学年";
        String termid = "T1";

        if (stuid == null || stuid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getCourseClassList(stuid, teachingyearname, termid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/get-course-class")
    public String getCourseClass(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        String courseclassid = requestMap.get("courseclassid");

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/

    @SneakyThrows
    @GetMapping("/get-course-class")
    public String getCourseClass(
            @RequestParam("stuid") String stuid,
            @RequestParam("courseclassid") String courseclassid) {

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/elective-course-class")
    public String electiveCourseClass(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        String courseclassid = requestMap.get("courseclassid");

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.electiveCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/

    @SneakyThrows
    @GetMapping("/elective-course-class")
    public String electiveCourseClass(
            @RequestParam("stuid") String stuid,
            @RequestParam("courseclassid") String courseclassid) {

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.electiveCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/withdraw-course-class")
    public String withdrawCourseClass(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        String courseclassid = requestMap.get("courseclassid");

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.withdrawCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/

    @SneakyThrows
    @GetMapping("/withdraw-course-class")
    public String withdrawCourseClass(
            @RequestParam("stuid") String stuid,
            @RequestParam("courseclassid") String courseclassid) {

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.withdrawCourseClass(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/get-user-course-grade-list")
    public String getUserCourseGradeList(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        // 学年 + 学期，确定某个具体学期的课程班列表
        String teachingyearname = "2004-2005学年";
        String termid = "T1";

        if (stuid == null || stuid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getUserCourseGradeList(stuid, teachingyearname, termid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/

    @SneakyThrows
    @GetMapping("/get-user-course-grade-list")
    public String getUserCourseGradeList(@RequestParam("stuid") String stuid) {
        // 学年 + 学期，确定某个具体学期的课程班列表
        String teachingyearname = "2004-2005学年";
        String termid = "T1";

        if (stuid == null || stuid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getUserCourseGradeList(stuid, teachingyearname, termid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }

    /*@SneakyThrows
    @GetMapping("/get-user-course-grade")
    public String getUserCourseGrade(@RequestBody HashMap<String, String> requestMap) {
        String stuid = requestMap.get("stuid");
        String courseclassid = requestMap.get("courseclassid");

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getUserCourseGrade(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }*/
    @SneakyThrows
    @GetMapping("/get-user-course-grade")
    public String getUserCourseGrade(
            @RequestParam("stuid") String stuid,
            @RequestParam("courseclassid") String courseclassid) {

        if (stuid == null || stuid.length() == 0 ||
                courseclassid == null || courseclassid.length() == 0) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", 2);
            resultMap.put("info", "请先登录！");
            return OBJECT_MAPPER.writeValueAsString(resultMap);
        }

        Map<String, Object> resultMap = tbStudentService.getUserCourseGrade(stuid, courseclassid);
        return OBJECT_MAPPER.writeValueAsString(resultMap);
    }
}

