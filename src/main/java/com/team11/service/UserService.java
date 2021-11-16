package com.team11.service;

import com.team11.dao.UserDao;
import com.team11.domain.User;
import com.team11.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public UserVO selectOne(String account){
        User user = dao.selectOne(account);
        UserVO vo = new UserVO();
        if (user != null) {
            BeanUtils.copyProperties(user, vo);
            if (user.getSex() != null){
                vo.setSex(user.getSex() == 0 ? "女" : "男");
            }
            if (user.getPtype() != null) {
                vo.setPtype(user.getPtype() == 1 ? "居民身份证" : "其他证件类型");
            }
        }
        return vo;
    }

    public int register(User user){
        try {
            return dao.insertOne(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

//    public int messageUpdate(User user){
//
//    }

}
