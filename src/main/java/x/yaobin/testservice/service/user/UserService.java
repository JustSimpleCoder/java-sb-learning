package x.yaobin.testservice.service.user;


import x.yaobin.testservice.pojo.User;

public interface UserService {

    public User saveWithRollBack(User user);
    public User saveWithoutRollBack(User user);
}
