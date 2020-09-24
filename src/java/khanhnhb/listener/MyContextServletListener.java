/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author khanhnhb
 */
public class MyContextServletListener implements ServletContextListener {
    
    private static String realPath = "";
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        realPath = sce.getServletContext().getRealPath("/");
        
        final ServletContext context = sce.getServletContext();
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
