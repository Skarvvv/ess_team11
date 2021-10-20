package com.team11.filter;

import com.team11.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TimeOutFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = request.getServletPath();

        if (path.endsWith("index.jsp") || path.endsWith("login")){
            chain.doFilter(request,response);
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            chain.doFilter(request,response);
            return;
        }

        //拦截转发
        request.getRequestDispatcher("error.jsp").forward(request,response);


    }
}
