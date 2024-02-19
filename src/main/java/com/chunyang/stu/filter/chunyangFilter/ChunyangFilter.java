package com.chunyang.stu.filter.chunyangFilter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class ChunyangFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(httpRequest);


        System.out.println("start chunyang");
        chain.doFilter(xssRequest, response);
        System.out.println("end chunyang");
    }

    @Override
    public void destroy() {
        // 销毁操作
    }
}
