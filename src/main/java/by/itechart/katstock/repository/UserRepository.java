package by.itechart.katstock.repository;

import by.itechart.katstock.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by katsiaryna.siamikina on 09.07.2015.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
