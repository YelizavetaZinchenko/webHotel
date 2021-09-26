package com.ua.zinchenko.db.entity;

public class Room {

    private int id;
    private int amountOfSeats;
    private double price;
    private String classOfRoom;
    private String statusOfRoom;

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public String getClassOfRoom() {
        return classOfRoom;
    }

    public void setClassOfRoom(String classOfRoom) {
        this.classOfRoom = classOfRoom;
    }

    public String getStatusOfRoom() {
        return statusOfRoom;
    }

    public void setStatusOfRoom(String statusOfRoom) {
        this.statusOfRoom = statusOfRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", amountOfSeats=" + amountOfSeats +
                ", classOfRoom='" + classOfRoom + '\'' +
                ", statusOfRoom='" + statusOfRoom + '\'' +
                '}';
    }
}


