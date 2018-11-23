package com.example.android.quakereport;

public class Earthquake {

    //地震位置
    private String mLocation;
    //地震级数
    private String mMagnitude;
    //地震时间
    private String mDate;


    /**
     * 构造函数
     *
     * @param location
     * @param magnitude
     * @param date
     */
    public Earthquake(String location, String magnitude, String date) {
        mLocation = location;
        mMagnitude = magnitude;
        mDate = date;
    }
    //获取地址位置
    public String getmLoaction() {
        return mLocation;
    }
    //获取地震级数
    public String getmMagnitud() {
        return mMagnitude;
    }
    //获取地震时间
    public String getmDate() {
        return mDate;
    }
}
