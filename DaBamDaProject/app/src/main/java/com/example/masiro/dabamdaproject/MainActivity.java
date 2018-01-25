package com.example.masiro.dabamdaproject;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position){
            switch (position){
                case 0:
                    return new MainPageActivity();
                case 1:
                    return new SelectActivity();
                default:
                    return null;
            }
        }
        @Override
        public int getCount(){
            return 2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.MainActivityViewPager);
        vp.setAdapter(new MainActivity.ViewPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
    }
}
