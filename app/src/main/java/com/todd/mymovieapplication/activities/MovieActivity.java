package com.todd.mymovieapplication.activities;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.todd.mymovieapplication.R;
import com.todd.mymovieapplication.databinding.ActivityMovieBinding;
import com.todd.mymovieapplication.utils.Util;

public class MovieActivity extends AppCompatActivity {

    private static final String TAG = "MovieActivity";
    private ActivityMovieBinding binding;
    private TextView mTextViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate()");

        mTextViewContent = findViewById(R.id.movie_content);

        // Get data from parent
        // TODO if extras doesn't exist
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String movieLabel = extras.getString(Util.MOVIE_LABEL);
            mTextViewContent.setText(movieLabel);
        }

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}