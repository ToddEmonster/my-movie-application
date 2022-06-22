package com.todd.mymovieapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.todd.mymovieapplication.R;
import com.todd.mymovieapplication.utils.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private TextView mTextViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");

        mTextViewWelcome = (TextView) findViewById(R.id.text_view_welcome);
        mTextViewWelcome.setText(getString(R.string.bonjour));
        Toast.makeText(this, mTextViewWelcome.getText(), Toast.LENGTH_SHORT).show();
    }

    public void onClickButton(View v) {
        Log.d(TAG, "Clic sur le bouton Rechercher");
    }

    public void onClickMovie(View v) {
        String movieLabel = "Film " + v.getTag().toString();
        Toast.makeText(this, "Clic sur le " + movieLabel, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(Util.MOVIE_LABEL, movieLabel);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}