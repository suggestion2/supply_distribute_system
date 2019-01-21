package com.su.supplydistributesystem.config;

import com.su.supplydistributesystem.interceptor.PageInterceptor;
import com.su.supplydistributesystem.interceptor.SessionInterceptor;
import com.su.supplydistributesystem.registrar.MyErrorPageRegistrar;
import com.sug.core.platform.web.filter.PlatformFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.concurrent.Executor;


@Configuration
@MapperScan(value = "com.su.supplydistributesystem.mapper")
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
    }

    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean () {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new PlatformFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return registrationBean;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("/mApi/**","/dApi/**")
                .excludePathPatterns("/resources/**","/test/**","/404","/500");

        registry.addInterceptor(pageInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/mApi/**","/dApi/**","resources/**","/test/**","/404","/500");
    }

    @Bean
    public SessionInterceptor sessionInterceptor(){
        return new SessionInterceptor();
    }

    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }


}
