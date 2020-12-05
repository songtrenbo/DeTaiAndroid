package com.example.detaiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;
    MenuItem menuItem;
    ActionBar actionBar;
    RadioGroup radioCode,radioPrice,radioLabel;
    String codeName,Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị số điện thoại trên action bar
        actionBar = getSupportActionBar();
        actionBar.setTitle("   0123456789"); //Thiết lập tiêu đề nếu muốn
        //String title = actionBar.getTitle().toString(); //Lấy tiêu đề nếu muốn

        //Hiển thị icon account trên action bar
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.ic_baseline_account_circle_24);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);

        //Cho background actionbar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));

        //Load fragment mua voucher
        navView = findViewById(R.id.nav_view);
        loadFragment(new BuyVoucherFragment());
        navView.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.nav_buy_voucher);

    }
private BottomNavigationView.OnNavigationItemSelectedListener
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.nav_buy_voucher:
                    fragment = new BuyVoucherFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_history:
                    fragment = new HistoryFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
    }
};
    private void loadFragment(Fragment fragment) {
// load fragment
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onCodeSelected(View view) {
        radioCode = findViewById(R.id.radio_code);
        switch (radioCode.getCheckedRadioButtonId()){
            case R.id.btn_QR:
                codeName = "QR code";
                break;
            case R.id.btn_Bar:
                codeName = "Bar code";
                break;
        }
    }

    public void onPriceSelected(View view) {
        radioPrice = findViewById(R.id.radio_price);
        switch (radioPrice.getCheckedRadioButtonId()){
            case R.id.btn_10k:
                Price = "10.000đ";
                break;
            case R.id.btn_20k:
                Price = "20.000đ";
                break;
            case R.id.btn_50k:
                Price = "50.000đ";
                break;
            case R.id.btn_100k:
                Price = "100.000đ";
                break;
            case R.id.btn_200k:
                Price = "200.000đ";
                break;
            case R.id.btn_500k:
                Price = "500.000đ";
                break;
        }
    }

    public void onLabelSelected(View view) {
        radioLabel = findViewById(R.id.radio_label);
        switch (radioLabel.getCheckedRadioButtonId()){
            case R.id.btn_gongcha:
                break;
            case R.id.btn_goviet:
                break;
            case R.id.btn_grab:
                break;
            case R.id.btn_highlands:
                break;
            case R.id.btn_phuclong:
                break;
            case R.id.btn_sumo:
                break;
        }
    }
}