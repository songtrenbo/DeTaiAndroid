package com.example.detaiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassActivity extends AppCompatActivity {
    Button btnXacThuc;
    EditText edtSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Quên mật khẩu");

        edtSDT=findViewById(R.id.edtFSDT);

        btnXacThuc=findViewById(R.id.btnFXacThuc);
        btnXacThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSDT.getText().toString().isEmpty()){
                    edtSDT.setError("Số điện thoại không được để trống!");
                }
                else {
                    Intent intent=new Intent(ForgetPassActivity.this,ForgetPass2Activity.class);
                    startActivity(intent);
                }
                return;

            }
        });

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.button1){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}