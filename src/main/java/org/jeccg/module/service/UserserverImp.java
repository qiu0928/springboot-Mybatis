package org.jeccg.module.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserserverImp extends IService<User> {
    IPage<User> page(IPage<User> page, String password);

    void userRoleSave(User user, String ids);

    List<Role> selectRole(String Username);
}
