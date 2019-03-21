package x.yaobin.testservice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import x.yaobin.testservice.pojo.User;
import x.yaobin.testservice.repostitory.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public User saveWithRollBack(User user) {
        User u = userRepository.save(user);
        if (user.getName().equals("yb")) {
            throw new IllegalArgumentException("yb is here  Roll back");
        }

        return u;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public User saveWithoutRollBack(User user) {
        User u = userRepository.save(user);
        if (user.getName().equals("yb")) {
            throw new IllegalArgumentException("yb is here  no  Roll back");
        }

        return u;
    }
}
