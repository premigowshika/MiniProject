package com.example.example.Complaints;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplainItemClass {

    private String username;
    private String title;
    private String roomno;
    private String hostel;
    private String complaintType;
    private String description;
    private boolean isPrivate;
    private String complainTime;

    public ComplainItemClass() {
        // Default constructor required for Firebase database
    }

    public ComplainItemClass( String username, String title, String roomno, String hostel, String complaintType, String description, boolean isPrivate, String complainTime) {

        this.username = username;
        this.title = title;
        this.roomno = roomno;
        this.hostel = hostel;
        this.complaintType = complaintType;
        this.description = description;
        this.isPrivate = isPrivate;
        this.complainTime = complainTime;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String houseNo) {
        this.roomno = roomno;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getComplainTime() {
        return complainTime;
    }

    public void setComplainTime(String complainTime) {
        this.complainTime = complainTime;
    }
}
