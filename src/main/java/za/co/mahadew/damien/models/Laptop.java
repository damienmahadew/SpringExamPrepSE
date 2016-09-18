package za.co.mahadew.damien.models;

import org.springframework.stereotype.Component;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public class Laptop {

    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
