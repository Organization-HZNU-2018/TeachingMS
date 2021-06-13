package cn.hznu.service.impl;

import cn.hznu.mapper.TbGradeMapper;
import cn.hznu.pojo.TbAdmin;
import cn.hznu.pojo.TbGrade;
import cn.hznu.pojo.TbTeacher;
import cn.hznu.mapper.TbTeacherMapper;
import cn.hznu.service.TbTeacherService;
import cn.hznu.util.ReturnResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hznu.util.CommonParam.checkResult;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@Service
public class TbTeacherServiceImpl extends ServiceImpl<TbTeacherMapper, TbTeacher> implements TbTeacherService {

    @Autowired
    private TbTeacherMapper tbTeacherMapper;

    @Autowired
    private TbGradeMapper tbGradeMapper;

    @Override
    @Transactional
    public Map<String, Object> login(String teacherId, String tPassword) {
        Map<String, Object> resultMap = new HashMap<>();

        QueryWrapper<TbTeacher> tbTeacherQueryWrapper = new QueryWrapper<>();
        tbTeacherQueryWrapper.eq("TeacherID", teacherId);
        TbTeacher tbTeacher = tbTeacherMapper.selectOne(tbTeacherQueryWrapper);

        if (tbTeacher == null) {
            resultMap.put("result", 2);
            resultMap.put("info", "账号不存在！");
            return resultMap;
        }

        if (tbTeacher.getTpassword().equals(tPassword)) {
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
    public Map<String, Object> queryStudentInfoByCondition(String teachingPlace, String teachingTime, String courseId, String teacherId) {
        List<Map<String, Object>> tbAdminList = tbGradeMapper.getGradeInfoByCondition(teachingPlace, teachingTime, courseId, teacherId);
        return ReturnResult.buildSuccessResult(tbAdminList.size(), tbAdminList);
    }

    @Override
    @Transactional
    public Map<String, Object> modifyGradeInfo(TbGrade tbGrade) {
        int len = tbGradeMapper.updateById(tbGrade);
        return checkResult(len, "更新失败，请检查传参");
    }
}
