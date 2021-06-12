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
@TableName("TB_Class")
@ApiModel(value="TbClass对象", description="")
public class TbClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ClassID", type = IdType.ASSIGN_ID)
    private String classid;

    @TableField("ClassName")
    private String classname;

    @TableField("DeptID")
    private String deptid;

    @TableField("TeacherID")
    private String teacherid;


}
