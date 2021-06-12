package cn.hznu.service.impl;

import cn.hznu.mapper.TbStudentMapper;
import cn.hznu.pojo.TbStudent;
import cn.hznu.service.TbStudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
