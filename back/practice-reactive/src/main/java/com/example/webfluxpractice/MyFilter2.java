package com.example.webfluxpractice;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class MyFilter2 implements Filter {

    private final EventNotify eventNotify;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터2 실행됨");
        eventNotify.add("새로운 데이터");
    }

}