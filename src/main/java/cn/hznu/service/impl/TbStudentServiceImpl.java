package cn.hznu.service.impl;

import cn.hznu.mapper.TbCourseMapper;
import cn.hznu.mapper.TbCourseclassMapper;
import cn.hznu.mapper.TbGradeMapper;
import cn.hznu.mapper.TbSelectcourseMapper;
import cn.hznu.mapper.TbStudentMapper;
import cn.hznu.mapper.TbTeacherMapper;
import cn.hznu.mapper.TbTeachingyearMapper;
import cn.hznu.pojo.TbCourse;
import cn.hznu.pojo.TbCourseclass;
import cn.hznu.pojo.TbGrade;
import cn.hznu.pojo.TbSelectcourse;
import cn.hznu.pojo.TbStudent;
import cn.hznu.pojo.TbTeacher;
import cn.hznu.pojo.TbTeachingyear;
import cn.hznu.service.TbStudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
public class TbStudentServiceImpl extends ServiceImpl<TbStudentMapper, TbStudent> implements TbStudentService {

    @Autowired
    private TbStudentMapper tbStudentMapper;

    @Autowired
    private TbCourseclassMapper tbCourseclassMapper;

    @Autowired
    private TbTeachingyearMapper tbTeachingyearMapper;

    @Autowired
    private TbCourseMapper tbCourseMapper;

    @Autowired
    private TbTeacherMapper tbTeacherMapper;

    @Autowired
    private TbSelectcourseMapper tbSelectcourseMapper;

    @Autowired
    private TbGradeMapper tbGradeMapper;

    @Transactional
    @Override
    public Map<String, Object> login(String stuid, String spassword) {
        Map<String, Object> resultMap = new HashMap<>();

        QueryWrapper<TbStudent> tbStudentQueryWrapper = new QueryWrapper<>();
        tbStudentQueryWrapper.eq("StuID", stuid);
        TbStudent tbStudent = tbStudentMapper.selectOne(tbStudentQueryWrapper);

        if (tbStudent == null) {
            resultMap.put("result", 2);
            resultMap.put("info", "账号不存在！");
            return resultMap;
        }

        if (tbStudent.getSpassword().equals(spassword)) {
            resultMap.put("result", 1);
            resultMap.put("info", "登录成功！");
            return resultMap;
        }

        resultMap.put("result", 2);
        resultMap.put("info", "密码错误！");
        return resultMap;
    }

    @Transactional
    @Override
    public Map<String, Object> getCourseClassList(String stuid, String teachingyearname, String termid) {
        Map<String, Object> resultMap = new HashMap<>();

        // 根据传入学期获取日期编码
        QueryWrapper<TbTeachingyear> tbTeachingyearQueryWrapper = new QueryWrapper<>();
        tbTeachingyearQueryWrapper.eq("Teachingyearname", teachingyearname);
        String teachingyearid = tbTeachingyearMapper.selectOne(tbTeachingyearQueryWrapper).getTeachingyearid();

        // 获取对应学期开设的课程班列表
        QueryWrapper<TbCourseclass> tbCourseclassQueryWrapper = new QueryWrapper<>();
        tbCourseclassQueryWrapper.eq("TeachingYearID", teachingyearid);
        tbCourseclassQueryWrapper.eq("TermID", termid);
        List<TbCourseclass> tbCourseclasses = tbCourseclassMapper.selectList(tbCourseclassQueryWrapper);

        List<Map<String, Object>> mps = new ArrayList<>();
        for (TbCourseclass tbCourseclass : tbCourseclasses) {
            Map<String, Object> mp = new HashMap<>();

            mp.put("CourseClassID", tbCourseclass.getCourseclassid());
            mp.put("TermID", termid);
            mp.put("TeachingYearName", teachingyearname);
            mp.put("TeachingPlace", tbCourseclass.getTeachingplace());
            mp.put("TeachingTime", tbCourseclass.getTeachingtime());
            mp.put("CommonPart", tbCourseclass.getCommonpart());
            mp.put("MaxNumber", tbCourseclass.getMaxnumber());
            mp.put("SelectedNumber", tbCourseclass.getSelectednumber());

            // 获取该课程班对应具体的课程信息
            TbCourse tbCourse = tbCourseMapper.selectById(tbCourseclass.getCourseid());
            mp.put("CourseName", tbCourse.getCoursename());
            mp.put("CourseGrade", tbCourse.getCoursegrade());
            mp.put("LessonTime", tbCourse.getLessontime());
            mp.put("CourseOutline", tbCourse.getCourseoutline());

            // 获取课程班的授课老师信息
            TbTeacher tbTeacher = tbTeacherMapper.selectById(tbCourseclass.getTeacherid());
            mp.put("TeacherName", tbTeacher.getTeachername());

            QueryWrapper<TbSelectcourse> tbSelectcourseQueryWrapper = new QueryWrapper<>();
            tbSelectcourseQueryWrapper.eq("StuID", stuid);
            tbSelectcourseQueryWrapper.eq("CourseClassID", tbCourseclass.getCourseclassid());
            TbSelectcourse tbSelectcourse = tbSelectcourseMapper.selectOne(tbSelectcourseQueryWrapper);

            mp.put("isSelect", tbSelectcourse != null);

            mps.add(mp);
        }
        resultMap.put("data", mps);
        resultMap.put("result", tbCourseclasses.size());
        resultMap.put("info", "查询成功！");
        return resultMap;
    }

    @Transactional
    @Override
    public Map<String, Object> getCourseClass(String stuid, String courseclassid) {
        Map<String, Object> resultMap = new HashMap<>();

        TbCourseclass tbCourseclass = tbCourseclassMapper.selectById(courseclassid);

        if (tbCourseclass == null) {
            resultMap.put("result", 2);
            resultMap.put("info", "课程班不存在！");
            return resultMap;
        }

        Map<String, Object> mp = new HashMap<>();

        mp.put("CourseClassID", tbCourseclass.getCourseclassid());
        mp.put("TeachingPlace", tbCourseclass.getTeachingplace());
        mp.put("TeachingTime", tbCourseclass.getTeachingtime());
        mp.put("CommonPart", tbCourseclass.getCommonpart());
        mp.put("MaxNumber", tbCourseclass.getMaxnumber());
        mp.put("SelectedNumber", tbCourseclass.getSelectednumber());

        // 获取该课程班对应具体的课程信息
        TbCourse tbCourse = tbCourseMapper.selectById(tbCourseclass.getCourseid());
        mp.put("CourseName", tbCourse.getCoursename());
        mp.put("CourseGrade", tbCourse.getCoursegrade());
        mp.put("LessonTime", tbCourse.getLessontime());
        mp.put("CourseOutline", tbCourse.getCourseoutline());

        // 获取课程班的授课老师信息
        TbTeacher tbTeacher = tbTeacherMapper.selectById(tbCourseclass.getTeacherid());
        mp.put("TeacherName", tbTeacher.getTeachername());

        QueryWrapper<TbSelectcourse> tbSelectcourseQueryWrapper = new QueryWrapper<>();
        tbSelectcourseQueryWrapper.eq("StuID", stuid);
        tbSelectcourseQueryWrapper.eq("CourseClassID", tbCourseclass.getCourseclassid());
        TbSelectcourse tbSelectcourse = tbSelectcourseMapper.selectOne(tbSelectcourseQueryWrapper);

        mp.put("isSelect", tbSelectcourse != null);

        resultMap.put("data", mp);
        resultMap.put("result", 1);
        resultMap.put("info", "查询成功！");
        return resultMap;
    }

    @Transactional
    @Override
    public Map<String, Object> electiveCourseClass(String stuid, String courseclassid) {
        Map<String, Object> resultMap = new HashMap<>();

        // 获取对应课程班信息
        TbCourseclass tbCourseclass = tbCourseclassMapper.selectById(courseclassid);
        Integer maxnumber = tbCourseclass.getMaxnumber();
        Integer selectednumber = tbCourseclass.getSelectednumber();

        if (maxnumber <= selectednumber) {
            resultMap.put("result", 2);
            resultMap.put("info", "课程班人数已满！");
            return resultMap;
        }

        // 减少课程班人数选课
        tbCourseclass.setSelectednumber(selectednumber + 1);
        tbCourseclassMapper.updateById(tbCourseclass);

        TbSelectcourse tbSelectcourse = TbSelectcourse.builder()
                .stuid(stuid)
                .courseclassid(courseclassid)
                .selectdate(new Date())
                .build();

        tbSelectcourseMapper.insert(tbSelectcourse);

        resultMap.put("result", 1);
        resultMap.put("info", "选修成功！");
        return resultMap;
    }

    @Transactional
    @Override
    public Map<String, Object> withdrawCourseClass(String stuid, String courseclassid) {
        Map<String, Object> resultMap = new HashMap<>();

        // 获取对应课程班信息
        TbCourseclass tbCourseclass = tbCourseclassMapper.selectById(courseclassid);

        // 增加课程班人数余量
        tbCourseclass.setSelectednumber(tbCourseclass.getSelectednumber() - 1);
        tbCourseclassMapper.updateById(tbCourseclass);

        QueryWrapper<TbSelectcourse> tbSelectcourseQueryWrapper = new QueryWrapper<>();
        tbSelectcourseQueryWrapper.eq("StuID", stuid);
        tbSelectcourseQueryWrapper.eq("CourseClassID", courseclassid);
        tbSelectcourseMapper.delete(tbSelectcourseQueryWrapper);

        resultMap.put("result", 1);
        resultMap.put("info", "退选成功！");
        return resultMap;
    }

    @Transactional
    @Override
    public Map<String, Object> getUserCourseGradeList(String stuid, String teachingyearname, String termid) {
        Map<String, Object> resultMap = new HashMap<>();

        // 根据传入学期获取日期编码
        QueryWrapper<TbTeachingyear> tbTeachingyearQueryWrapper = new QueryWrapper<>();
        tbTeachingyearQueryWrapper.eq("Teachingyearname", teachingyearname);
        String teachingyearid = tbTeachingyearMapper.selectOne(tbTeachingyearQueryWrapper).getTeachingyearid();

        // 获取对应学期开设的课程班列表
        QueryWrapper<TbCourseclass> tbCourseclassQueryWrapper = new QueryWrapper<>();
        tbCourseclassQueryWrapper.eq("TeachingYearID", teachingyearid);
        tbCourseclassQueryWrapper.eq("TermID", termid);
        List<TbCourseclass> tbCourseclasses = tbCourseclassMapper.selectList(tbCourseclassQueryWrapper);

        List<Map<String, Object>> mps = new ArrayList<>();
        for (TbCourseclass tbCourseclass : tbCourseclasses) {

            QueryWrapper<TbSelectcourse> tbSelectcourseQueryWrapper = new QueryWrapper<>();
            tbSelectcourseQueryWrapper.eq("StuID", stuid);
            tbSelectcourseQueryWrapper.eq("CourseClassID", tbCourseclass.getCourseclassid());
            TbSelectcourse tbSelectcourse = tbSelectcourseMapper.selectOne(tbSelectcourseQueryWrapper);

            // 当前课程未被当前学生选修
            if (tbSelectcourse == null) {
                continue;
            }

            Map<String, Object> mp = new HashMap<>();

            mp.put("CourseClassID", tbCourseclass.getCourseclassid());
            mp.put("TermID", termid);
            mp.put("TeachingYearName", teachingyearname);
            // mp.put("TeachingPlace", tbCourseclass.getTeachingplace());
            // mp.put("TeachingTime", tbCourseclass.getTeachingtime());
            // mp.put("CommonPart", tbCourseclass.getCommonpart());
            // mp.put("MaxNumber", tbCourseclass.getMaxnumber());
            // mp.put("SelectedNumber", tbCourseclass.getSelectednumber());

            // 获取该课程班对应具体的课程信息
            TbCourse tbCourse = tbCourseMapper.selectById(tbCourseclass.getCourseid());
            mp.put("CourseName", tbCourse.getCoursename());
            mp.put("CourseGrade", tbCourse.getCoursegrade());
            // mp.put("LessonTime", tbCourse.getLessontime());
            // mp.put("CourseOutline", tbCourse.getCourseoutline());

            // 获取课程班的授课老师信息
            TbTeacher tbTeacher = tbTeacherMapper.selectById(tbCourseclass.getTeacherid());
            mp.put("TeacherName", tbTeacher.getTeachername());

            QueryWrapper<TbGrade> tbGradeQueryWrapper = new QueryWrapper<>();
            tbGradeQueryWrapper.eq("StuID", stuid);
            tbGradeQueryWrapper.eq("CourseClassID", tbCourseclass.getCourseclassid());
            TbGrade tbGrade = tbGradeMapper.selectOne(tbGradeQueryWrapper);

            /*mp.put("CommonScore", tbGrade.getCommonscore());
            mp.put("MiddleScore", tbGrade.getMiddlescore());
            mp.put("LastScore", tbGrade.getLastscore());*/
            mp.put("TotalScore", tbGrade.getTotalscore());

            mps.add(mp);
        }
        resultMap.put("data", mps);
        resultMap.put("result", mps.size());
        resultMap.put("info", "查询成功！");
        return resultMap;
    }

    @Override
    public Map<String, Object> getUserCourseGrade(String stuid, String courseclassid) {
        Map<String, Object> resultMap = new HashMap<>();

        TbCourseclass tbCourseclass = tbCourseclassMapper.selectById(courseclassid);

        QueryWrapper<TbSelectcourse> tbSelectcourseQueryWrapper = new QueryWrapper<>();
        tbSelectcourseQueryWrapper.eq("StuID", stuid);
        tbSelectcourseQueryWrapper.eq("CourseClassID", courseclassid);
        TbSelectcourse tbSelectcourse = tbSelectcourseMapper.selectOne(tbSelectcourseQueryWrapper);

        // 当前课程未被当前学生选修
        if (tbSelectcourse == null) {
            resultMap.put("result", 2);
            resultMap.put("info", "未选修该课程！");
            return resultMap;
        }

        Map<String, Object> mp = new HashMap<>();

        mp.put("CourseClassID", tbCourseclass.getCourseclassid());
        // mp.put("TeachingPlace", tbCourseclass.getTeachingplace());
        // mp.put("TeachingTime", tbCourseclass.getTeachingtime());
        // mp.put("CommonPart", tbCourseclass.getCommonpart());
        // mp.put("MaxNumber", tbCourseclass.getMaxnumber());
        // mp.put("SelectedNumber", tbCourseclass.getSelectednumber());

        // 获取该课程班对应具体的课程信息
        TbCourse tbCourse = tbCourseMapper.selectById(tbCourseclass.getCourseid());
        mp.put("CourseName", tbCourse.getCoursename());
        mp.put("CourseGrade", tbCourse.getCoursegrade());
        // mp.put("LessonTime", tbCourse.getLessontime());
        // mp.put("CourseOutline", tbCourse.getCourseoutline());

        // 获取课程班的授课老师信息
        TbTeacher tbTeacher = tbTeacherMapper.selectById(tbCourseclass.getTeacherid());
        mp.put("TeacherName", tbTeacher.getTeachername());

        QueryWrapper<TbGrade> tbGradeQueryWrapper = new QueryWrapper<>();
        tbGradeQueryWrapper.eq("StuID", stuid);
        tbGradeQueryWrapper.eq("CourseClassID", tbCourseclass.getCourseclassid());
        TbGrade tbGrade = tbGradeMapper.selectOne(tbGradeQueryWrapper);

        /*mp.put("CommonScore", tbGrade.getCommonscore());
        mp.put("MiddleScore", tbGrade.getMiddlescore());
        mp.put("LastScore", tbGrade.getLastscore());*/
        mp.put("TotalScore", tbGrade.getTotalscore());

        resultMap.put("data", mp);
        resultMap.put("result", 1);
        resultMap.put("info", "查询成功！");
        return resultMap;
    }
}
