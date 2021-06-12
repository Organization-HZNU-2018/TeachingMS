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
@TableName("TB_CourseClass")
@ApiModel(value="TbCourseclass对象", description="")
public class TbCourseclass implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CourseClassID", type = IdType.ASSIGN_ID)
    private String courseclassid;

    @TableField("CourseID")
    private String courseid;

    @TableField("TeacherID")
    private String teacherid;

    @TableField("TeachingYearID")
    private String teachingyearid;

    @TableField("TermID")
    private String termid;

    @TableField("TeachingPlace")
    private String teachingplace;

    @TableField("TeachingTime")
    private String teachingtime;

    @TableField("CommonPart")
    private Integer commonpart;

    @TableField("MiddlePart")
    private Integer middlepart;

    @TableField("LastPart")
    private Integer lastpart;

    @TableField("MaxNumber")
    private Integer maxnumber;

    @TableField("SelectedNumber")
    private Integer selectednumber;

    @TableField("FullFlag")
    private String fullflag;


}
