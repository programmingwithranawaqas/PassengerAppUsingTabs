package com.example.passengerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:
                return new PlanePessengersFragment();
            case 1:
                return new BusPassengerFragment();
                case 2:
                    return new AddNewPassengerFragment();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
