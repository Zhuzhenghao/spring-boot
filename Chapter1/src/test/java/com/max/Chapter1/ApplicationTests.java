package com.max.Chapter1;

import com.max.Chapter1Application;
import com.max.service.BlogProperties;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter1Application.class)
public class ApplicationTests {

  @Autowired
  private BlogProperties blogProperties;

  @Ignore
  @Test
  public void getHello() throws Exception {
    Assert.assertEquals(blogProperties.getName(), "Max");
  }
}
