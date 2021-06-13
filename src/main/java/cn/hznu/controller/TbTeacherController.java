package cn.hznu.controller;


import cn.hznu.pojo.TbClass;
import cn.hznu.pojo.TbGrade;
import cn.hznu.service.TbTeacherService;
import cn.hznu.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/tb-teacher")
public class TbTeacherController {

    @Autowired
    private TbTeacherService tbTeacherService;

    //教师登录
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> param) {
        String teacherId = (String) param.getOrDefault("teacherid", null);
        String tPassword = (String) param.getOrDefault("tpassword", null);
        if (teacherId == null || tPassword == null) {
            return ReturnResult.buildFailedResult(2, "登录失败，请检查传参");
        }
        return tbTeacherService.login(teacherId, tPassword);
    }

    //成绩查
    @GetMapping("/queryGradeInfo")
    public Map<String, Object> queryGradeInfo(@RequestParam("teachingplace") String teachingPlace, @RequestParam("teachingtime") String teachingTime,
                                              @RequestParam("courseid") String courseId, @RequestParam("teacherid") String teacherId) {
        if (teachingPlace == null || teachingPlace.isEmpty()) {
            teachingPlace = null;
        }
        if (teachingTime == null || teachingTime.isEmpty()) {
            teachingTime = null;
        }
        if (courseId == null || courseId.isEmpty()) {
            courseId = null;
        }
        if (teacherId == null || teacherId.isEmpty()) {
            teacherId = null;
        }
        return tbTeacherService.queryStudentInfoByCondition(teachingPlace, teachingTime, courseId, teacherId);
    }

    //成绩更新
    @PostMapping("/modifyGradeInfo")
    public Map<String, Object> modifyGradeInfo(@RequestBody TbGrade param) {
        return tbTeacherService.modifyGradeInfo(param);
    }
}

