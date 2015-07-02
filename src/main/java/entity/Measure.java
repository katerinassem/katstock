package entity;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class Measure extends Entity {

    private Long measureId;
    private String measureName;


    public Long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Long measureId) {
        this.measureId = measureId;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }
}
