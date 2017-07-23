package entities;

/**
 * Created by ankur on 7/7/17.
 */
//TODO: Ques11 Class should be embeddable which is to be embedded
public class Address {
    //Question 10
    Integer streetNumber;

    String location;

    String state;

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
