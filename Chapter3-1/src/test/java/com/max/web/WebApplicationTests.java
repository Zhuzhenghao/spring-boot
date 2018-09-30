package com.max.web;

import org.junit.Assert;

import com.max.WebApplication;
import com.max.domain.User;
import com.max.domain.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  @Rollback
  public void findByName() throws Exception {
    User user = new User();
    user.setName("AAA1");
    user.setAge(21);
    userMapper.insertUser(user);
    User u = userMapper.findByName("AAA1");
    Assert.assertEquals(20, u.getAge().intValue());
  }

}
