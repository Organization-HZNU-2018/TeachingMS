package cn.hznu.mapper;

import cn.hznu.pojo.TbStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
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
public interface TbStudentMapper extends BaseMapper<TbStudent> {

    @Select("<script>" +
            "select TB_Student.*,TB_Dept.`DeptName`,TB_Class.`ClassName` FROM TB_Student natural join TB_Dept natural join TB_Class"
            + "<where>"
            + "<if test='deptId!=null'>and TB_Student.DeptID=#{deptId}</if>"
            + "<if test='classId!=null'>and TB_Student.ClassID=#{classId}</if>"
            + "</where> order by TB_Student.StuID"
            + "</script>")
    List<Map<String, Object>> getClassInfoByDeptIdAndClassId(@Param("deptId") String deptId, @Param("classId") String classId);

}
