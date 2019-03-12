package com.poc.invoicepay.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.poc.invoicepay.ui.ClosedInvoiceFragment;
import com.poc.invoicepay.ui.OpenInvoiceFragment;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OpenInvoiceFragment();

            case 1:
                return new ClosedInvoiceFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
