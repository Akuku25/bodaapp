package com.bodaboda;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMaps_Activity extends FragmentActivity implements LocationListener {
    private static final String TAG_CORDINATES = "cordinates";
    private static final String TAG_LAT = "latitude";
    private static final String TAG_LONG = "longitude";
    private static final String TAG_MOBILE = "mobile_number";
    private static final String TAG_NAME = "fullnames";
    private static final String TAG_REG_NO = "reg_no";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_USER_ID = "user_id";
    private static String url_all_cordiantes = (Create_User.BASE_URL + "bodaboda/getCordinates");
    final LatLng carPark1 = new LatLng(-1.28333d, 36.81667d);
    ArrayList<HashMap<String, String>> cordiantesList;
    JSONArray cordinates = null;
    Criteria cri;
    public Marker current;
    GoogleMap googleMap;
    JSONParser jParser = new JSONParser();
    public double lat = 0.0d;
    Location loc;
    LocationManager locManager;
    public double longi = 0.0d;
    public Marker marker;
    public Marker marker2;
    private ProgressDialog pDialog;
    String phone = null;
    Polyline polyline = null;
    PolylineOptions polylineOptions = null;
    LatLng posi = new LatLng(-1.28333d, 36.82667d);
    String rating = "0";
    ArrayList<HashMap<String, String>> user_id_marker_id;

    class LoadAllCordinates extends AsyncTask<String, String, String> {
        LoadAllCordinates() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            MyMaps_Activity.this.pDialog = new ProgressDialog(MyMaps_Activity.this);
            MyMaps_Activity.this.pDialog.setMessage("Loading Cordinates ..Please wait...");
            MyMaps_Activity.this.pDialog.setIndeterminate(false);
            MyMaps_Activity.this.pDialog.setCancelable(false);
            MyMaps_Activity.this.pDialog.show();
        }

        protected String doInBackground(String... arg0) {
            JSONObject json = MyMaps_Activity.this.jParser.makeHttpRequest(MyMaps_Activity.url_all_cordiantes, "GET", new ArrayList());
            Log.e("All cordinates", json.toString());
            try {
                if (json.getInt(MyMaps_Activity.TAG_SUCCESS) == 1) {
                    MyMaps_Activity.this.cordinates = json.getJSONArray(MyMaps_Activity.TAG_CORDINATES);
                    Log.e("Success =1", "Tuko apa");
                    for (int i = 0; i < MyMaps_Activity.this.cordinates.length(); i++) {
                        JSONObject c = MyMaps_Activity.this.cordinates.getJSONObject(i);
                        String latitude = c.getString(MyMaps_Activity.TAG_LAT);
                        String longitude = c.getString(MyMaps_Activity.TAG_LONG);
                        if (!latitude.equals(null)) {
                            HashMap<String, String> map = new HashMap();
                            map.put(MyMaps_Activity.TAG_LAT, latitude);
                            map.put(MyMaps_Activity.TAG_LONG, longitude);
                            map.put(MyMaps_Activity.TAG_NAME, c.getString(MyMaps_Activity.TAG_NAME));
                            map.put(MyMaps_Activity.TAG_MOBILE, c.getString(MyMaps_Activity.TAG_MOBILE));
                            map.put(MyMaps_Activity.TAG_USER_ID, c.getString(MyMaps_Activity.TAG_USER_ID));
                            map.put(MyMaps_Activity.TAG_REG_NO, c.getString(MyMaps_Activity.TAG_REG_NO));
                            MyMaps_Activity.this.cordiantesList.add(map);
                        }
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
            for (int i = 0; i < MyMaps_Activity.this.cordiantesList.size(); i++) {
                try {
                    HashMap<String, String> x = new HashMap();
                    x = (HashMap) MyMaps_Activity.this.cordiantesList.get(i);
                    double longi = Double.parseDouble((String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_LONG));
                    double lat = Double.parseDouble((String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_LAT));
                    String name = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_NAME);
                    String mobile = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_MOBILE);
                    String user_id = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_USER_ID);
                    int rating = new Random().nextInt(5) + 1;
                    String reg_no = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_REG_NO);
                    LatLng pos = new LatLng(lat, longi);
                    String markerName = "Test Name";
                    HashMap<String, String> marker_userId = new HashMap();
                    markerName = MyMaps_Activity.this.getLocationName(lat, longi);
                    MyMaps_Activity.this.marker2 = MyMaps_Activity.this.googleMap.addMarker(new MarkerOptions().position(pos).title("Name:" + name).snippet("Phone Number:" + mobile + "\n \n Rating: " + rating + "\n \n Reg No :" + reg_no + "Location:" + markerName).icon(BitmapDescriptorFactory.defaultMarker(0.0f)));
                    marker_userId.put("marker", MyMaps_Activity.this.marker2.getId());
                    marker_userId.put(MyMaps_Activity.TAG_USER_ID, user_id);
                    MyMaps_Activity.this.user_id_marker_id.add(marker_userId);
                    Log.e("marker id", new StringBuilder(String.valueOf(MyMaps_Activity.this.marker2.getId())).append(user_id).toString());
                } catch (Exception e) {
                }
            }
            MyMaps_Activity.this.pDialog.dismiss();
        }
    }

    static {
        Create_User create_User = new Create_User();
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0096R.layout.activity_my_maps_);
        checkGooglePlaySercives();
        this.cordiantesList = new ArrayList();
        this.user_id_marker_id = new ArrayList();
        Log.e("started Well", "At start");
        if (this.googleMap == null) {
            this.loc = getLocation();
            if (this.loc == null) {
                Log.e("Loc is Empty", "Loc is Empty");
                this.lat = -1.28933645d;
                this.longi = 36.8244411d;
            } else {
                this.lat = this.loc.getLatitude();
                this.longi = this.loc.getLongitude();
                Log.e("Gor Location", new StringBuilder(String.valueOf(this.loc.getLongitude())).toString());
            }
            this.googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0096R.id.my_Map)).getMap();
            Log.e("started Well", "dsd" + this.lat);
        }
        this.googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0096R.id.my_Map)).getMap();
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.lat, this.longi), 10.0f));
        this.googleMap.setMapType(1);
        onLocationChanged(getLocation());
        new LoadAllCordinates().execute(new String[0]);
        this.googleMap.getUiSettings().setZoomGesturesEnabled(true);
        final Dialog dialog = new Dialog(this);
        this.googleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

            /* renamed from: com.bodaboda.MyMaps_Activity$1$1 */
            class C00881 implements OnClickListener {
                C00881() {
                }

                public void onClick(View arg0) {
                    Intent callIntent = new Intent("android.intent.action.CALL");
                    callIntent.setData(Uri.parse("tel:" + MyMaps_Activity.this.phone));
                    MyMaps_Activity.this.startActivity(callIntent);
                }
            }

            /* renamed from: com.bodaboda.MyMaps_Activity$1$2 */
            class C00892 implements OnRatingBarChangeListener {
                C00892() {
                }

                public void onRatingChanged(RatingBar arg0, float rate, boolean arg2) {
                    MyMaps_Activity.this.rating = new StringBuilder(String.valueOf(rate)).toString();
                }
            }

            public void onInfoWindowClick(Marker marker) {
                int i;
                String user_id = null;
                for (i = 0; i < MyMaps_Activity.this.user_id_marker_id.size(); i++) {
                    if (((String) ((HashMap) MyMaps_Activity.this.user_id_marker_id.get(i)).get("marker")).equals(marker.getId())) {
                        user_id = (String) ((HashMap) MyMaps_Activity.this.user_id_marker_id.get(i)).get(MyMaps_Activity.TAG_USER_ID);
                    }
                }
                String name = null;
                String regno = null;
                for (i = 0; i < MyMaps_Activity.this.cordiantesList.size(); i++) {
                    if (((String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_USER_ID)).equals(user_id)) {
                        name = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_NAME);
                        MyMaps_Activity.this.phone = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_MOBILE);
                        regno = (String) ((HashMap) MyMaps_Activity.this.cordiantesList.get(i)).get(MyMaps_Activity.TAG_REG_NO);
                    }
                }
                dialog.setContentView(C0096R.layout.rate);
                dialog.setTitle(Html.fromHtml("Bodaboda Locater::<b>Rating </b>"));
                dialog.setCancelable(true);
                TextView about = (TextView) dialog.findViewById(C0096R.id.tvRateDetails);
                Button call = (Button) dialog.findViewById(C0096R.id.btnCallBoda);
                RatingBar rateBar = (RatingBar) dialog.findViewById(C0096R.id.ratingBar1);
                Button rate = (Button) dialog.findViewById(C0096R.id.btnRateBoda);
                Button cancel = (Button) dialog.findViewById(C0096R.id.btnCancel);
                about.setText(Html.fromHtml("<b> Name:</b><i>" + name + "</i> <p></p>" + "<b> Phone Number:</b><i>" + MyMaps_Activity.this.phone + "</i> <p></p>" + "<b> Reg Number:</b><i>" + regno + "</i> <p></p>").toString());
                call.setOnClickListener(new C00881());
                rateBar.setOnRatingBarChangeListener(new C00892());
                final Dialog dialog = dialog;
                cancel.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        dialog.dismiss();
                    }
                });
                dialog = dialog;
                rate.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        dialog.dismiss();
                        Toast.makeText(MyMaps_Activity.this.getBaseContext(), "Rated Boda Boda Succesfully", 1).show();
                    }
                });
                dialog.show();
            }
        });
    }

    public String getLocationName(double latitude, double longitude) {
        try {
            List<Address> addresses = new Geocoder(getBaseContext(), Locale.getDefault()).getFromLocation(this.lat, this.longi, 1);
            if (addresses == null) {
                return "No Address returned!";
            }
            Address returnedAddress = (Address) addresses.get(0);
            StringBuilder strReturnedAddress = new StringBuilder();
            for (int j = 0; j < returnedAddress.getMaxAddressLineIndex(); j++) {
                strReturnedAddress.append(returnedAddress.getAddressLine(j)).append("\n");
            }
            return strReturnedAddress.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Canont get Address!";
        }
    }

    private void checkGooglePlaySercives() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (resultCode == 0) {
            Toast.makeText(getApplicationContext(), "isGooglePlayServicesAvailable SUCCESS", 1).show();
            return;
        }
        Toast.makeText(getBaseContext(), "No Google play services", 1).show();
        String TAG = "check";
        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
            GooglePlayServicesUtil.getErrorDialog(resultCode, this, resultCode).show();
            return;
        }
        Log.i(TAG, "This device is not supported.");
        finish();
    }

    public Location getLocation() {
        this.locManager = (LocationManager) getSystemService("location");
        this.cri = new Criteria();
        this.cri.setAccuracy(0);
        this.cri.setPowerRequirement(0);
        return this.locManager.getLastKnownLocation(this.locManager.getBestProvider(this.cri, true));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0096R.menu.my_maps_, menu);
        return true;
    }

    public void setCurrentLocation(Location loc) {
        if (loc == null) {
            Log.e("Loc is Empty", "Loc is Empty");
            this.lat = -1.28933645d;
            this.longi = 36.8244411d;
        } else {
            this.lat = loc.getLatitude();
            this.longi = loc.getLongitude();
            Log.e("Gor Location", new StringBuilder(String.valueOf(loc.getLongitude())).toString());
        }
        String markerName = "";
        markerName = getLocationName(this.lat, this.longi);
        Log.e("current Location Details", this.lat + this.longi);
        this.current = this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.lat, this.longi)).title("You").snippet(markerName).flat(false).icon(BitmapDescriptorFactory.defaultMarker(60.0f)));
    }

    public void onLocationChanged(Location loc) {
        String markerName = "";
        this.current = this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.lat, this.longi)).title("You").snippet(getLocationName(this.lat, this.longi)).flat(true).icon(BitmapDescriptorFactory.defaultMarker(60.0f)));
    }

    public void onProviderDisabled(String arg0) {
    }

    public void onProviderEnabled(String arg0) {
    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    }
}
