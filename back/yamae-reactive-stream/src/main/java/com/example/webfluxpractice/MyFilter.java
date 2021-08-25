package com.example.webfluxpractice;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.servlet.*;
 import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class MyFilter implements Filter {

    private final EventNotify eventNotify;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터 실행됨");

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setContentType("text/event-stream; charset=utf-8");

        PrintWriter out = servletResponse.getWriter();
       for (int i=0 ; i<5 ; i++) {
           out.print("응답"+i+"\n");
           Thread.sleep(100);
           out.flush();
       }


    while(true){
        if(eventNotify.getChange()) {
            int lastIndex = eventNotify.getEvents().size()-1;
            out.print("응답"+eventNotify.getEvents().get(lastIndex )+"\n");
            out.flush();
            eventNotify.setChange(false);
        }
        Thread.sleep(1);
    }
}
}