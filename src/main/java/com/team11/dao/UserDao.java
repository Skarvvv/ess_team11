package com.team11.dao;

import com.team11.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("SELECT * FROM T_USER WHERE UNAME = #{account} OR UTEL = #{account} OR EMAIL = #{account}")
    User selectOne(String account);

    @Insert("INSERT INTO T_USER VALUES(null,#{uname},#{upass},#{utel},#{email},#{photo},#{sex},#{ptype},#{pnumber},#{birthday},#{country},#{y11},#{y12},#{y13},#{y14},1)")
    int insertOne(User user);

    @Update("UPDATE T_USER SET UNAME=#{uname},UPASS=#{upass},UTEL=#{utel},EMAIL=#{email},#{photo},#{sex},#{ptype},#{pnumber},#{birthday},#{country},#{y11},#{y12},#{y13},#{y14} WHERE UID=#{uid}")
    int update(User user);

}
