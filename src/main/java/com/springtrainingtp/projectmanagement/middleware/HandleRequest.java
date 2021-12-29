/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springtrainingtp.projectmanagement.middleware;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component
public class HandleRequest implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {        System.out.println("Request: " + sr.getServletContext().getAttribute("ess"));
        HttpServletRequest hsr = (HttpServletRequest) sr;
        String token=hsr.getHeader("Authorization").split(" ")[1];
        System.out.println("token: "+token);
    }

}
