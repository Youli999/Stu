package com.chunyang.stu.Filter.config;
import com.chunyang.stu.Filter.chunyangFilter.ChunyangFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//*
// *
// * Filter 配置类
// * 设置优先级

//
//@Configuration
//public class FilterConfiguration {
//
//
//        @Bean
//        public FilterRegistrationBean RegistTest1(){
//            //通过FilterRegistrationBean实例设置优先级可以生效
//            //通过@WebFilter无效
//            FilterRegistrationBean bean = new FilterRegistrationBean();
//            bean.setFilter(new ChunyangFilter());//注册自定义过滤器
//            bean.setName("flilter1");//过滤器名称
//            bean.addUrlPatterns("/*");//过滤所有路径
//            bean.setOrder(1);//优先级，最顶级
//            return bean;
//        }
//     @Bean
//        public FilterRegistrationBean RegistTest2(){
//            //通过FilterRegistrationBean实例设置优先级可以生效
//            //通过@WebFilter无效
//            FilterRegistrationBean bean = new FilterRegistrationBean();
//            bean.setFilter(new Test2Filter());//注册自定义过滤器
//            bean.setName("flilter2");//过滤器名称
//            bean.addUrlPatterns("/test/*");//过滤所有路径
//            bean.setOrder(6);//优先级，越低越优先
//            return bean;
//        }
//
//
//}
