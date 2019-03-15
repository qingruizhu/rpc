package com.zqr.rpc.framework;

import java.io.Serializable;

public class Invocation implements Serializable {
    /**
     * 调用接口名称
     */
    private String interfaceName;
    /**
     *调用方法名称
     */
    private String methodName;
    /**
     * 参数值列表
     */
    private Object[] params;
    /**
     * 参数类型列表
     */
    private Class[] paramTypes;

    public Invocation(String interfaceName, String methodName, Object[] params, Class[] paramTypes) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}
