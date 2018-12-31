package com.example.admin.mynewproject;

import java.util.List;

public class Schedule {

    public static final String TABLE_NAME = "schedule";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SCHEDULE = "schedule";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_ROOMNAME = "room_name";
    public static final String COLUMN_APPLIENCE = "applience_name";

    private int id;
    private String schedule;
    private String timestamp;
    private String room_name;
    private String applience_name;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_SCHEDULE + " TEXT,"
                    + COLUMN_ROOMNAME + "TEXT"
                    + COLUMN_APPLIENCE + " TEXT"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + ")";

    public Schedule() {
    }
    public Schedule(int id, String schedule, String timestamp,String weekday ) {
        this.id = id;
        this.schedule = schedule;
        this.timestamp = timestamp;
    }

    Schedule(int id, List<Schedule> schedules, String name) {
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnId() {
        return COLUMN_ID;
    }

    public static String getColumnSchedule() {
        return COLUMN_SCHEDULE;
    }

    public static String getColumnTimestamp() {
        return COLUMN_TIMESTAMP;
    }

    public static String getColumnRoomname() {
        return COLUMN_ROOMNAME;
    }

    public static String getColumnApplience() {
        return COLUMN_APPLIENCE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    String getRoomName() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    String getApplienceName() {
        return applience_name;
    }

    public void setApplience_name(String applience_name) {
        this.applience_name = applience_name;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}


