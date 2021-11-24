package com.team11.dao;

import com.team11.domain.MaskOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaskOrderDao {

    @Select("SELECT * FROM MASK_ORDER WHERE UNAME=#{userName} OR RNAME=#{userName}")
    List<MaskOrder> maskOrderList(String userName);

    @Insert("INSERT INTO MASK_ORDER VALUES(NULL,#{uname},#{rname},#{ptype},#{pnumber},#{rtel},#{address},#{saddress},#{atime},#{mtype},#{mnumber},#{ordertime},NULL,NULL,NULL,NULL,1)")
    int save(MaskOrder maskOrder);

}
