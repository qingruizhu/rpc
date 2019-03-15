package com.zqr.rpc.protocol.http;

import com.zqr.rpc.framework.Invocation;
import com.zqr.rpc.framework.URL;
import com.zqr.rpc.register.Register;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handle(HttpServletRequest req, HttpServletResponse resp){
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation= (Invocation) objectInputStream.readObject();
            //找实现类
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);
            Class implClass = Register.get(url, interfaceName);
            //注册的方法执行
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String rst = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            //响应
            OutputStream os =resp.getOutputStream();
            IOUtils.write(rst,os);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
