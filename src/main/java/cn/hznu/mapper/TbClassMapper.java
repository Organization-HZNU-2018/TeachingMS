package cn.hznu.mapper;

import cn.hznu.pojo.TbClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
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
public interface TbClassMapper extends BaseMapper<TbClass> {
    @Select("<script>" +
            "select * FROM TB_Class c left join TB_Dept d on c.DeptID = d.DeptID left join TB_Teacher t on c.TeacherID = t.TeacherID"
            + "<if test='deptId!=null'>where c.DeptID=#{deptId}</if> order by c.ClassID"
            + "</script>")
    List<Map<String, Object>> getClassInfoByDeptId(@Param("deptId") String deptId);
}
