package com.team11.service;

import com.team11.dao.MaskOrderDao;
import com.team11.domain.MaskOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaskOrderService {

    @Autowired
    private MaskOrderDao maskOrderDao;

    public int save(MaskOrder maskOrder){
        return maskOrderDao.save(maskOrder);
    }

    public List<MaskOrder> maskOrderList(String userName){
        return maskOrderDao.maskOrderList(userName);
    }

}
