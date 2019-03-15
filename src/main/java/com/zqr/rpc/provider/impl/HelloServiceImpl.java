package com.zqr.rpc.provider.impl;

import com.zqr.rpc.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {

    public String sayHello(String username){
        return "hello:"+username;
    }
}
