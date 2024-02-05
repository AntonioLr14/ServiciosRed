package com.example.serviciosred;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiPageAdapter extends FragmentStateAdapter {
    public MiPageAdapter(MainActivity activity) {
        super(activity);
    }
    @NonNull
    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Ventana1();
            case 1:
                return new Ventana2();
            case 2:
                return new Ventana3();
        }
        return null;
    }
}
