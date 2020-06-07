package org.jeccg.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "角色")
public class Role {
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "角色主键")
    private  String id;
    private  String name;
    private  String qun;

}
