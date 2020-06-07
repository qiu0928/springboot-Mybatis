package org.jeccg.module.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserRule;
import org.jeccg.module.mapper.UserMapper;
import org.jeccg.module.mapper.UserRoleMapper;
import org.jeccg.module.service.UserRoleService;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServer extends ServiceImpl<UserMapper,User> implements UserserverImp {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    //自定义分页
    @Override
    public IPage<User> page(IPage<User> page, String password) {
        return this.userMapper.selectByPassword(page, password);
    }
    //保存User对象和Rule对象的关联
    @Override
    public void userRoleSave(User user, String ids) {
        this.userMapper.insert(user);
        if(ids!=null){
            String[] idss = ids.split(",");
            for (String id :idss
                 ) {
                UserRule userRule = new UserRule(user.getId(),id);
                this.userRoleMapper.insert(userRule);
            }
        }
    }
    //根据用户的username查询角色表
    @Override
    @Transactional
    public List<Role> selectRole(String Username) {
        return this.userMapper.selectRole(Username);
    }
}
