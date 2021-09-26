package com.ua.zinchenko.db.entity;

public class Application {

    private int id;
    private double price;
    private int amountOfSeats;
    private String classOfRoom;
    private String statusOfRoom;

    public Application() {
    }

    public Application(double price, int amountOfSeats, String classOfRoom, String statusOfRoom) {
        this.price = price;
        this.amountOfSeats = amountOfSeats;
        this.classOfRoom = classOfRoom;
        this.statusOfRoom = statusOfRoom;
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
        return "Application{" +
                "id=" + id +
                ", price=" + price +
                ", amountOfSeats=" + amountOfSeats +
                ", classOfRoom='" + classOfRoom + '\'' +
                ", statusOfRoom='" + statusOfRoom + '\'' +
                '}';
    }
}
