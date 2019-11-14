package com.example.myapplication.Model;

public class Washroom {
    private String maintainer;
    private String name;
    private String wheel_access;
    private String primaryind;
    private String note;
    private String summer_hours;
    private String geon_type;
    private float[] coordinates;
    private String location;
    private String address;
    private String winter_hours;
    private String type;
    private String geo_local_area;

    public Washroom(String maintainer, String name, String wheel_access, String primaryind, String note, String summer_hours, String geon_type, float[] coordinates, String location, String address, String winter_hours, String type, String geo_local_area) {
        this.maintainer = maintainer;
        this.name = name;
        this.wheel_access = wheel_access;
        this.primaryind = primaryind;
        this.note = note;
        this.summer_hours = summer_hours;
        this.geon_type = geon_type;
        this.coordinates = coordinates;
        this.location = location;
        this.address = address;
        this.winter_hours = winter_hours;
        this.type = type;
        this.geo_local_area = geo_local_area;
    }

    public Washroom() {

    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWheel_access() {
        return wheel_access;
    }

    public void setWheel_access(String wheel_access) {
        this.wheel_access = wheel_access;
    }

    public String getPrimaryind() {
        return primaryind;
    }

    public void setPrimaryind(String primaryind) {
        this.primaryind = primaryind;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSummer_hours() {
        return summer_hours;
    }

    public void setSummer_hours(String summer_hours) {
        this.summer_hours = summer_hours;
    }

    public String getGeon_type() {
        return geon_type;
    }

    public void setGeon_type(String geon_type) {
        this.geon_type = geon_type;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWinter_hours() {
        return winter_hours;
    }

    public void setWinter_hours(String winter_hours) {
        this.winter_hours = winter_hours;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeo_local_area() {
        return geo_local_area;
    }

    public void setGeo_local_area(String geo_local_area) {
        this.geo_local_area = geo_local_area;
    }
}
