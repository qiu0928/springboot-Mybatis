package org.jeccg.module.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeccg.module.entity.User;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试swagger")
@RestController
@RequestMapping("/user")
public class MybatisController {
   @Autowired
   private UserserverImp userserverImp;
    @GetMapping("/hello")
    @ApiOperation(value = "测试hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user")
    @ApiOperation(value = "测试用户信息")
    public User user(){
        return new User();
    }
    @PostMapping("/save")
    @ApiOperation(value = "保存数据")
    public String save(@RequestBody User user){
        this.userserverImp.save(user);
        return "保存成功";
    }
    @PutMapping("/update")
    @ApiOperation(value = "编辑")
    public String update(@RequestBody User user){
        this.userserverImp.updateById(user);
        return "成功更新";
    }

}
