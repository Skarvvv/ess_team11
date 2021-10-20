package com.team11.dao;

import com.team11.domain.User;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("SELECT * FROM T_USER WHERE UNAME = #{account} OR UTEL = #{account} OR EMAIL = #{account}")
    public User selectOne(String account);

}
