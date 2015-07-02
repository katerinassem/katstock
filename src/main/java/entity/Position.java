package entity;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class Position extends Entity {

    private Long positionId;
    private String positionName;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
