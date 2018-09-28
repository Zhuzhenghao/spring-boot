package com.max.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
  private final String name;

  public HelloController(@Value("${com.max.name}") String name) {
    this.name = name;
  }

  @RequestMapping("/hello")
  public String index() {
    return "Hello World!" + this.name;
  }
}