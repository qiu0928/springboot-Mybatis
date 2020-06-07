package org.jeccg.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserHome;
import org.jeccg.module.entity.home;

import java.util.List;

public interface UserHomeService extends IService<UserHome> {
    UserHome add(User user, List<home> homeList);

    void updateMain(User user, List<home> homeList);

    UserHome select(String id);

    void removed(String id);
}
