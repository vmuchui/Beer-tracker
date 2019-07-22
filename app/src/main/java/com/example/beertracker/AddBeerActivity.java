package com.example.beertracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBeerActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.submitBeer)
    Button mAddBeers;
    @BindView(R.id.beerName)
    EditText beerName;
    @BindView(R.id.date)
    EditText date;
    @BindView(R.id.place)
    EditText venue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);
        ButterKnife.bind(this);
        mAddBeers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAddBeers){

            String beer = beerName.getText().toString();
            String whenConsumed = date.getText().toString();
            String placeConsumed = venue.getText().toString();
            Toast.makeText(this,"saving beer...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AddBeerActivity.this,BeersActivity.class);
            intent.putExtra("beerName",beer);
            intent.putExtra("date",whenConsumed);
            intent.putExtra("venue", placeConsumed);
            startActivity(intent);
        }
    }
}
