package com.bodaboda;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Create_User extends AsyncTask<String, String, String> {
    public static final String BASE_URL = "http://clicksinternational.com/nathan/bodaboda/bodaboda/index.php/";
    private static final String TAG_SUCCESS = "status";
    /* renamed from: c */
    public Context f1c;
    String email;
    public boolean fromPassager = false;
    JSONParser jsonParser;
    private ProgressDialog pDialog;
    public List<NameValuePair> parameters = new ArrayList();
    public boolean status = false;

    protected void onPreExecute() {
        super.onPreExecute();
        this.pDialog = new ProgressDialog(this.f1c);
        this.pDialog.setMessage("Creating User..");
        this.pDialog.setIndeterminate(false);
        this.pDialog.setCancelable(true);
        this.pDialog.show();
    }

    protected String doInBackground(String... params) {
        this.jsonParser = new JSONParser();
        JSONObject json = this.jsonParser.makeHttpRequest("http://clicksinternational.com/nathan/bodaboda/bodaboda/index.php/bodaboda/saveUserDetail", "POST", this.parameters);
        Log.d("Create Response", json.toString());
        try {
            if (json.getInt("status") == 1) {
                this.status = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (this.status && !this.fromPassager) {
            Bundle basket = new Bundle();
            Intent i = new Intent(this.f1c, Operator_Home.class);
            basket.putString("email", this.email);
            i.putExtras(basket);
            this.f1c.startActivity(i);
        } else if (this.status && this.fromPassager) {
            this.f1c.startActivity(new Intent(this.f1c, MyMaps_Activity.class));
        } else {
            Toast.makeText(this.f1c, "Could not create User..", 1).show();
        }
        this.pDialog.dismiss();
    }
}
