package com.zqr.rpc.consumer;

import com.zqr.rpc.framework.Invocation;
import com.zqr.rpc.protocol.http.HttpClient;
import com.zqr.rpc.provider.api.HelloService;

public class consumer {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Object[]{"你好"}, new Class[]{String.class});
        String rsp = httpClient.post("localhost", 8080, invocation);
        System.out.println(rsp);
    }
}
