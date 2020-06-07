package org.jeccg.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeccg.module.entity.UserRule;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRule>{
    List<UserRule> selectUserRule(String id);
}
