package com.bodaboda;

import android.app.ProgressDialog;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Operator_Home extends SherlockFragmentActivity implements LocationListener {
    private static final String TAG_SUCCESS = "success";
    ArrayAdapter<String> adapter;
    String email;
    JSONParser jsonParser = new JSONParser();
    Double latitude;
    LocationManager locManager;
    Double longitude;
    private ProgressDialog pDialog;
    String provider;

    class SubmitCordinates extends AsyncTask<String, String, String> {
        SubmitCordinates() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Operator_Home.this.pDialog = new ProgressDialog(Operator_Home.this);
            Operator_Home.this.pDialog.setMessage("Uploading Current Loc Cordinates..");
            Operator_Home.this.pDialog.setIndeterminate(false);
            Operator_Home.this.pDialog.setCancelable(true);
        }

        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList();
            params.add(new BasicNameValuePair("latitude", Operator_Home.this.latitude));
            params.add(new BasicNameValuePair("longitude", Operator_Home.this.longitude));
            params.add(new BasicNameValuePair("email", Operator_Home.this.email));
            Create_User create_User = new Create_User();
            JSONObject json = Operator_Home.this.jsonParser.makeHttpRequest(Create_User.BASE_URL + "bodaboda/update_details", "POST", params);
            Log.d("Create Response", json.toString());
            try {
                json.getInt(Operator_Home.TAG_SUCCESS);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }

    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) C0096R.layout.operator_home);
        this.email = getIntent().getExtras().getString("email");
        ArrayList<String> objects = new ArrayList();
        for (int i = 0; i <= 9; i++) {
            objects.add(new StringBuilder(String.valueOf(new Random().nextInt(5) + 1)).append(" -- Stars").toString());
        }
        this.adapter = new ArrayAdapter(getBaseContext(), 17367043, objects);
        ((ListView) findViewById(C0096R.id.lstRatings)).setAdapter(this.adapter);
        this.locManager = (LocationManager) getSystemService("location");
        Criteria cri = new Criteria();
        cri.setAccuracy(0);
        cri.setPowerRequirement(0);
        this.provider = this.locManager.getBestProvider(cri, true);
        Location loc = this.locManager.getLastKnownLocation(this.provider);
        if (loc == null) {
            Toast.makeText(this, "Network Failure.Check Connection", 1).show();
        } else {
            onLocationChanged(loc);
        }
    }

    public void onLocationChanged(Location loc) {
        this.latitude = Double.valueOf(loc.getLatitude());
        this.longitude = Double.valueOf(loc.getLongitude());
        new SubmitCordinates().execute(new String[0]);
    }

    public void onProviderDisabled(String arg0) {
    }

    public void onProviderEnabled(String arg0) {
    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    }
}
