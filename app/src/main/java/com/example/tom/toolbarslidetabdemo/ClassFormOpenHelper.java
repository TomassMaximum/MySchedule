package com.example.tom.toolbarslidetabdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tom on 2015/12/6.
 */
public class ClassFormOpenHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String CLASS_FORM_TABLE_NAME = "class_form";


    public ClassFormOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CLASS_FORM_TABLE_CREATE =
                "CREATE TABLE " + CLASS_FORM_TABLE_NAME + " (" +
                        //周一课程
                        ClassFormContract.MONDAY_ONE + " TEXT, " +
                        ClassFormContract.MONDAY_TWO + " TEXT, " +
                        ClassFormContract.MONDAY_THREE + " TEXT, " +
                        ClassFormContract.MONDAY_FOUR + " TEXT, " +
                        ClassFormContract.MONDAY_FIVE + " TEXT, " +
                        ClassFormContract.MONDAY_SIX + " TEXT, " +
                        //周一上课地点
                        ClassFormContract.MONDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.MONDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.MONDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.MONDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.MONDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.MONDAY_SIX_LOCATION + " TEXT, " +

                        //周二课程
                        ClassFormContract.TUESDAY_ONE + " TEXT, " +
                        ClassFormContract.TUESDAY_TWO + " TEXT, " +
                        ClassFormContract.TUESDAY_THREE + " TEXT, " +
                        ClassFormContract.TUESDAY_FOUR + " TEXT, " +
                        ClassFormContract.TUESDAY_FIVE + " TEXT, " +
                        ClassFormContract.TUESDAY_SIX + " TEXT, " +
                        //周二上课地点
                        ClassFormContract.TUESDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.TUESDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.TUESDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.TUESDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.TUESDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.TUESDAY_SIX_LOCATION + " TEXT, " +

                        //周三课程
                        ClassFormContract.WEDNESDAY_ONE + " TEXT, " +
                        ClassFormContract.WEDNESDAY_TWO + " TEXT, " +
                        ClassFormContract.WEDNESDAY_THREE + " TEXT, " +
                        ClassFormContract.WEDNESDAY_FOUR + " TEXT, " +
                        ClassFormContract.WEDNESDAY_FIVE + " TEXT, " +
                        ClassFormContract.WEDNESDAY_SIX + " TEXT, " +
                        //周三上课地点
                        ClassFormContract.WEDNESDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.WEDNESDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.WEDNESDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.WEDNESDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.WEDNESDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.WEDNESDAY_SIX_LOCATION + " TEXT, " +

                        //周四课程
                        ClassFormContract.THURSDAY_ONE + " TEXT, " +
                        ClassFormContract.THURSDAY_TWO + " TEXT, " +
                        ClassFormContract.THURSDAY_THREE + " TEXT, " +
                        ClassFormContract.THURSDAY_FOUR + " TEXT, " +
                        ClassFormContract.THURSDAY_FIVE + " TEXT, " +
                        ClassFormContract.THURSDAY_SIX + " TEXT, " +
                        //周四上课地点
                        ClassFormContract.THURSDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.THURSDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.THURSDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.THURSDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.THURSDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.THURSDAY_SIX_LOCATION + " TEXT, " +

                        //周五课程
                        ClassFormContract.FRIDAY_ONE + " TEXT, " +
                        ClassFormContract.FRIDAY_TWO + " TEXT, " +
                        ClassFormContract.FRIDAY_THREE + " TEXT, " +
                        ClassFormContract.FRIDAY_FOUR + " TEXT, " +
                        ClassFormContract.FRIDAY_FIVE + " TEXT, " +
                        ClassFormContract.FRIDAY_SIX + " TEXT, " +
                        //周五上课地点
                        ClassFormContract.FRIDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.FRIDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.FRIDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.FRIDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.FRIDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.FRIDAY_SIX_LOCATION + " TEXT, " +

                        //周六课程
                        ClassFormContract.SATURDAY_ONE + " TEXT, " +
                        ClassFormContract.SATURDAY_TWO + " TEXT, " +
                        ClassFormContract.SATURDAY_THREE + " TEXT, " +
                        ClassFormContract.SATURDAY_FOUR + " TEXT, " +
                        ClassFormContract.SATURDAY_FIVE + " TEXT, " +
                        ClassFormContract.SATURDAY_SIX + " TEXT, " +
                        //周六上课地点
                        ClassFormContract.SATURDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.SATURDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.SATURDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.SATURDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.SATURDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.SATURDAY_SIX_LOCATION + " TEXT, " +

                        //周日课程
                        ClassFormContract.SUNDAY_ONE + " TEXT, " +
                        ClassFormContract.SUNDAY_TWO + " TEXT, " +
                        ClassFormContract.SUNDAY_THREE + " TEXT, " +
                        ClassFormContract.SUNDAY_FOUR + " TEXT, " +
                        ClassFormContract.SUNDAY_FIVE + " TEXT, " +
                        ClassFormContract.SUNDAY_SIX + " TEXT, " +
                        //周日上课地点
                        ClassFormContract.SUNDAY_ONE_LOCATION + " TEXT, " +
                        ClassFormContract.SUNDAY_TWO_LOCATION + " TEXT, " +
                        ClassFormContract.SUNDAY_THREE_LOCATION + " TEXT, " +
                        ClassFormContract.SUNDAY_FOUR_LOCATION + " TEXT, " +
                        ClassFormContract.SUNDAY_FIVE_LOCATION + " TEXT, " +
                        ClassFormContract.SUNDAY_SIX_LOCATION + " TEXT);";

        db.execSQL(CLASS_FORM_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
