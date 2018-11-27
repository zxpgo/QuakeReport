package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }
    //将使用 String 类中的 split(String string) 方法 将原始字符串在 " of " 文本处拆分 开来。结果将为两个字符串，
    // 分别包含 " of " 之前的字符和 " of " 之后的字符。由于需要频繁引用 " of " 文本， 我们可以在 EarthquakeAdapter 类
    // 的顶部定义一个 static final String 常量（全局变量）。
    private static final String LOCATION_SEPARATOR = " of ";

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false
            );
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);
        // 使用视图 ID magnitude 找到 TextView
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // 格式化震级使其显示一位小数
        String formattedMagnitude = formatMagnitude(currentEarthquake.getmMagnitude());
        // 在该 TextView 中显示目前地震的震级
        magnitudeView.setText(formattedMagnitude);

        // 为震级圆圈设置正确的背景颜色。
        // 从 TextView 获取背景，该背景是一个 GradientDrawable。
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // 根据当前的地震震级获取相应的背景颜色
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        // 设置震级圆圈的颜色
        magnitudeCircle.setColor(magnitudeColor);

        /**TextView locationView = (TextView) listItemView.findViewById(R.id.location);

        locationView.setText(currentEarthquake.getmLocation());*/
        //从 Earthquake 对象获取原始位置字符串 并将其存储在一个变量中
        String originalLocation = currentEarthquake.getmLocation();
        //同时创建新变量（主要位置和位置偏移） 来存储生成的字符串。
        String primaryLocation;
        String locationOffset;
        //在决定使用 LOCATION_SEPARATOR 拆分字符串之前，
        // 应先检查原始位置字符串 是否包含该分隔符。
        // 如果原始位置字符串中 没有 LOCATION_SEPARATOR，
        // 那么我们可以 假定我们应将 "Near the" 文本用作位置偏移， 并将原始位置字符串用作 主要位置。
        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            primaryLocation = parts[1];
            locationOffset = parts[0] + LOCATION_SEPARATOR;
        }else{
            locationOffset = getContext().getString((R.string.near_the));
            primaryLocation = originalLocation;
        }
        //获得两个单独的字符串之后，我们可以在 列表项布局的两个 TextView 中显示这两个字符串。
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);



        /**TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        dateView.setText(currentEarthquake.getmDate());*/
        // 根据地震时间（以毫秒为单位）创建一个新的 Date 对象
        Date dateObject = new Date(currentEarthquake.getmDate());

        // 找到视图 ID 为 date 的 TextView
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // 设置日期字符串的格式（即 "Mar 3, 1984"）
        String formattedDate = formatDate(dateObject);
        // 在该 TextView 中显示目前地震的日期
        dateView.setText(formattedDate);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // 设置时间字符串的格式（即 "4:30PM"）
        String formattedTime = formatTime(dateObject);
        // 在该 TextView 中显示目前地震的时间
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * 从 Date 对象返回格式化的日期字符串（即 "Mar 3, 1984"）。
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * 从 Date 对象返回格式化的时间字符串（即 "4:30 PM"）。
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }
    /**
     * 从十进制震级值返回格式化后的仅显示一位小数的震级字符串
     * （如“3.2”）。
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private  int  getMagnitudeColor(double magnitude)
    {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch(magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
                default:
                    magnitudeColorResourceId = R.color.magnitude10plus;
                    break;
    }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
