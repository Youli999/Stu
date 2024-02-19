package com.chunyang.stu.filter.config;
import com.chunyang.stu.filter.chunyangFilter.ChunyangFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置文件
 * 过滤器顺序
 *
 */


@Configuration
public class FilterConfiguration {

//
//        @Bean
//        public FilterRegistrationBean RegistTest1(){
//            //通过FilterRegistrationBean实例设置优先级可以生效
//            //通过@WebFilter无效
//            FilterRegistrationBean bean = new FilterRegistrationBean();
//            bean.setFilter(new ChunyangFilter());//注册自定义过滤器
//            bean.setName("xss过滤器");//过滤器名称
//            bean.addUrlPatterns("/*");//过滤所有路径
//            bean.setOrder(2);//优先级，最顶级
//            return bean;
//        }
//     @Bean
//        public FilterRegistrationBean RegistTest2(){
//            //通过FilterRegistrationBean实例设置优先级可以生效
//            //通过@WebFilter无效
//            FilterRegistrationBean bean = new FilterRegistrationBean();
//            bean.setFilter(new TokenFilter());//注册自定义过滤器
//            bean.setName("Token过滤器");//过滤器名称
//            bean.addUrlPatterns("/*");//过滤所有路径
//            bean.setOrder(1);//优先级，越低越优先
//            return bean;
//        }


}
