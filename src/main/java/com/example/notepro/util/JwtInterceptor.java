//package com.example.notepro.util;
//import com.example.notepro.util.JwtUtils;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//
//@Component
//public class JwtInterceptor implements HandlerInterceptor {
//
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 从请求头中获取 token
//        String token = request.getHeader("Authorization");
//
//        // 验证 token
//        if (token != null && jwtUtils.validateToken(token)) {
//
//            return true; // 验证通过，继续处理请求
//
//        } else {
//            // 设置响应状态码为 401
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//            // 设置响应内容为 JSON 格式的错误信息
//            String errorMessage = "{\"error\": \"token无效\"}";
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(errorMessage);
//
//            return false; // 验证失败，不继续处理请求
//
//        }
//    }
//}