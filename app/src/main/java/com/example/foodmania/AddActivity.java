package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class AddActivity extends AppCompatActivity {

    EditText name, description, price;
    Button add_btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText) findViewById(R.id.txt_food);
        description = (EditText) findViewById(R.id.description);
        price = (EditText) findViewById(R.id.price);
        add_btn = (Button)findViewById(R.id.add_btn);
        textView = (TextView)findViewById(R.id.textview2);

        StrictMode.enableDefaults();
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String a = name.getText().toString();
                    String b = description.getText().toString();
                    String c = price.getText().toString();

                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.153:8090/Foodmania/add.php?description="+b+"&price="+c+"&name="+a);

                    HttpResponse response = httpclient.execute(httppost);
                    Toast.makeText(getApplicationContext(), "Add food Successful..", Toast.LENGTH_LONG);
                    Log.e("pass 1", "connection success");
                    textView.setText("ADD food Successfully");
                } catch (Exception e) {
                    Log.e("Fail 1", e.toString());
                    Toast.makeText(getApplicationContext(), e.toString(),
                            Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(AddActivity.this, ListActivity.class));
            }
        });
    }

}