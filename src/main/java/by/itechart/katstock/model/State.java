package by.itechart.katstock.model;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class State extends Entity {

    private Long stateId;
    private String stateName;


    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
