package cn.hznu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("TB_Course")
@ApiModel(value="TbCourse对象", description="")
public class TbCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CourseID", type = IdType.ASSIGN_ID)
    private String courseid;

    @TableField("CourseName")
    private String coursename;

    @TableField("DeptID")
    private String deptid;

    @TableField("CourseGrade")
    private Double coursegrade;

    @TableField("LessonTime")
    private Integer lessontime;

    @TableField("CourseOutline")
    private String courseoutline;


}
