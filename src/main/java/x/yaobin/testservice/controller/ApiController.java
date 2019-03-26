package x.yaobin.testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import x.yaobin.testservice.pojo.Location;
import x.yaobin.testservice.pojo.Person;
import x.yaobin.testservice.pojo.User;
import x.yaobin.testservice.repostitory.PersonRepository;
import x.yaobin.testservice.repostitory.UserRepository;
import x.yaobin.testservice.service.user.UserService;

import java.util.Collection;
import java.util.LinkedHashSet;
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
    public User userAddRollBack(User user) {
        return userService.saveWithRollBack(user);
    }

    @RequestMapping("api/user-add-no-rollback")
    public User userAddNoRollBack(User user) {
        return userService.saveWithoutRollBack(user);
    }


    @Autowired
    PersonRepository personRepository;

    @RequestMapping("api/mongo-save")
    public Person mongoSave() {
        Person p = new Person("Kath", 16);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location loc1 = new Location("TJ", "2014");
        Location loc2 = new Location("北京", "2018");
        locations.add(loc1);
        locations.add(loc2);
        p.setLocations(locations);
        return personRepository.save(p);
    }

    @RequestMapping("api/mongo-q-name")
    // TODO: 2019/3/26 这个方法返回错误啊啊啊 
    public Person mongoQueryName(String name) {
        return personRepository.findByName(name);
    }


    @RequestMapping("api/mongo-q-age")
    public List<Person> mongoQueryAge(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }

}
