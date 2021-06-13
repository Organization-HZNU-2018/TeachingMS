package cn.hznu.service.impl;

import cn.hznu.mapper.TbClassMapper;
import cn.hznu.mapper.TbStudentMapper;
import cn.hznu.pojo.TbAdmin;
import cn.hznu.mapper.TbAdminMapper;
import cn.hznu.pojo.TbClass;
import cn.hznu.pojo.TbStudent;
import cn.hznu.service.TbAdminService;
import cn.hznu.util.ReturnResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@Service
public class TbAdminServiceImpl extends ServiceImpl<TbAdminMapper, TbAdmin> implements TbAdminService {
    @Autowired
    private TbAdminMapper tbAdminMapper;

    @Autowired
    private TbClassMapper tbClassMapper;

    @Autowired
    private TbStudentMapper tbStudentMapper;

    @Override
    @Transactional
    public Map<String, Object> login(String adminId, String aPassword) {
        Map<String, Object> resultMap = new HashMap<>();

        QueryWrapper<TbAdmin> tbAdminQueryWrapper = new QueryWrapper<>();
        tbAdminQueryWrapper.eq("AdminID", adminId);
        TbAdmin tbAdmin = tbAdminMapper.selectOne(tbAdminQueryWrapper);

        if (tbAdmin == null) {
            resultMap.put("result", 2);
            resultMap.put("info", "账号不存在！");
            return resultMap;
        }

        if (tbAdmin.getApassword().equals(aPassword)) {
            resultMap.put("result", 1);
            resultMap.put("info", "登录成功！");
            return resultMap;
        }

        resultMap.put("result", 2);
        resultMap.put("info", "密码错误！");
        return resultMap;
    }


    @Override
    @Transactional
    public Map<String, Object> queryClassInfoByDeptId(String deptId) {
        List<Map<String, Object>> tbAdminList = tbClassMapper.getClassInfoByDeptId(deptId);
        return ReturnResult.buildSuccessResult(tbAdminList.size(), tbAdminList);
    }

    @Override
    @Transactional
    public Map<String, Object> addClassInfo(TbClass tbClass) {
        int len = tbClassMapper.insert(tbClass);
        return checkResult(len, "插入失败，请检查传参");
    }

    @Override
    @Transactional
    public Map<String, Object> modifyClassInfo(TbClass tbClass) {
        int len = tbClassMapper.updateById(tbClass);
        return checkResult(len, "更新失败，请检查传参");
    }

    @Override
    @Transactional
    public Map<String, Object> removeClassInfo(String classId) {
        int len = tbClassMapper.deleteById(classId);
        return checkResult(len, "删除失败，无效classid");
    }

    @Override
    @Transactional
    public Map<String, Object> queryStudentInfoByDeptIdAndClassId(String deptId, String classId) {
        List<Map<String, Object>> tbStudentList = tbStudentMapper.getClassInfoByDeptIdAndClassId(deptId, classId);
        return ReturnResult.buildSuccessResult(tbStudentList.size(), tbStudentList);
    }

    @Override
    @Transactional
    public Map<String, Object> addStudentInfo(TbStudent tbStudent) {
        int len = tbStudentMapper.insert(tbStudent);
        return checkResult(len, "插入失败，请检查传参");
    }

    @Override
    @Transactional
    public Map<String, Object> modifyStudentInfo(TbStudent tbStudent) {
        int len = tbStudentMapper.updateById(tbStudent);
        return checkResult(len, "更新失败，请检查传参");
    }

    @Override
    @Transactional
    public Map<String, Object> removeStudentInfo(String studentId) {
        int len = tbStudentMapper.deleteById(studentId);
        return checkResult(len, "删除失败，无效stuid");
    }

    //统一的错误处理（懒得写AOP了～）
    private Map<String, Object> checkResult(int len, String msg) {
        if (len == 0) {
            return ReturnResult.buildFailedResult(msg);
        }
        return ReturnResult.buildSuccessResult(len, null);
    }
}
