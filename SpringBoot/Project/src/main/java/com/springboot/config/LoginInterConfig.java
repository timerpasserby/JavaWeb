package com.springboot.config;



import com.springboot.security.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin.html","/table.html","/modpwd.html")//禁止访问路径
                .excludePathPatterns("/index.html","/","/login.html");//放行路径
        //  - /**： 匹配所有路径
        //  - /admin/**：匹配 /admin/ 下的所有路径
        //  - /admin/*：只匹配 /admin/login，不匹配 /secure/login/tologin ("/*"只匹配一级子目录，"/**"匹配所有子目录)
    }

}
