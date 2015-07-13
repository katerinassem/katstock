package by.itechart.katstock.web.service;

import by.itechart.katstock.entity.User;
import by.itechart.katstock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by katsiaryna.siamikina on 09.07.2015.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
