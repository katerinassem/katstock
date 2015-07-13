package by.itechart.katstock.web.service;

import by.itechart.katstock.entity.User;
import by.itechart.katstock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails getAuthorizedUserDetails() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            userDetails = (UserDetails) auth.getPrincipal();
        }

        return userDetails;
    }

    public User getAuthorizedUser() {

        UserDetails userDetails = getAuthorizedUserDetails();
        if(userDetails == null){
            return null;
        }
        return userRepository.findByEmail(userDetails.getUsername());
    }
}
