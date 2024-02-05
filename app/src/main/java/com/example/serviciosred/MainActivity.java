package com.example.serviciosred;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view pager2 nuevo
        ViewPager2 viewPager2=findViewById(R.id.view_pager);
        viewPager2.setAdapter(new MiPageAdapter(this));
        viewPager2.setUserInputEnabled(false);
        //tabs
        TabLayout tabs=findViewById(R.id.tabs);
        //tablayoutMediator sirve para asignar los tabs al viewpager e indicamos los nombres
        new TabLayoutMediator(tabs,viewPager2,new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("VISTA");
                        break;
                    case 1:
                        tab.setText("MARCADOR");
                        break;
                    case 2:
                        tab.setText("COORD");
                        break;
                }
            }
        }).attach();

    }
}