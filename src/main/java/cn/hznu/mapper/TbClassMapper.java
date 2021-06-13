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
            "select TB_Class.*,TB_Dept.`DeptName`,TB_Teacher.`TeacherName` FROM TB_Class natural join TB_Dept natural join TB_Teacher"
            + "<if test='deptId!=null'>where TB_Class.DeptID=#{deptId}</if> order by TB_Class.ClassID"
            + "</script>")
    List<Map<String, Object>> getClassInfoByDeptId(@Param("deptId") String deptId);
}
