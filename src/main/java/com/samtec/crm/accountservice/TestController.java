package com.samtec.crm.accountservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/test"})
public class TestController {

    @Value("${spring.application.name}")
    public String appName;

    @Value("${spring.datasource.driver-class-name}")
    public String appProfile;

    @Value("${spring.datasource.url}")
    public String appConfigUrl;

    @GetMapping(path = {"/"})
    public String appDetails(){
        return String.format("App Name %s App Profile %s App Config Url %s ",appName,appProfile,appConfigUrl);
    }
}
