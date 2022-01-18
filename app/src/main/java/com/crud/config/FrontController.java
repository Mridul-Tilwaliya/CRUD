package com.crud.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class FrontController implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        WebApplicationContext context = new WebApplicationContext();
        context.register(CRUDconfig.class);
        context.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(context));
        addSpringDispatcherServlet(servletContext, context);
    }

    private void addSpringDispatcherServlet(ServletContext servletContext, WebApplicationContext context)
    {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        dispatcher.setInitParameter("throwExceptionIfNoHandlerFound","true");
    }
}

//public class FrontController implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(CRUDconfig.class);
//        context.setServletContext(servletContext);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//        context.close();
//    }
//}

//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer
//{
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        Class[] configClassesForAll = {};
//        return configClassesForAll;
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{CRUDconfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings()
//    {
//        String[] urlMapping = {"/"};
//        return urlMapping;
//    }
//}
