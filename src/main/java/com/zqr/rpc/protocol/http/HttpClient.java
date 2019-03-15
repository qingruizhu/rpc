package com.zqr.rpc.protocol.http;

import com.zqr.rpc.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public String post(String hostname, Integer port, Invocation invocation){
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();
            InputStream is = connection.getInputStream();
            String rsp = IOUtils.toString(is);
            return rsp;
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return  null;

    }
}
