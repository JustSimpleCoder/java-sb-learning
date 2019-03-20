package x.yaobin.testservice.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import x.yaobin.testservice.pojo.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
