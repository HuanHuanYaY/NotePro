//package com.example.notepro.Interceptor;
//import com.example.notepro.util.JwtInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class WebMvcConfig  implements WebMvcConfigurer {
//
//    @Autowired
//    private JwtInterceptor jwtInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/users/**")// 配置拦截路径，这里假设所有 API 都需要验证 token
//                .excludePathPatterns("/users/SelectOneAccount");// 这是可以排除的路径，
//        // 比如登录接口，登录接口不需要 token 验证
//
//        // 如果有多个拦截器，可以这样继续添加
//        // registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/login");
//        // registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/update");
//        // registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/delete");
//        // registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/getById");
//
//    }
//
//}