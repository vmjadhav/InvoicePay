package com.poc.invoicepay.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.poc.invoicepay.R;
import com.poc.invoicepay.adapters.CustomPagerAdapter;

public class ManageInvoiceActivity extends AppCompatActivity {

    private TabLayout mTabLayout = null;
    private ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_invoice);
        initComponents();
        initListeners();
        initTabLayout();
        initViewPager();
    }

    private void initListeners() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initComponents() {
        mTabLayout = findViewById(R.id.tl_invoice);
        mViewPager = findViewById(R.id.vp_invoice);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setText("Open"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Closed"));
        mTabLayout.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    private void initViewPager() {
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
    }
}
