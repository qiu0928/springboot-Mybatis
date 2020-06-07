package org.jeccg.module.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserRule;
import org.jeccg.module.mapper.UserMapper;
import org.jeccg.module.mapper.UserRoleMapper;
import org.jeccg.module.service.UserRoleService;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRoleServiceImp extends ServiceImpl<UserRoleMapper,UserRule> implements UserRoleService {
}
