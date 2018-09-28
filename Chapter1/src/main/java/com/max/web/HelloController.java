package com.max.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String index() {
    return "Hello World! Max";
  }

}