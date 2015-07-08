package by.itechart.katstock.web.controller.model;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
public class AuthenticationBundle implements Serializable {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
