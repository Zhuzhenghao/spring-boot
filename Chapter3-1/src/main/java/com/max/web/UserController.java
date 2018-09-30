package com.max.web;

import java.util.*;

import com.max.domain.User;
import com.max.domain.UserMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserMapper userMapper;

  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<User> getUserList() {
    return userMapper.findAll();
  }

  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  @RequestMapping(value = "", method = RequestMethod.POST)
  public String postUser(@RequestBody User user) {
    try {
//      Map<String, Object> map = new HashMap<>();
//      map.put("name", user.getName());
//      map.put("age", user.getAge());
      userMapper.insertUser(user);
      return "success";
    } catch (Exception ignored) {
      return "failure";
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUser(@PathVariable Long id) {
    return users.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public String putUser(@PathVariable Long id, @RequestBody User user) {
    userMapper.updateUser(user.getName(), user.getAge(), id);
    return "success";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String deleteUser(@PathVariable Long id) {
    userMapper.deleteUser(id);
    return "success";
  }

}
