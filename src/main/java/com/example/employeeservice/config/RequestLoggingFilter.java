package com.example.employeeservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        log.info("Incoming request -> Method: {}, URI: {}",
                httpRequest.getMethod(),
                httpRequest.getRequestURI());

        Collections.list(httpRequest.getHeaderNames())
                .forEach(headerName ->
                        log.info("Header -> {}: {}",
                                headerName,
                                httpRequest.getHeader(headerName)));

        chain.doFilter(request, response);
    }
}