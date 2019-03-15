package com.zqr.rpc.protocol.http;


import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {

        public void start(String hostName, Integer port){
            Tomcat tomcat = new Tomcat();
            //service
            Server server = tomcat.getServer();
            Service service = server.findService("Tomcat");
            //connect
            Connector connector = new Connector();
            connector.setPort(port);
            //engine
            Engine engine  = new StandardEngine();
            engine.setDefaultHost(hostName);
            //host
            Host host = new StandardHost();
            host.setName(hostName);
            //contex
            String contexPath = "";
            Context context = new StandardContext();
            context.setPath(contexPath);
            context.addLifecycleListener(new Tomcat.FixContextListener());

            //设置
            host.addChild(context);
            engine.addChild(host);

            service.setContainer(engine);
            service.addConnector(connector);

            //添加serverlet
            tomcat.addServlet(contexPath,"dispacher",new DispacherServlet());
            context.addServletMappingDecoded("/*","dispacher");

            //启动
            try {
                tomcat.start();
                tomcat.getServer().await();
            } catch (LifecycleException e) {
                e.printStackTrace();
            }

        }

}

