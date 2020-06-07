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
@TableName(value = "home")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "房屋")
public class home {
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "房屋主键")
    private  String id;
    private  String dizhi;
    @TableField(value = "user_id")
    private  String userid;
}
