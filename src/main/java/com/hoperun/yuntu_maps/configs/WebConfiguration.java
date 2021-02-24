package com.hoperun.yuntu_maps.configs;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.hoperun.yuntu_maps.interceptors.TokenInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
 
    private TokenInterceptor tokenInterceptor;
 
    //构造方法
    public WebConfiguration(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        excludePath.add("/user/register");  //登录
        excludePath.add("/user/login");     //注册
        excludePath.add("/static/**");  //静态资源
        excludePath.add("/assets/**");  //静态资源
 
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }


}
