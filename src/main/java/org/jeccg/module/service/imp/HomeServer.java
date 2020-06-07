package org.jeccg.module.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.home;
import org.jeccg.module.mapper.HomeMapper;
import org.jeccg.module.mapper.UserMapper;
import org.jeccg.module.service.HomeServiceImp;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServer extends ServiceImpl<HomeMapper,home> implements HomeServiceImp {

}
