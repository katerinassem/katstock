package by.itechart.katstock.configuration;

import by.itechart.katstock.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katsiaryna.siamikina on 06.07.2015.
 */
@Configuration
@ComponentScan(basePackages = {"by.itechart.katstock.web.controller", "by/itechart/katstock/web/service"})
@Import({JpaConfiguration.class, SecurityConfiguration.class})
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final String VIEW_PREFIX = "/WEB-INF/index/view/";
    private final String VIEW_SUFFIX = ".html";

    private final String RESOURCE_LOCATIONS = "/resources/";
    private final String RESOURCE_HANDLER = RESOURCE_LOCATIONS + "**";

    @Bean
    public InternalResourceViewResolver setupViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(VIEW_PREFIX);
        viewResolver.setSuffix(VIEW_SUFFIX);
        viewResolver.setCache(false);
        return viewResolver;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {

        RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
        handlerMapping.setUseSuffixPatternMatch(false);
        handlerMapping.setUseTrailingSlashMatch(false);
        return handlerMapping;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){

        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<HttpMessageConverter<?>>();
        httpMessageConverterList.add(mappingJackson2HttpMessageConverter);
        requestMappingHandlerAdapter.setMessageConverters(httpMessageConverterList);
        requestMappingHandlerAdapter.setSupportedMethods("GET", "POST", "PUT", "DELETE");

        return requestMappingHandlerAdapter;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATIONS);
    }

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ContextLoaderListener contextLoaderListener() {

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener();

        return contextLoaderListener;
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return new UserDetailsServiceImpl();
    }
}
