package com.team11.controller;

import com.team11.domain.MaskOrder;
import com.team11.service.MaskOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "MaskOrderController")
public class MaskOrderController {

    @Autowired
    private MaskOrderService maskOrderService;

    @PostMapping("maskOrderList")
    @ResponseBody
    public List<MaskOrder> maskOrderList(String userName){
        return maskOrderService.maskOrderList(userName);
    }

    @PostMapping("saveMaskOrder")
    @ResponseBody
    public int maskOrderList(MaskOrder maskOrder){
        return maskOrderService.save(maskOrder);
    }

}
