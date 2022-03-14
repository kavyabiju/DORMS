package com.example.dormsadmin;

public class User {

    String roomId;
    String name;
    String beds;
    long rent;

    public User(){}

    public User(String roomId, String name, String beds, long rent) {
        this.roomId = roomId;
        this.name = name;
        this.beds = beds;
        this.rent = rent;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getBeds() {
        return beds;
    }

    public long getRent() {
        return rent;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public void setRent(long rent) {
        this.rent = rent;
    }
}
