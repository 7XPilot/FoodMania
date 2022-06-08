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

public class UpdateActivity extends AppCompatActivity {

    EditText name, des  , price;
    Button update_btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = (EditText) findViewById(R.id.foodname);
        des = (EditText) findViewById(R.id.description);
        price = (EditText) findViewById(R.id.price);
        update_btn = (Button)findViewById(R.id.update_btn);
        textView = (TextView)findViewById(R.id.textview3);

        StrictMode.enableDefaults();
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String a = name.getText().toString();
                    String b = des.getText().toString();
                    String c = price.getText().toString();

                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.153:8090/Foodmania/update.php?description="+b+"&price="+c+"&name="+a);

                    HttpResponse response = httpclient.execute(httppost);
                    Toast.makeText(getApplicationContext(), "Update food Successful..", Toast.LENGTH_LONG);
                    Log.e("pass 1", "connection success");
                    textView.setText("Update food Successfully");
                } catch (Exception e) {
                    Log.e("Fail 1", e.toString());
                    Toast.makeText(getApplicationContext(), e.toString(),
                            Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(UpdateActivity.this, ListActivity.class));
            }
        });
    }
}