package com.crud.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebApplicationContext extends AnnotationConfigWebApplicationContext
{
    public WebApplicationContext()
    {
        super();
        setConfigLocation("com.crud.config");
    }
}
