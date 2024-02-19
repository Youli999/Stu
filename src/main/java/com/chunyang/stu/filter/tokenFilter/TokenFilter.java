package com.chunyang.stu.filter.tokenFilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Component
public class TokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化时执行的逻辑
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("start token");
        // 从请求头中获取 token
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            // 如果请求头中没有 token，返回未授权错误
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "未授权");
        } else {
            // 对 token 进行验证逻辑
            boolean isValid = validateToken(token);

            if (isValid) {
                // 如果 token 是有效的，继续执行后续请求
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // 如果 token 是无效的，返回未授权错误
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "token认证失败");
            }
        }

        System.out.println("start token");
    }

    @Override
    public void destroy() {
        // 过滤器销毁时执行的逻辑
    }

    private boolean validateToken(String token) {
        // TODO: 实现验证 token 的逻辑，可以使用 JWT 或其他方式
        if(token.equals("[B@3486691")){
            return true;
        }else{

            return false;

        }

    }
}
