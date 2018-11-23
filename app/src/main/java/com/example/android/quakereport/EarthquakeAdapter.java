package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


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

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        magnitudeView.setText(currentEarthquake.getmMagnitud());

        TextView locationView = (TextView) listItemView.findViewById(R.id.location);

        locationView.setText(currentEarthquake.getmLoaction());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        dateView.setText(currentEarthquake.getmDate());

        return listItemView;
    }
}
