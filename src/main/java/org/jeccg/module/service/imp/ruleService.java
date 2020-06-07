package org.jeccg.module.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.jeccg.module.mapper.RuleMapper;
import org.jeccg.module.mapper.UserMapper;
import org.jeccg.module.service.RuleServiceImp;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ruleService extends ServiceImpl<RuleMapper,Role> implements RuleServiceImp {
    @Autowired
    private RuleMapper ruleMapper;
}
