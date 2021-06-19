package cn.hznu.service;

import cn.hznu.pojo.TbGrade;
import cn.hznu.pojo.TbStudent;
import cn.hznu.pojo.TbTeacher;
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
public interface TbTeacherService extends IService<TbTeacher> {
    /**
     * 教师登录
     *
     * @param teacherId 账号
     * @param tPassword 密码
     * @return result: 1 登录成功
     * result: 2 登录失败
     */
    Map<String, Object> login(String teacherId, String tPassword);

    /**
     * 根据系部id && 班级id && 学生id查询学生成绩
     *
     * @param teachingPlace 课程班级Id
     * @param teachingTime  班级Id
     * @param courseId      课程Id
     * @return 学生成绩信息
     */
    Map<String, Object> queryStudentInfoByCondition(String teachingPlace, String teachingTime, String courseId, String teacherId);

    /**
     * 更新成绩
     *
     * @param tbGrade 成绩信息
     * @return 更新结果
     */
    Map<String, Object> modifyGradeInfo(TbGrade tbGrade);

    /**
     * 录入成绩
     *
     * @param tbGrade 成绩信息
     * @return 添加结果
     */
    Map<String, Object> addGradeInfo(TbGrade tbGrade);
}
