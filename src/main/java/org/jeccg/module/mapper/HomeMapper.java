package org.jeccg.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.jeccg.module.entity.Role;
import org.jeccg.module.entity.home;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMapper extends BaseMapper<home> {

    @Delete("delete from home where user_id=#{userid}")
    void deleteuser(String userid);
    @Select("select * from home where user_id = #{userid}")
    List<home> selectByid(String userid);
    @Delete("delete from home where user_id=#{id}")
    void deleteId(String id);
}
