package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmania.ui.home.HomeFragment;

public class SignInActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin , btnsignup, btnadmin;
    DBHelper DB;
    boolean passwordvisible;
    boolean repasswordvisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username= (EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        btnlogin=(Button) findViewById(R.id.btn_login);
        btnsignup = (Button) findViewById(R.id.btn_signup);
        btnadmin = findViewById(R.id.btn_admin);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")|| pass.equals(""))
                    Toast.makeText(SignInActivity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass =DB.checkusernamepassword(user, pass);

                    //ogin successful if user matches password
                    if (checkuserpass== true){
                        Toast.makeText(SignInActivity.this, "signin Successful", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    } //if username and password dont match
                    else {
                        Toast.makeText(SignInActivity.this, "Invalid Credentials,", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        //Password field eye toggle , making password visible or invisible
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right =2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int select = password.getSelectionEnd();
                        if(passwordvisible){
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.invisi, 0);
                            //for hide pssword
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible=false;
                        }else{
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.visi, 0);
                            //for show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible=true;

                        }
                        password.setSelection(select);
                        return true;


                    }
                }
                return false;
            }
        });

        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(SignInActivity.this, AdminActivity.class);
            startActivity(i);
            }
        });





        }
    }
