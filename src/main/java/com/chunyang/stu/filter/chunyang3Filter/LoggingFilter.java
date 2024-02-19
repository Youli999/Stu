package com.chunyang.stu.filter.chunyang3Filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // 对请求进行预处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;


        //进行判断
        // 如果请求的 Content-Type 是 application/json，则从请求体中获取 JSON 参数
        if ("application/json".equals(request.getContentType())) {

            // Json 拦截器
            CustomHttpServletRequestWrapper requestWrapper = getCustomHttpServletRequestWrapper(request);
            // 继续处理请求
            filterChain.doFilter(requestWrapper, servletResponse);
        }else {

            //普通参数
            extracted(request,filterChain,servletResponse);

        }

    }

    //普通参数
    private static void extracted(HttpServletRequest request, FilterChain filterChain,ServletResponse servletResponse) throws ServletException, IOException {
        // 获取请求的所有参数（普通参数）
        Map<String, String[]> parameterMap = request.getParameterMap();

        // 遍历参数，并输出它们的名称和值  不为空
        for (String paramName : parameterMap.keySet()) {
            String[] paramValues = parameterMap.get(paramName);
            for (String paramValue : paramValues) {

                //编码转换   //过滤请求中非法数据
//              ; String filteredValue = Encode.forHtml(paramValue); // 使用OWASP Encoder进行HTML编码
//                System.out.println("Parameter: " + paramName + " = " + filteredValue);



                // 继续处理请求
                filterChain.doFilter(request, servletResponse);

            }
        }
    }

    // Json 拦截器
    private static CustomHttpServletRequestWrapper getCustomHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        // 使用自定义的包装器
        CustomHttpServletRequestWrapper requestWrapper = new CustomHttpServletRequestWrapper(request);

        // 获取请求体的JSON数据
        byte[] body = requestWrapper.getBody();
        String jsonPayload = new String(body, StandardCharsets.UTF_8);

        // 输出日志
        System.out.println("JSON Payload: " + jsonPayload);
        return requestWrapper;
    }

    // 其他方法（init和destroy）省略...
}
