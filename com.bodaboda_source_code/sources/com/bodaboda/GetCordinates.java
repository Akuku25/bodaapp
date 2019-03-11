package com.bodaboda;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCordinates extends ListActivity {
    private static final String TAG_CORDINATES = "carpark";
    private static final String TAG_LAT = "lat";
    private static final String TAG_LONG = "long";
    private static final String TAG_SUCCESS = "success";
    private static String url_all_cordiantes = "http://emaisa.co.ke/carpark/getCordinates.php";
    ArrayList<HashMap<String, String>> cordiantesList;
    JSONArray cordinates = null;
    JSONParser jParser = new JSONParser();
    private ProgressDialog pDialog;

    class LoadAllCordinates extends AsyncTask<String, String, String> {
        LoadAllCordinates() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            GetCordinates.this.pDialog = new ProgressDialog(GetCordinates.this);
            GetCordinates.this.pDialog.setMessage("Loading Cordinates ..Please wait...");
            GetCordinates.this.pDialog.setIndeterminate(false);
            GetCordinates.this.pDialog.setCancelable(false);
            GetCordinates.this.pDialog.show();
            Toast.makeText(GetCordinates.this.getBaseContext(), "ending pre exercute", 1).show();
        }

        protected String doInBackground(String... arg0) {
            JSONObject json = GetCordinates.this.jParser.makeHttpRequest(GetCordinates.url_all_cordiantes, "GET", new ArrayList());
            Log.e("All cordinates", json.toString());
            try {
                if (json.getInt(GetCordinates.TAG_SUCCESS) == 1) {
                    GetCordinates.this.cordinates = json.getJSONArray(GetCordinates.TAG_CORDINATES);
                    Log.e("Success =1", "Tuko apa");
                    for (int i = 0; i < GetCordinates.this.cordinates.length(); i++) {
                        JSONObject c = GetCordinates.this.cordinates.getJSONObject(i);
                        String latitude = c.getString(GetCordinates.TAG_LAT);
                        String longitude = c.getString(GetCordinates.TAG_LONG);
                        HashMap<String, String> map = new HashMap();
                        map.put(GetCordinates.TAG_LAT, latitude);
                        map.put(GetCordinates.TAG_LONG, longitude);
                        GetCordinates.this.cordiantesList.add(map);
                        Log.e("For loop", new StringBuilder(String.valueOf(latitude)).append(longitude).toString());
                    }
                } else {
                    Log.e("Json Data", "Didnt receive data from mysql");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            for (int i = 0; i < GetCordinates.this.cordiantesList.size(); i++) {
                Log.e("Longi", (String) ((HashMap) GetCordinates.this.cordiantesList.get(i)).get(GetCordinates.TAG_LONG));
                Toast.makeText(GetCordinates.this.getBaseContext(), "Longi:" + ((String) ((HashMap) GetCordinates.this.cordiantesList.get(i)).get(GetCordinates.TAG_LONG)) + " \n " + "Latti:" + ((String) ((HashMap) GetCordinates.this.cordiantesList.get(i)).get(GetCordinates.TAG_LAT)), 1).show();
            }
            GetCordinates.this.pDialog.dismiss();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0096R.layout.cordiantes);
        this.cordiantesList = new ArrayList();
        new LoadAllCordinates().execute(new String[0]);
    }
}
