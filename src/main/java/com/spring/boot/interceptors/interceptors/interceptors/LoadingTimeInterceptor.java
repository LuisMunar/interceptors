package com.spring.boot.interceptors.interceptors.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
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
    HandlerMethod method = (HandlerMethod) handler;
    logger.info("LoadingTimeInterceptor: preHandle => " + method.getMethod().getName());

    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);

    Random random = new Random();
    int delay = random.nextInt(1000);
    Thread.sleep(delay);

    return true;
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView modelAndView
  ) throws Exception {
    HandlerMethod method = (HandlerMethod) handler;
    logger.info("LoadingTimeInterceptor: postHandle => " + method.getMethod().getName());

    long startTime = (long) request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long loadingTime = endTime - startTime;

    logger.info("LoadingTimeInterceptor: postHandle => " + method.getMethod().getName() + " => " + loadingTime + "ms");
  }
}
