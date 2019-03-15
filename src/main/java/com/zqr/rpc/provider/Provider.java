package com.zqr.rpc.provider;

import com.zqr.rpc.framework.URL;
import com.zqr.rpc.protocol.http.HttpServer;
import com.zqr.rpc.provider.api.HelloService;
import com.zqr.rpc.provider.impl.HelloServiceImpl;
import com.zqr.rpc.register.Register;

public class Provider {

    public static void main(String[] args) {
        //注册服务
        URL url = new URL("localhost", 8080);
        Register.regist(url, HelloService.class.getName(), HelloServiceImpl.class);
        //启动tomcat,加载servelet
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
    }
}

