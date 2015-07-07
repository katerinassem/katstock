package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.measure")
public class Measure extends BaseEntity {

    private Long measureId;
    private String measureName;


    @Id
    @SequenceGenerator(name="measure_generator", sequenceName="katstock.measure_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measure_generator")
    @Column(name = "measure_id")
    public Long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Long measureId) {
        this.measureId = measureId;
    }

    @Column(name = "measure_name", nullable = false, length = 20)
    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }
}
