package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.position")
public class Position extends BaseEntity {

    private Long positionId;
    private String positionName;


    @Id
    @SequenceGenerator(name="position_generator", sequenceName="katstock.position_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_generator")
    @Column(name = "position_id")
    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    @Column(name = "position_name", nullable = false, length = 20)
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
