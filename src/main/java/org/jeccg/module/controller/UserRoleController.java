package org.jeccg.module.controller;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.buf.StringUtils;
import org.jeccg.module.common.api.Result;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.User;
import org.jeccg.module.service.UserserverImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
@Api(tags = "多对多")
public class UserRoleController {
    @Autowired
    private UserserverImp userserverImp;
    //添加用户和角色关联
    @PostMapping("/add")
    @ApiOperation(value = "添加关系")
    public String save(@RequestBody String  userandRole){
        JSONObject jsonObject = JSON.parseObject(userandRole);
        User user = JSON.parseObject(jsonObject.getString("user"),User.class);
        String ids = jsonObject.getString("Ruleids");
//        String idss= ids.substring(1,ids.length()-1);
        this.userserverImp.userRoleSave(user,ids);
        return "成功";
    }
    //查询关联表
    @GetMapping("/select")
    @ApiOperation("关联查询")
    public Result<JSONObject> selects(@RequestParam(name = "Username") String Username){
        List<Role> roles = this.userserverImp.selectRole(Username);
        //集合转字符串
       // String sern= Convert.toStr(roles);
        Result<JSONObject> sern = new Result<>();
        JSONObject json = new JSONObject();
        json.put("Rule",roles);
        sern.setResult(json);
        return  sern;
    }

}
