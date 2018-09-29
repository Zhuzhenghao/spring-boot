package com.max.web;

import java.util.*;

import com.max.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<User> getUserList() {
    return new ArrayList<>(users.values());
  }

  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  @RequestMapping(value = "", method = RequestMethod.POST)
  public String postUser(@RequestBody User user) {
    users.put(user.getId(), user);
    return "success";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUser(@PathVariable Long id) {
    return users.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public String putUser(@PathVariable Long id, @RequestBody User user) {
    User u = users.get(id);
    u.setAge(user.getAge());
    u.setName(user.getName());
    users.put(id, u);
    return "success";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String deleteUser(@PathVariable Long id) {
    users.remove(id);
    return "success";
  }

}
