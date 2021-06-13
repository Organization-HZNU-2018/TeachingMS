package cn.hznu.mapper;

import cn.hznu.pojo.TbStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@Repository
public interface TbStudentMapper extends BaseMapper<TbStudent> {

}
