package com.example.dormsadmin;

public class Rooms_data {
    String name,rent,beds,roomId;
    public Rooms_data(String name, String rent, String beds) {
        this.name = name;
        this.rent = rent;
        this.beds = beds;
    }
    public Rooms_data() {

    }

    public String getName() {
        return name;
    }

    public String getRent() {
        return rent;
    }

    public String getBeds() {
        return beds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
