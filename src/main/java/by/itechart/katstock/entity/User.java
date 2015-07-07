package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.user")
public class User extends BaseEntity {

    private Long userId;
    private String userName;
    private String surname;
    private String email;
    private String userPassword;

    private Role role;
    private StockOrganization stockOrganization;


    @Id
    @SequenceGenerator(name="user_generator", sequenceName="katstock.user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "user_name", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "surname", nullable = false, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "email", length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_password", nullable = false, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "stock_organization_id", nullable = false)
    public StockOrganization getStockOrganization() {
        return stockOrganization;
    }

    public void setStockOrganization(StockOrganization stockOrganization) {
        this.stockOrganization = stockOrganization;
    }
}
