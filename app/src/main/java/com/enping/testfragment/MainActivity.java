package com.enping.testfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportFragmentManager().getFragments()!=null) {
            for(Fragment fragment:getSupportFragmentManager().getFragments()){
                Log.d("FG", ""+fragment);
            }
            findViewById(R.id.button).setVisibility(View.GONE);
        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(""+id)
                        .replace(R.id.activity_main,BlankFragment.newInstance(id),""+id)
                        .commit();
                v.setVisibility(View.GONE);
            }
        });
    }
}
