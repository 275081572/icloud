package icloud.serviceconsumer.ribbom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: xuwei
 * @Date: 2020/7/3 14:40
 */
@RestController
public class HelloController {

    @Autowired RestTemplate restTemplate;

    @RequestMapping("/")
    public String hi(String name){
        //这里直接写的是服务名： eureka-serviceprovider  。在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://eureka-serviceprovider?name=" + name, String.class);
    }

}
