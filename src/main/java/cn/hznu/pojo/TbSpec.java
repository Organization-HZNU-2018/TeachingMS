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
@TableName("TB_Spec")
@ApiModel(value="TbSpec对象", description="")
public class TbSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SpecID", type = IdType.ASSIGN_ID)
    private String specid;

    @TableField("SpecName")
    private String specname;

    @TableField("DeptID")
    private String deptid;

    @TableField("SpecScript")
    private String specscript;


}
