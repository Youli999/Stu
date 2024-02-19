package com.chunyang.stu.filter.tokenFilter;

import com.chunyang.stu.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/*")
//@Component
public class TokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化时执行的逻辑
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 从请求头中获取 token
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            // 如果请求头中没有 token，返回未授权错误
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"timestamp\": \"" + new java.util.Date() + "\", \"status\": 401, \"error\": \"Unauthorized\", \"message\": \"未授权\", \"path\": \"" + request.getRequestURI() + "\"}");
            out.flush();
            out.close();
        } else {
            // 对 token 进行验证逻辑
            boolean isValid = validateToken(token);

            if (isValid) {
                // 如果 token 是有效的，继续执行后续请求
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // 如果 token 是无效的，返回未授权错误
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.write("{\"timestamp\": \"" + new java.util.Date() + "\", \"status\": 401, \"error\": \"Unauthorized\", \"message\": \"token认证失败\", \"path\": \"" + request.getRequestURI() + "\"}");
                out.flush();
                out.close();
            }
        }
    }

    @Override
    public void destroy() {
        // 过滤器销毁时执行的逻辑
    }

    private boolean validateToken(String token) {
        try {
            // 尝试解析JWT令牌
            Claims claims = JwtUtils.parseToken(token);
            String subject = claims.getSubject();
            // 如果subject存在且不为空，则令牌有效
            if (subject != null && !subject.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            // 如果解析过程中发生异常，例如令牌格式错误或签名验证失败
            // 这里可以记录异常信息，例如使用日志框架
            e.printStackTrace();
        }
        // 如果令牌无效或解析过程中出现异常，返回false
        return false;
    }
}
