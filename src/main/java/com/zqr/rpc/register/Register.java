package com.zqr.rpc.register;

import com.zqr.rpc.framework.URL;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private static Map<String, Map<URL,Class>> REGISTER = new HashMap<String, Map<URL, Class>>();

    public static void regist(URL url,String interfaceName,Class implClass){
        Map<URL, Class> map  = new HashMap<URL,Class>();
        map.put(url,implClass);
        REGISTER.put(interfaceName,map);
    }

    public static Class get(URL url,String interfaceName){
        Class implClass = REGISTER.get(interfaceName).get(url);
        return implClass;
    }

    public static URL get(String interfaceName){
        return null;
    }
}
