package cn.hznu.controller;


import cn.hznu.mapper.TbAdminMapper;
import cn.hznu.mapper.TbClassMapper;
import cn.hznu.mapper.TbStudentMapper;
import cn.hznu.pojo.TbAdmin;
import cn.hznu.pojo.TbClass;
import cn.hznu.pojo.TbStudent;
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
    private TbClassMapper tbClassMapper;

    @Autowired
    private TbStudentMapper tbStudentMapper;

    //班级查
    @GetMapping("/queryClassInfo")
    public Map<String, Object> queryClassInfo(@RequestBody Map<String, Object> param) {
        List<Map<String, Object>> tbAdminList = tbClassMapper.selectMaps(null);
        return ReturnResult.buildSuccessResult(tbAdminList.size(), tbAdminList);
    }

    //班级增
    @PostMapping("/addClassInfo")
    public Map<String, Object> addClassInfo(@RequestBody TbClass param) {
        int len = tbClassMapper.insert(param);
        return checkResult(len, "插入失败，请检查传参");
    }

    //班级删
    @PostMapping("/removeClassInfo")
    public Map<String, Object> removeClassInfo(@RequestBody Map<String, Object> param) {
        if (param.isEmpty() || !param.containsKey("classid")) {
            return ReturnResult.buildFailedResult("删除失败，请检查是否传classid");
        }
        int len = tbClassMapper.deleteById(param.get("classid") + "");
        return checkResult(len, "删除失败，无效classid");
    }

    //班级更新
    @PostMapping("/modifyClassInfo")
    public Map<String, Object> modifyClassInfo(@RequestBody TbClass param) {
        int len = tbClassMapper.updateById(param);
        return checkResult(len, "更新失败，请检查传参");
    }

    //学生查
    @GetMapping("/queryStudentInfo")
    public Map<String, Object> queryStudentInfo(@RequestBody Map<String, Object> param) {
        List<Map<String, Object>> tbStudentList = tbStudentMapper.selectMaps(null);
        return ReturnResult.buildSuccessResult(tbStudentList.size(), tbStudentList);
    }

    //学生增
    @PostMapping("/addStudentInfo")
    public Map<String, Object> addStudentInfo(@RequestBody TbStudent param) {
        int len = tbStudentMapper.insert(param);
        return checkResult(len, "插入失败，请检查传参");
    }

    //学生删
    @PostMapping("/removeStudentInfo")
    public Map<String, Object> removeStudentInfo(@RequestBody Map<String, Object> param) {
        if (param.isEmpty() || !param.containsKey("stuid")) {
            return ReturnResult.buildFailedResult("删除失败，请检查是否传stuid");
        }
        int len = tbStudentMapper.deleteById(param.get("stuid") + "");
        return checkResult(len, "删除失败，无效stuid");
    }

    //学生更新
    @PostMapping("/modifyStudentInfo")
    public Map<String, Object> modifyStudentInfo(@RequestBody TbStudent param) {
        int len = tbStudentMapper.updateById(param);
        return checkResult(len, "更新失败，请检查传参");
    }

    //统一的错误处理（懒得写AOP了～）
    private Map<String, Object> checkResult(int len, String msg) {
        if (len == 0) {
            return ReturnResult.buildFailedResult(msg);
        }
        return ReturnResult.buildSuccessResult(len, null);
    }
}

