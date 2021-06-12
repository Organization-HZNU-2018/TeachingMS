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
@TableName("TB_Student")
@ApiModel(value="TbStudent对象", description="")
public class TbStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "StuID", type = IdType.ASSIGN_ID)
    private String stuid;

    @TableField("StuName")
    private String stuname;

    @TableField("EnrollYear")
    private String enrollyear;

    @TableField("GradYear")
    private String gradyear;

    @TableField("DeptID")
    private String deptid;

    @TableField("ClassID")
    private String classid;

    @TableField("Sex")
    private String sex;

    @TableField("Birthday")
    private Date birthday;

    @TableField("SPassword")
    private String spassword;

    @TableField("StuAddress")
    private String stuaddress;

    @TableField("ZipCode")
    private String zipcode;


}
