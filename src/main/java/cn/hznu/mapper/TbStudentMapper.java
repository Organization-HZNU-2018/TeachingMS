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
            "select * FROM TB_Student s left join TB_Dept d on s.DeptID = d.DeptID left join TB_Class c on s.ClassID=c.ClassID"
            + "<where>"
            + "<if test='deptId!=null'>and s.DeptID=#{deptId}</if>"
            + "<if test='classId!=null'>and s.ClassID=#{classId}</if>"
            + "</where> order by s.StuID"
            + "</script>")
    List<Map<String, Object>> getClassInfoByDeptIdAndClassId(@Param("deptId") String deptId, @Param("classId") String classId);

}
