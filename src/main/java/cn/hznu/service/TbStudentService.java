package cn.hznu.service;

import cn.hznu.pojo.TbStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
public interface TbStudentService extends IService<TbStudent> {
    /**
     * 学生登录
     *
     * @param stuid     账号
     * @param spassword 密码
     * @return result: 1 登录成功
     * result: 2 登录失败
     */
    Map<String, Object> login(String stuid, String spassword);

    /**
     * 获取当前学期的课程班列表，包含当前登入学生是否选中
     *
     * @param stuid            学号
     * @param teachingyearname 学年
     * @param termid           学期，上下学期
     * @return 数据列表
     */
    Map<String, Object> getCourseClassList(String stuid, String teachingyearname, String termid);

    /**
     * 根据课程班id查询课程班具体信息
     */
    Map<String, Object> getCourseClass(String stuid, String courseclassid);

    /**
     * 选修课程
     *
     * @param stuid         学号
     * @param courseclassid 课程班id
     * @return 选修结果
     */
    Map<String, Object> electiveCourseClass(String stuid, String courseclassid);

    /**
     * 退选课程
     *
     * @param stuid         学号
     * @param courseclassid 课程班id
     * @return 退选结果
     */
    Map<String, Object> withdrawCourseClass(String stuid, String courseclassid);


    /**
     * 查询当前学生当前学期的课程成绩列表
     *
     * @param teachingyearname 学年
     * @param termid           学期，上下学期
     */
    Map<String, Object> getUserCourseGradeList(String stuid, String teachingyearname, String termid);

    /**
     * 根据课程班和学号查找课程成绩信息
     */
    Map<String, Object> getUserCourseGrade(String stuid, String courseclassid);
}
