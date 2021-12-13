package com.example.my_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jobob
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser extends Parent {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "手机号")
    private String userPhone;

    @ApiModelProperty(value = "启用状态")
    private Integer isEnabled;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否删除")
    private Integer isDel;

    @ApiModelProperty(value = "创建人ID")
    private Long createUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人ID")
    private Long updateUser;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "部门编号")
    private Long departmentId;

    @ApiModelProperty(value = "性别")
    private Boolean sex;

    @ApiModelProperty(value = "用户头像")
    private Long photo;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;


}
