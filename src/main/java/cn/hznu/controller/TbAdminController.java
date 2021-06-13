package cn.hznu.controller;


import cn.hznu.mapper.TbAdminMapper;
import cn.hznu.mapper.TbClassMapper;
import cn.hznu.mapper.TbStudentMapper;
import cn.hznu.pojo.TbAdmin;
import cn.hznu.pojo.TbClass;
import cn.hznu.pojo.TbStudent;
import cn.hznu.service.TbAdminService;
import cn.hznu.service.TbClassService;
import cn.hznu.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping("/tb-admin")
public class TbAdminController {
    @Autowired
    private TbAdminService tbAdminService;

    //管理员登录
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> param) {
        String adminId = (String) param.getOrDefault("adminid", null);
        String aPassword = (String) param.getOrDefault("apassword", null);
        if (adminId == null || aPassword == null) {
            return ReturnResult.buildFailedResult(2, "登录失败，请检查传参");
        }
        return tbAdminService.login(adminId, aPassword);
    }

    //班级查
    @GetMapping("/queryClassInfo")
    public Map<String, Object> queryClassInfo(@RequestParam("deptid") String deptId) {
        if (deptId == null || deptId.isEmpty()) {
            deptId = null;
        }
        return tbAdminService.queryClassInfoByDeptId(deptId);
    }

    //班级增
    @PostMapping("/addClassInfo")
    public Map<String, Object> addClassInfo(@RequestBody TbClass param) {
        return tbAdminService.addClassInfo(param);
    }

    //班级删
    @PostMapping("/removeClassInfo")
    public Map<String, Object> removeClassInfo(@RequestBody Map<String, Object> param) {
        if (param.isEmpty() || !param.containsKey("classid")) {
            return ReturnResult.buildFailedResult("删除失败，请检查是否传classid");
        }
        return tbAdminService.removeClassInfo(param.get("classid") + "");
    }

    //班级更新
    @PostMapping("/modifyClassInfo")
    public Map<String, Object> modifyClassInfo(@RequestBody TbClass param) {
        return tbAdminService.modifyClassInfo(param);
    }

    //学生查
    @GetMapping("/queryStudentInfo")
    public Map<String, Object> queryStudentInfo(@RequestParam("deptid") String deptId, @RequestParam("classid") String classId) {
        if (deptId == null || deptId.isEmpty()) {
            deptId = null;
        }
        if (classId == null || classId.isEmpty()) {
            classId = null;
        }
        return tbAdminService.queryStudentInfoByDeptIdAndClassId(deptId, classId);
    }

    //学生增
    @PostMapping("/addStudentInfo")
    public Map<String, Object> addStudentInfo(@RequestBody TbStudent param) {
        return tbAdminService.addStudentInfo(param);
    }

    //学生删
    @PostMapping("/removeStudentInfo")
    public Map<String, Object> removeStudentInfo(@RequestBody Map<String, Object> param) {
        if (param.isEmpty() || !param.containsKey("stuid")) {
            return ReturnResult.buildFailedResult("删除失败，请检查是否传stuid");
        }
        return tbAdminService.removeStudentInfo(param.get("stuid") + "");
    }

    //学生更新
    @PostMapping("/modifyStudentInfo")
    public Map<String, Object> modifyStudentInfo(@RequestBody TbStudent param) {
        return tbAdminService.modifyStudentInfo(param);
    }
}

