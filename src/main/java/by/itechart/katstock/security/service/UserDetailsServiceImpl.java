package by.itechart.katstock.security.service;

import by.itechart.katstock.entity.User;
import by.itechart.katstock.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by katsiaryna.siamikina on 09.07.2015.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User with such email doesn't exist (email : " + email + ")");
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getUserPassword(), roles);

        return userDetails;
    }
}
