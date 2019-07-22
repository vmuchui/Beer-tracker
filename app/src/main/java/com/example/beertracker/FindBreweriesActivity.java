package com.example.beertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindBreweriesActivity extends AppCompatActivity {

    @BindView(R.id.messageText)
    TextView mTextmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_breweries);
        ButterKnife.bind(this);

        Typeface niconne = Typeface.createFromAsset(getAssets(),"fonts/Niconne-Regular.ttf");
        mTextmessage.setTypeface(niconne);

    }
}
