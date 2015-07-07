package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.state")
public class State extends BaseEntity {

    private Long stateId;
    private String stateName;


    @Id
    @SequenceGenerator(name="state_generator", sequenceName="katstock.state_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_generator")
    @Column(name = "state_id")
    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    @Column(name = "state_name", nullable = false, length = 20)
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
