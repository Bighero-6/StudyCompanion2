package com.example.admin.studycompanion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        TabLayout tl = findViewById(R.id.tabs);
        ViewPager vp = findViewById(R.id.fragmentview);

        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tl.setupWithViewPager(vp);
    }
}
