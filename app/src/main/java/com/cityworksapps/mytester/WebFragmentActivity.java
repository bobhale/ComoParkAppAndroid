package com.cityworksapps.mytester;

/**
 * Created by bobinho on 3/4/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import android.util.Log;



public class WebFragmentActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_web);
       //setContentView(R.layout.activity_item_detail);
        ItemWebFragment wvf = new ItemWebFragment();

        Intent i = this.getIntent();
        //String link = i.getExtras().getString("link");

        //Log.d("SwA", "URL ["+link+"]");
        //wvf.init(link);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, wvf).commit();

    }


}
