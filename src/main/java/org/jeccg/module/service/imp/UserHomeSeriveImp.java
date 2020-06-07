package org.jeccg.module.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserHome;
import org.jeccg.module.entity.home;
import org.jeccg.module.mapper.HomeMapper;
import org.jeccg.module.mapper.UserHomeMapper;
import org.jeccg.module.mapper.UserMapper;
import org.jeccg.module.service.UserHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserHomeSeriveImp extends ServiceImpl<UserHomeMapper,UserHome> implements UserHomeService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HomeMapper homeMapper;

    //添加
    @Override
    @Transactional
    @Cacheable(cacheNames = "emp:add",key ="#user.username")
    public UserHome add(User user, List<home> homeList) {
        this.userMapper.insert(user);
        if(homeList!=null){
            for (home h:homeList
                 ) {
                h.setUserid(user.getId());
                homeMapper.insert(h);
            }

        }
        UserHome userhome = new UserHome();
        BeanUtils.copyProperties(user,userhome);
        userhome.setHomeList(homeList);
        return userhome;
    }
    //编辑
    @Override
    public void updateMain(User user, List<home> homeList) {
        this.userMapper.updateById(user);
        this.homeMapper.deleteuser(user.getId());
        if(homeList!=null){
            for (home h:homeList) {
                h.setUserid(user.getId());
                homeMapper.insert(h);
            }
        }
    }

    //查询
    @Override
    @Cacheable(cacheNames = "emp:select",key ="#id")
    public UserHome select(String id) {
       User user = this.userMapper.selectById(id);
       UserHome userHome = new UserHome();
       BeanUtils.copyProperties(user,userHome);
       userHome.setHomeList(this.homeMapper.selectByid(id));
       return userHome;
    }

    @Override
    @CacheEvict(cacheNames = "emp:add",key = "#id",allEntries = true)
    public void removed(String id) {
            this.userMapper.deleteById(id);
            this.homeMapper.deleteId(id);
    }
}
