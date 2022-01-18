package com.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.crud")
//public class CRUDconfig implements WebMvcConfigurer {
//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Bean
//    public ViewResolver thymeleafResolver() {
//        ThymeleafViewResolver ivr = new ThymeleafViewResolver();
//        ivr.setTemplateEngine(templateEngine());
//        ivr.setOrder(0);
//        return ivr;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
//        srtr.setApplicationContext(applicationContext);
//        srtr.setPrefix("/WEB-INF/views/");
//        srtr.setSuffix(".html");
//        return srtr;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//}
public class CRUDconfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addRedirectViewController("/", "/resources/index.html").setContextRelative(true);
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/resources/").setViewName("redirect:/resources/index.html");
    }
}

