package com.example.michaeljeffress.project_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by michaeljeffress on 7/10/16.
 */
public class ListCustomAdapter extends ArrayAdapter <Wine> {
    int resource;

    public ListCustomAdapter(Context context, int resource, List<Wine> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(resource,null);
        }

        ImageView thumbNail = (ImageView) view.findViewById(R.id.thumbnail_view);
        TextView name = (TextView) view.findViewById(R.id.textview_name);
        TextView region = (TextView) view.findViewById(R.id.textView_region);
        TextView type = (TextView) view.findViewById(R.id.textview_type);
        TextView price = (TextView) view.findViewById(R.id.textView_price);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        Wine wineItem = getItem(position);

        Picasso.with(getContext())
                .load(wineItem.getImage())
                .placeholder(R.drawable.wine_bottle_placeholder)
                .resize(35,100)
                .into(thumbNail);

        name.setText(wineItem.getName());
        region.setText(wineItem.getRegion());
        type.setText(wineItem.getType());
        price.setText("$" + wineItem.getPrice());
        ratingBar.setRating(wineItem.getRating());

    return view;
    }



}
