package com.ua.zinchenko.db.entity;

public class ConfirmationForAdmin {

    private int id_confirmationForAdmin;
    private int user_admin_id;
    private int room_admin_id;

    public ConfirmationForAdmin() {
    }

    public ConfirmationForAdmin(int id_confirmationForAdmin, int user_admin_id, int room_admin_id) {
        this.id_confirmationForAdmin = id_confirmationForAdmin;
        this.user_admin_id = user_admin_id;
        this.room_admin_id = room_admin_id;
    }

    public int getId_confirmationForAdmin() {
        return id_confirmationForAdmin;
    }

    public void setId_confirmationForAdmin(int id_confirmationForAdmin) {
        this.id_confirmationForAdmin = id_confirmationForAdmin;
    }

    public int getUser_admin_id() {
        return user_admin_id;
    }

    public void setUser_admin_id(int user_admin_id) {
        this.user_admin_id = user_admin_id;
    }

    public int getRoom_admin_id() {
        return room_admin_id;
    }

    public void setRoom_admin_id(int room_admin_id) {
        this.room_admin_id = room_admin_id;
    }

    @Override
    public String toString() {
        return "ConfirmationForAdmin{" +
                "id_confirmationForAdmin=" + id_confirmationForAdmin +
                ", user_admin_id=" + user_admin_id +
                ", room_admin_id=" + room_admin_id +
                '}';
    }
}
