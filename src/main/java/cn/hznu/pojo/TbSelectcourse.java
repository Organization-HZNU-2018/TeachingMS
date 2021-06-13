package cn.hznu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hznu
 * @since 2021-06-10
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("TB_SelectCourse")
@ApiModel(value = "TbSelectcourse对象", description = "")
public class TbSelectcourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "StuID", type = IdType.ASSIGN_ID)
    private String stuid;

    @TableField("CourseClassID")
    private String courseclassid;

    @TableField("SelectDate")
    private Date selectdate;


}
