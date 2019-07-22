package com.example.beertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeersActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = BeersActivity.class.getSimpleName();

    private ArrayList<String> mBeerNames = new ArrayList<>();
    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mVenues = new ArrayList<>();

    @BindView(R.id.BeersTextView)
    TextView mBeersTextView;
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.homeButton)
    Button mHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);
        mBeerNames.add("Tusker");
        mDates.add("07/08/2019");
        mVenues.add("space");
        Intent intent = getIntent();

        String beer = intent.getStringExtra("beerName");
        mBeerNames.add(beer);
        String where = intent.getStringExtra("venue");
        String when = intent.getStringExtra("date");
        mDates.add(when);
        mVenues.add(where);
        BeerTrackerAdapter beerTrackerAdapter = new BeerTrackerAdapter(this,android.R.layout.simple_list_item_1,mBeerNames,mDates,mVenues);
        mListView.setAdapter(beerTrackerAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BeersActivity.this,"You drank " + beer,Toast.LENGTH_LONG).show();
            }
        });
        mHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==mHome) {
            Intent intent = new Intent(BeersActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
