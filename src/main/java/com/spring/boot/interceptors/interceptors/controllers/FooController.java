package com.spring.boot.interceptors.interceptors.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class FooController {

  @RequestMapping("")
  public Map<String, Object> one() {
    return Map.of("foo", "one");
  }

  @RequestMapping("/two")
  public Map<String, Object> two() {
    return Map.of("foo", "two");
  }

  @RequestMapping("/three")
  public Map<String, Object> three() {
    return Map.of("foo", "three");
  }
}
