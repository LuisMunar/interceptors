package com.spring.boot.interceptors.interceptors.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoadingTimeInterceptor implements HandlerInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

  @Override
  public boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler
  ) throws Exception {
    logger.info("LoadingTimeInterceptor: preHandle");
    return true;
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView modelAndView
  ) throws Exception {
    logger.info("LoadingTimeInterceptor: postHandle");
  }
}
