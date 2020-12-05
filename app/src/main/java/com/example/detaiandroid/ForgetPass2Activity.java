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

public class ForgetPass2Activity extends AppCompatActivity {
    EditText edtPassword,edtConfirmPasword;
    Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Quên mật khẩu");

        edtPassword=findViewById(R.id.edtFPassword);
        edtConfirmPasword=findViewById(R.id.edtFXNPassword);
        btnXacNhan=findViewById(R.id.btnFXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPassword.getText().toString().isEmpty()){
                    edtPassword.setError("Mật khẩu không được để trống! ");
                    return;
                }
                if(edtConfirmPasword.getText().toString().isEmpty()){
                    edtConfirmPasword.setError("Nhập lại mật khẩu không được để trống!");
                    return;
                }
                if(edtPassword.getText().toString().equals(edtConfirmPasword.getText().toString()))
                {
                    Intent intent=new Intent(ForgetPass2Activity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    edtPassword.setError("Mật khẩu và mật khẩu nhập lại không trùng khớp!");
                    edtConfirmPasword.setText("");
                    return;
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        }
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