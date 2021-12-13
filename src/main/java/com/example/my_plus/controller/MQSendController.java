package com.example.my_plus.controller;

import com.example.my_plus.entity.SysUser;
import com.example.my_plus.service.impl.MQSender;
import com.example.my_plus.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MQSend")
@Api("MQ消息发送")
public class MQSendController {

    @Autowired
    private MQSender mqSender;

    @GetMapping("/send")
    public R send(String msg){
        SysUser sysUSer = new SysUser();
        sysUSer.setUserName("张三");
        sysUSer.setUserId(11111L);
        sysUSer.setIdCard(msg);
        mqSender.send(sysUSer);
        return R.ok();
    }

    @GetMapping("/send1")
    public R send1(String msg){
        mqSender.send1(msg);
        return R.ok();
    }

}
