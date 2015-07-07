package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.role")
public class Role extends BaseEntity {

    private Long roleId;
    private String roleName;


    @Id
    @SequenceGenerator(name="role_generator", sequenceName="katstock.role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role_name", nullable = false, length = 20)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
