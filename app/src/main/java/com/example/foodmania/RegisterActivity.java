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

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;
    boolean passwordvisible;
    boolean repasswordvisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        signup =(Button) findViewById(R.id.btn_signup);
        signin= (Button) findViewById(R.id.btn_login);
        DB= new DBHelper(this);


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
        //Password field eye toggle , making password visible or invisible
        repassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right =2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=repassword.getRight()-repassword.getCompoundDrawables()[Right].getBounds().width()){
                        int select = repassword.getSelectionEnd();
                        if(passwordvisible){
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.invisi, 0);
                            //for hide password
                            repassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible=false;
                        }else{
                            repassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.visi, 0);
                            //for show password
                            repassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible=true;

                        }
                        repassword.setSelection(select);
                        return true;


                    }
                }
                return false;
            }
        });







        //Setting up for signup environment
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                //empty fields generate a message
                if(user.equals("")|| pass.equals("")||repass.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all parameters",Toast.LENGTH_SHORT).show();

                else {
                    //password equals re-password, DB will check the user
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        // no user is registered we can insert the data
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(RegisterActivity.this, "Username registration successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(RegisterActivity.this, "User already Exists Please Sign in.", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();

                    }

                }
            }

        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(intent);
            }
        });
    }

}