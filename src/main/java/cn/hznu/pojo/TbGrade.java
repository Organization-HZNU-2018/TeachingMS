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
@TableName("TB_Grade")
@ApiModel(value="TbGrade对象", description="")
public class TbGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "GradeSeedID", type = IdType.AUTO)
    private Integer gradeseedid;

    @TableField("StuID")
    private String stuid;

    @TableField("ClassID")
    private String classid;

    @TableField("CourseClassID")
    private String courseclassid;

    @TableField("CourseID")
    private String courseid;

    @TableField("CommonScore")
    private Double commonscore;

    @TableField("MiddleScore")
    private Double middlescore;

    @TableField("LastScore")
    private Double lastscore;

    @TableField("TotalScore")
    private Double totalscore;

    @TableField("RetestScore")
    private Double retestscore;

    @TableField("LockFlag")
    private String lockflag;


}
