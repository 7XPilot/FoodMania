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

public class DeleteActivity extends AppCompatActivity {

    EditText txt_food;
    Button del_btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        txt_food = (EditText)findViewById(R.id.txt_food);
        del_btn = (Button)findViewById(R.id.del_btn);
        textView = (TextView)findViewById(R.id.textview1);
        StrictMode.enableDefaults();

        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try{
                    String m=txt_food.getText().toString();

                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.153:8090/Foodmania/delete.php?name="+m);

                    HttpResponse response = httpclient.execute(httppost);
                    Toast.makeText(getApplicationContext(),"Deleted Course Successful..", Toast.LENGTH_LONG);
                    Log.e("pass 1", "connection success");
                    textView.setText("Deleted Food Successfully");
                } catch (Exception e) {
                    Log.e("Fail 1", e.toString());
                    Toast.makeText(getApplicationContext(), e.toString(),
                            Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(DeleteActivity.this, ListActivity.class));
            }
        });
    }
}