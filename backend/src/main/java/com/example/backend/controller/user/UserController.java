package com.example.backend.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    /**
     * @RequestMapping   @GetMapping  @PostMapping
     */
    @Autowired
    UserMapper userMapper;


    @GetMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userId}/")
    public User getuser(@PathVariable int userId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return  userMapper.selectOne(queryWrapper);
    }

/**    public List<User> getUser(@PathVariable int userId){     //返回值是User,还是List<User> 看看抛出什么
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.eq("id",userId);        //eq :equals,还有ge
       queryWrapper.ge("id",1).le("id",2);  //id大于2小于3
       return userMapper.selectList(queryWrapper);
        }
 */

    /**
     * 插入一般用Post请求,这里为了方便,用Get演示
     * 同样的,删除也是用Post的
     */
    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(
        @PathVariable int userId,
        @PathVariable String username,
        @PathVariable String password){
        //注册的时候就是加密后的密码了
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);

        User user = new User(userId, username, encodePassword);
        userMapper.insert(user);
        return "Add User Successfully";

    }

    @GetMapping("/user/delete/{userId}/")
    public String deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "delete User successfully";
    }
}

