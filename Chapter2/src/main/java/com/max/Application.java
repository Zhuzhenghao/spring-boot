package com.max;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(Application.class, args);

    Binder binder = Binder.get(context.getEnvironment());

    FooProperties foo = binder.bind("com.max", Bindable.of(FooProperties.class)).get();
    System.out.println(foo.getName());

    List<String> post = binder.bind("com.max.post", Bindable.listOf(String.class)).get();
    System.out.println(post);

    List<PostInfo> posts = binder.bind("com.max.posts", Bindable.listOf(PostInfo.class)).get();
    System.out.println(posts);

    System.out.println(context.getEnvironment());
  }
}
