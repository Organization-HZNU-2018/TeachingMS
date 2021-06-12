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
@TableName("TB_Teacher")
@ApiModel(value="TbTeacher对象", description="")
public class TbTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TeacherID", type = IdType.ASSIGN_ID)
    private String teacherid;

    @TableField("TeacherName")
    private String teachername;

    @TableField("DeptID")
    private String deptid;

    @TableField("Sex")
    private String sex;

    @TableField("Birthday")
    private String birthday;

    @TableField("TPassword")
    private String tpassword;

    @TableField("TitleID")
    private String titleid;


}
