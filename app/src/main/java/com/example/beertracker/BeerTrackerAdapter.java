package com.example.beertracker;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class BeerTrackerAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<String> mBeerNames = new ArrayList<String>();
    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mVenues = new ArrayList<>();

    public BeerTrackerAdapter(Context context, int resource, ArrayList<String> mBeerNames, ArrayList<String> mDates,ArrayList<String> mVenues){
        super(context, resource);
        this.mContext = context;
        this.mDates = mDates;
        this.mBeerNames = mBeerNames;
        this.mVenues = mVenues;
    }

    @Override
    public int getCount() {
        return mBeerNames.size();
    }

    @Override
    public Object getItem(int position) {
        String beerName = mBeerNames.get(position);
        String date = mDates.get(position);
        String venue = mVenues.get(position);
        return String.format("%s \ntaken on %s \nat %s",beerName,date,venue);
    }
}
