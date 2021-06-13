package cn.hznu.service;

import cn.hznu.pojo.TbAdmin;
import cn.hznu.pojo.TbClass;
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
public interface TbAdminService extends IService<TbAdmin> {
    /**
     * 管理员登录
     *
     * @param adminId   账号
     * @param aPassword 密码
     * @return result: 1 登录成功
     * result: 2 登录失败
     */
    Map<String, Object> login(String adminId, String aPassword);

    /**
     * 根据系部id查询班级
     *
     * @param deptId 班级Id
     * @return 班级信息
     */
    Map<String, Object> queryClassInfoByDeptId(String deptId);

    /**
     * 添加班级
     *
     * @param tbClass 班级信息
     * @return 添加结果
     */
    Map<String, Object> addClassInfo(TbClass tbClass);

    /**
     * 编辑班级
     *
     * @param tbClass 班级信息
     * @return 编辑结果
     */
    Map<String, Object> modifyClassInfo(TbClass tbClass);

    /**
     * 删除班级
     *
     * @param classId 班级id
     * @return 删除结果
     */
    Map<String, Object> removeClassInfo(String classId);


    /**
     * 根据系部id | 班级id查询学生
     *
     * @param deptId  系部Id
     * @param classId 班级Id
     * @return 学生信息
     */
    Map<String, Object> queryStudentInfoByDeptIdAndClassId(String deptId, String classId);

    /**
     * 添加学生
     *
     * @param tbStudent 班级信息
     * @return 添加结果
     */
    Map<String, Object> addStudentInfo(TbStudent tbStudent);

    /**
     * 编辑学生
     *
     * @param tbStudent 学生信息
     * @return 编辑结果
     */
    Map<String, Object> modifyStudentInfo(TbStudent tbStudent);

    /**
     * 删除学生
     *
     * @param studentId 班级id
     * @return 删除结果
     */
    Map<String, Object> removeStudentInfo(String studentId);
}
