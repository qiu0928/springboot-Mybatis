package org.jeccg.module.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeccg.module.entity.User;
import org.jeccg.module.entity.UserHome;
import org.jeccg.module.entity.home;
import org.jeccg.module.service.HomeServiceImp;
import org.jeccg.module.service.UserHomeService;
import org.jeccg.module.service.UserserverImp;
import org.jeccg.module.service.imp.HomeServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.*;

@RestController
@Api(tags = "一对多")
@RequestMapping("/homg")
@Slf4j
public class UserhomeController {

    @Autowired
    private HomeServiceImp homeServer;
    @Autowired
    private UserserverImp userserverImp;
    @Autowired
    private UserHomeService userHomeService;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public UserHome add(@RequestBody UserHome userHome){
        User user = new User();
        BeanUtils.copyProperties(userHome,user);
        UserHome userhome = userHomeService.add(user,userHome.getHomeList());
        return userhome;
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    @CachePut(cacheNames = "emp:add",key = "#userHome.id")
    public UserHome update(@RequestBody UserHome userHome){
        User user = new User();
        BeanUtils.copyProperties(userHome,user);
        userHomeService.updateMain(user,userHome.getHomeList());
        return userHome;
    }
    @GetMapping("/get")
    @ApiOperation(value = "查询")
    public  UserHome select(@RequestParam(name = "id")String id){
        UserHome userHome =this.userHomeService.select(id);
        return  userHome;
    }
    @PostMapping("jsonadd")
    @ApiOperation("测试使用JsonObject添加数据")
    //在多表中添加部门id
    public String adds(@RequestBody String jsonObject){
        JSONObject object = JSONObject.parseObject(jsonObject);
        String user =object.getString("User");
        log.info(user.toString());
        //对User对象进行赋值
        User user1 = JSON.parseObject(user,User.class);
        //  {"password":"125896","name":"悟空","age":1050,"email":"125658498875@xianlang","username":"孙悟空"}
        //对集合中的数据进行赋值
        String homes = object.getString("selecthome");
        String homea =homes.substring(1,homes.length()-1);
        List<String>  homec = Arrays.asList(homea.split(","));
        List<home> homese = new ArrayList<>();
        for (String homewe:homec) {
            home homew = JSON.parseObject(homewe,home.class);
            homese.add(homew);
        }
        userHomeService.add(user1,homese);
        System.out.println(homese);
        return "添加成功";
        //[home(id=null, dizhi=sd, userid=12656), home(id=null, dizhi=sdsd, userid=12656)]

    }
    //根据id删除数据
    @DeleteMapping("/delete")
    @ApiOperation("删除")
    public void remove(@RequestParam(name = "id") String id){
        this.userHomeService.removed(id);

    }
}
