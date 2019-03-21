package x.yaobin.testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import x.yaobin.testservice.pojo.User;
import x.yaobin.testservice.repostitory.UserRepository;
import x.yaobin.testservice.service.user.UserService;

import java.util.List;

@RestController
public class ApiController {

    @Value("${developer.name}")
    private String developerName;
    private List<User> listUser;

    @RequestMapping("/")
    String index() {
        return "Hello spring boot developer :" + developerName;
    }


    @RequestMapping("api/t1-add")
    public String t1Add() {
        return "adddddd";
    }

    @RequestMapping("api/t1-list")
    public String[] t1List() {
        String[] a = {"a", "c"};
        return a;
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("api/user-add")
    public User userAdd(String name) {

        User u1 = userRepository.save(new User(null, name));
        return u1;
    }

    @RequestMapping("api/user-list")
    public List<User> userList() {
        List<User> listUser = userRepository.findAll();
        return listUser;
    }


    @Autowired
    UserService userService;

    @RequestMapping("api/user-add-rollback")
    public User userAddRollBack(User user){
        return userService.saveWithRollBack(user);
    }

    @RequestMapping("api/user-add-no-rollback")
    public User userAddNoRollBack(User user){
        return userService.saveWithoutRollBack(user);
    }

}
