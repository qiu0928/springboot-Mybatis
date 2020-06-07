package org.jeccg.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleMapper extends BaseMapper<Role> {

}
