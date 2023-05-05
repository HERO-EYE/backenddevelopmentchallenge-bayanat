package sakhbouri.abdulaziz.backenddevelopmentchallenge;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Tower {
    private long tower_id;
    private String operator;
    private String address;
    private double height;
    private String tower_type;
    private double latitude;
    private double longitude;
    private String technology;

    public long getTower_id() {
        return tower_id;
    }

    public double getHeight() {
        return height;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getOperator() {
        return operator;
    }

    public String getTechnology() {
        return technology;
    }

    public String getTower_type() {
        return tower_type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public void setTower_id(long tower_id) {
        this.tower_id = tower_id;
    }

    public void setTower_type(String tower_type) {
        this.tower_type = tower_type;
    }

    @Override
    public String toString() {
        return "{'tower_id':" + this.tower_id + " ,'operator':'"+ this.operator +"','address':'"+ this.address +"','height':'"+ this.height +"','tower_type':'" + this.tower_type + "','latitude':" + this.latitude + " ,'longitude':" + this.longitude + " ,'technology':'" + this.technology + "'}";
    }
}
