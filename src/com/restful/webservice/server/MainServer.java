package com.restful.webservice.server;

import com.restful.webservice.service.StudentService;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class MainServer {

    public static void main(String[] args) {
        JAXRSServerFactoryBean serverFactoryBean = new JAXRSServerFactoryBean();
        serverFactoryBean.setServiceClass(StudentService.class);
        serverFactoryBean.setAddress("http://192.168.1.16:9999/rs_post_demo");
        Server server = serverFactoryBean.create();
        server.start();
        System.out.println("restful风格的Webservice服务启动成功");
    }

}
