package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListActivity extends AppCompatActivity {
    ListView listview1,listView2,listview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        listview3 = (ListView) findViewById(R.id.listView3);

        listview1.setDivider(null);
        listview1.setDividerHeight(0);

        listView2.setDivider(null);
        listView2.setDividerHeight(0);

        listview3.setDivider(null);
        listview3.setDividerHeight(0);

        //put your local ip address and port number. please refer the instruction.doc file.
        getJSON("http://192.168.1.153:8090/FoodMania/menu.php");
    }


    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView1(s);
                    loadIntoListView2(s);
                    loadIntoListView3(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


    private void loadIntoListView1(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] course = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            course[i] = obj.getString("name");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        listview1.setAdapter(arrayAdapter);
    }

    private void loadIntoListView2(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] course = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            course[i] = obj.getString("description");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        listView2.setAdapter(arrayAdapter);
    }
    private void loadIntoListView3(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] course = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            course[i] = obj.getString("price");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        listview3.setAdapter(arrayAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
//respond to menu item selection
        switch (item.getItemId()) {
            case R.id.add:
                startActivity(new Intent(this, AddActivity.class));
                return true;
            case R.id.back:
                startActivity(new Intent(this, SignInActivity.class));
                return true;
            case R.id.delete:
                startActivity(new Intent(this, DeleteActivity.class));
                return true;
            case R.id.update:
                startActivity(new Intent(this, UpdateActivity.class));
                return true;
            case R.id.search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
