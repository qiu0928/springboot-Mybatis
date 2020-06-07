package org.jeccg.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("tb_user_rule")
public class UserRule {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @TableField(value = "user_id")
    private String userid;
    @TableField(value = "rule_id")
    private  String ruleid;
    public UserRule(String userid, String ruleid) {
        this.userid = userid;
        this.ruleid = ruleid;
    }

    public UserRule(String id, String userid, String ruleid) {
        this.id = id;
        this.userid = userid;
        this.ruleid = ruleid;
    }
}
