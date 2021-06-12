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
     * @param stuid 账号
     * @param spassword 密码
     * @return
     *      result: 1 登录成功
     *      result: 2 登录失败
     *
     *      info: 具体描述
     */
    Map<String, Object> login(String stuid, String spassword);

}
