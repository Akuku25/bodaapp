package com.bodaboda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Passager_Login_Fragment extends SherlockFragment implements OnClickListener {
    public static String PASSAGER_LOGIN_EMAIL = "operator_login_email";
    public static String PASSAGER_LOGIN_PASSWORD = "operator_login_password";
    public String Email;
    boolean checked;
    EditText email;
    Button login;
    public String parsedEmail;
    public String parsedPassword;
    public String pass;
    EditText password;
    SharedPreferences prefs;
    CheckBox rememberMe;

    /* renamed from: com.bodaboda.Passager_Login_Fragment$1 */
    class C00941 implements OnCheckedChangeListener {
        C00941() {
        }

        public void onCheckedChanged(CompoundButton arg0, boolean check) {
            Passager_Login_Fragment.this.checked = check;
        }
    }

    public class LoadUserDetails extends AsyncTask<String, String, String> {
        private static final String TAG_EMAIL = "email";
        private static final String TAG_PASSWORD = "password";
        private static final String TAG_SUCCESS = "success";
        private static final String TAG_USER_DETAILS = "user_record";
        JSONParser jsonParser;
        boolean login = false;
        private ProgressDialog pDialog;
        private String url_user_record = (Create_User.BASE_URL + "bodaboda/getUserRecord");
        JSONObject user;

        public LoadUserDetails() {
            Create_User create_User = new Create_User();
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.pDialog = new ProgressDialog(Passager_Login_Fragment.this.getActivity());
            this.pDialog.setMessage("Validating Detetails......");
            this.pDialog.setIndeterminate(false);
            this.pDialog.setCancelable(true);
            this.pDialog.show();
        }

        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList();
            params.add(new BasicNameValuePair(TAG_EMAIL, Passager_Login_Fragment.this.Email));
            params.add(new BasicNameValuePair(TAG_PASSWORD, Passager_Login_Fragment.this.pass));
            params.add(new BasicNameValuePair("user_type", "2"));
            this.jsonParser = new JSONParser();
            JSONObject json = this.jsonParser.makeHttpRequest(this.url_user_record, "GET", params);
            Log.e("User Record", json.toString());
            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.e("Success before", "Tuko apa");
                    this.user = json.getJSONObject(TAG_USER_DETAILS);
                    Passager_Login_Fragment.this.parsedEmail = this.user.getString(TAG_EMAIL);
                    Passager_Login_Fragment.this.parsedPassword = this.user.getString(TAG_PASSWORD);
                    this.login = true;
                } else if (success == 0) {
                    Log.e("Json Data", "Didnt receive data from mysql");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (this.login) {
                Editor edit;
                if (Passager_Login_Fragment.this.checked) {
                    edit = Passager_Login_Fragment.this.prefs.edit();
                    edit.putString(Passager_Login_Fragment.PASSAGER_LOGIN_EMAIL, Passager_Login_Fragment.this.parsedEmail);
                    edit.putString(Passager_Login_Fragment.PASSAGER_LOGIN_PASSWORD, Passager_Login_Fragment.this.parsedPassword);
                    edit.commit();
                } else {
                    edit = Passager_Login_Fragment.this.prefs.edit();
                    edit.putString(Passager_Login_Fragment.PASSAGER_LOGIN_EMAIL, "");
                    edit.putString(Passager_Login_Fragment.PASSAGER_LOGIN_PASSWORD, "");
                    edit.commit();
                }
                Passager_Login_Fragment.this.startActivity(new Intent(Passager_Login_Fragment.this.getActivity(), MyMaps_Activity.class));
            } else {
                Passager_Login_Fragment.this.email.setError("Invalid User Detils.....");
                Passager_Login_Fragment.this.password.setError("Invlaid User Details.....");
                Toast.makeText(Passager_Login_Fragment.this.getActivity(), "Incorrect Login Details ..Please Try Again", 1).show();
            }
            this.pDialog.dismiss();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0096R.layout.login, container, false);
        initializeViews(view);
        getActivity();
        this.prefs = getActivity().getSharedPreferences("My Prefs", 0);
        this.email.setText(this.prefs.getString(PASSAGER_LOGIN_EMAIL, ""));
        this.password.setText(this.prefs.getString(PASSAGER_LOGIN_PASSWORD, ""));
        this.login.setOnClickListener(this);
        this.rememberMe.setOnCheckedChangeListener(new C00941());
        return view;
    }

    private void initializeViews(View v) {
        this.email = (EditText) v.findViewById(C0096R.id.etEmail_operator_login);
        this.password = (EditText) v.findViewById(C0096R.id.etPassword_operator_login);
        this.rememberMe = (CheckBox) v.findViewById(C0096R.id.chkRemberMe_operator_login);
        this.login = (Button) v.findViewById(C0096R.id.btnLogin_operator_login);
    }

    public boolean checkNetworkState() {
        NetworkInfo NInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
        if (NInfo == null || !NInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {
        if (Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(email).matches()) {
            return true;
        }
        return false;
    }

    private boolean validateViews() {
        this.Email = this.email.getText().toString();
        this.pass = this.password.getText().toString();
        if (this.Email.equals("")) {
            this.email.setError("Email Empty!");
            return false;
        } else if (!validateEmail(this.email.getText().toString())) {
            this.email.setError("Invalid Email Format ");
            this.email.requestFocus();
            return false;
        } else if (!this.pass.equals("")) {
            return true;
        } else {
            this.password.setError("Password Empty!");
            return false;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0096R.id.btnLogin_operator_login:
                if (validateViews() && validateEmail(this.Email)) {
                    new LoadUserDetails().execute(new String[0]);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
