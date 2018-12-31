package com.example.admin.mynewproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "schedule_db";

    private static final String TABLE_NAME = "schedule";

    private static final String SCHEDULE_ID = "schedule";

    private static final String SCHEDULE_NAME = "schedule_name";

    private static final String ROOM_NAME = "room_name";

    private static final String APPLENCE_NAME= "applience_name";


    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL("create table  " + TABLE_NAME
                + "(" + SCHEDULE_ID  + " integer primary key autoincrement, "  +SCHEDULE_NAME +" text, " +ROOM_NAME + " text, " + APPLENCE_NAME+ " text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean schedule(Schedule schedule){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHEDULE_NAME, schedule.getSchedule());
        contentValues.put(ROOM_NAME, schedule.getRoomName());
        contentValues.put(APPLENCE_NAME, schedule.getApplienceName());
        double noOfRows = db.update(TABLE_NAME,  contentValues, SCHEDULE_ID + "="+schedule.getSchedule(), null);

        return noOfRows > 0;
    }

    List<Schedule> ScheduleActivity() {
        List<Schedule> schedules = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        String query = "select * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(SCHEDULE_ID));
            String name = cursor.getString(cursor.getColumnIndex(SCHEDULE_NAME));
            String room_name = cursor.getString(cursor.getColumnIndex(ROOM_NAME));
            String applience_name = cursor.getString(cursor.getColumnIndex(APPLENCE_NAME));

            Schedule schedule = new Schedule(id, schedules,name);
            schedules.add(schedule);
        }

        return schedules;
    }

    public int updateSchedule(Schedule schedule) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Schedule.COLUMN_SCHEDULE, schedule.getSchedule());

        // updating row
        return db.update(Schedule.TABLE_NAME, values, Schedule.COLUMN_ID + " = ?",
                new String[]{String.valueOf(schedule.getId())});
    }

    public void deleteSchedule(Schedule schedule) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Schedule.TABLE_NAME, Schedule.COLUMN_ID + " = ?",
                new String[]{String.valueOf(schedule.getId())});
        db.close();
    }


}
