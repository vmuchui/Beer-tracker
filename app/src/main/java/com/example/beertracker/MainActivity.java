package com.example.beertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.addBeers)
    Button mAddBeers;
    @BindView(R.id.findBreweries)
    Button mFindBreweries;
    @BindView(R.id.mainTextView)
    TextView mMainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindBreweries.setOnClickListener(this);
        mAddBeers.setOnClickListener(this);
        Typeface ostrichBold = Typeface.createFromAsset(getAssets(),"fonts/OstrichSans-Bold.otf");
        mMainTextView.setTypeface(ostrichBold);

    }
    @Override
    public void onClick(View view) {
        if (view==mAddBeers) {
            Toast.makeText(MainActivity.this,"Add beers you've consumed...",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,AddBeerActivity.class);
            startActivity(intent);
        }if (view==mFindBreweries){
            Toast.makeText(MainActivity.this,"Find Breweries near you...",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,FindBreweriesActivity.class);
            startActivity(intent);
        }

    }

}
