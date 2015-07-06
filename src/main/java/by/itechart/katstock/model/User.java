package by.itechart.katstock.model;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class User extends Entity {

    private Long userId;
    private String userName;
    private String surname;
    private String email;
    private String userPassword;

    private Role role;
    private StockOrganization stockOrganization;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StockOrganization getStockOrganization() {
        return stockOrganization;
    }

    public void setStockOrganization(StockOrganization stockOrganization) {
        this.stockOrganization = stockOrganization;
    }
}
