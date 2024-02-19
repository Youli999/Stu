package com.chunyang.stu.filter.chunyang2Filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * @author Happy
 */
@WebFilter(urlPatterns = "/*")
public class XssFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        XssAndSqlHttpServletRequestWrapper xssRequestWrapper = new XssAndSqlHttpServletRequestWrapper(req);

        chain.doFilter(xssRequestWrapper, response);
    }
    @Override
    public void destroy() {
    }
    /**
     * 过滤json类型的
     * @param builder
     * @return
     */
    @Bean
    @Primary
    public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
        //解析器
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //注册xss解析器
        SimpleModule xssModule = new SimpleModule("XssStringJsonSerializer");
        xssModule.addSerializer(new XssStringJsonSerializer());
        objectMapper.registerModule(xssModule);
        //返回
        return objectMapper;
    }
}
