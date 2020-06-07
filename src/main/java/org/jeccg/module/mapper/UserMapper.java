package org.jeccg.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserRule;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    public List<User> findAll();
    void saven(User user);

    IPage<User> selectByPassword(IPage<User> page, @Param("password")String password);

    void removeByName(@Param("fenename") String[] feneName);


    List<Role> selectRole(String Username);
}
