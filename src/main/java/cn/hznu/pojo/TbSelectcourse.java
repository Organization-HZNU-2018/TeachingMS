package cn.hznu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@TableName("TB_SelectCourse")
@ApiModel(value="TbSelectcourse对象", description="")
public class TbSelectcourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "StuID", type = IdType.ASSIGN_ID)
    private String stuid;

    @TableField("CourseClassID")
    private String courseclassid;

    @TableField("SelectDate")
    private Date selectdate;


}
