package org.jeccg.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "tb_user")
public class UserHome {
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "用户主键")
    private String id;
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private  String username;
    @TableField(value = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//放回的数据没有该属性,只能进行序列化不能进行反序列化
    @ApiModelProperty(value = "密码")
    private  String password;
    @ApiModelProperty("用户别名")
    private  String name;
    @ApiModelProperty("年龄")
    private  Integer age;
    @ApiModelProperty("e-mail")
    private  String email;

    private List<home> homeList;
}
