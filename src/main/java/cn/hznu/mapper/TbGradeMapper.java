package cn.hznu.mapper;

import cn.hznu.pojo.TbGrade;
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
public interface TbGradeMapper extends BaseMapper<TbGrade> {
    @Select("<script>"
            + "select TB_Grade.*,TB_Course.`CourseName`,TB_Class.`ClassName`,TB_CourseClass.`TeachingTime`,TB_CourseClass.`TeachingPlace`,TB_Student.`StuName`"
            + " FROM TB_Grade natural join TB_CourseClass natural join TB_Student inner join TB_Course on TB_Course.CourseID = TB_CourseClass.CourseID inner join TB_Class on TB_Class.ClassID = TB_Student.ClassID"
            + "<where>"
            + "<if test='teachingPlace!=null'>and TB_CourseClass.TeachingPlace=#{teachingPlace}</if>"
            + "<if test='teachingTime!=null'>and TB_CourseClass.TeachingTime=#{teachingTime}</if>"
            + "<if test='courseId!=null'>and TB_CourseClass.CourseID=#{courseId}</if>"
            + "<if test='teacherId!=null'>and TB_CourseClass.TeacherID=#{teacherId}</if>"
            + "</where> order by TB_Grade.StuID"
            + "</script>")
    List<Map<String, Object>> getGradeInfoByCondition(@Param("teachingPlace") String teachingPlace, @Param("teachingTime") String teachingTime,
                                                      @Param("courseId") String courseId, @Param("teacherId") String teacherId);
}