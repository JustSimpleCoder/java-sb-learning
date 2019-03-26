package x.yaobin.testservice.repostitory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import x.yaobin.testservice.pojo.Person;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByName(String name);

    @Query("{'age':?0}")
    List<Person> withQueryFindByAge(Integer age);
}