package com.example.android.quakereport;

public class Earthquake {

    //地震位置
    private String mLocation;
    //地震级数
    private double mMagnitude;
    //地震时间
    private Long mDate;
    //地震的网站url
    private String mUrl;

    /**
     * 构造函数
     *
     * @param location
     * @param magnitude
     * @param date
     */
    public Earthquake(String location, double magnitude, Long date, String url) {
        mLocation = location;
        mMagnitude = magnitude;
        mDate = date;
        mUrl = url;
    }

    //获取地址位置
    public String getmLocation() {
        return mLocation;
    }

    //获取地震级数
    public double getmMagnitude() {
        return mMagnitude;
    }

    //获取地震时间
    public Long getmDate() {
        return mDate;
    }

    //获取地震url
    public String getmUrl() {
        return mUrl;
    }
}

