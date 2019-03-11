package com.bodaboda;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.actionbarsherlock.app.SherlockFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Passager_Signup_Fragment extends SherlockFragment implements OnClickListener {
    private static final String TAG_SUCCESS = "success";
    private static String url_create_product = "http://10.0.2.2:8888/inventory_connect/create_product.php";
    String Email;
    String Fullnames;
    String MobileNumber;
    String RegNo;
    String cPass;
    EditText cPassword;
    EditText email;
    EditText fullnames;
    JSONParser jsonParser = new JSONParser();
    EditText mobile;
    private ProgressDialog pDialog;
    String pass;
    EditText password;
    SharedPreferences prefs;
    EditText regno;
    Button signUPTwitter;
    Button signUp;

    /* renamed from: com.bodaboda.Passager_Signup_Fragment$1 */
    class C00951 implements DialogInterface.OnClickListener {
        C00951() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0096R.layout.passager_sign_up, container, false);
        initializeViews(view);
        this.signUp.setOnClickListener(this);
        return view;
    }

    public boolean checkNetworkState() {
        NetworkInfo NInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
        if (NInfo == null || !NInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    private void initializeViews(View view) {
        this.fullnames = (EditText) view.findViewById(C0096R.id.etFullnames);
        this.regno = (EditText) view.findViewById(C0096R.id.etRegNo);
        this.mobile = (EditText) view.findViewById(C0096R.id.etMobile);
        this.email = (EditText) view.findViewById(C0096R.id.etEmail);
        this.password = (EditText) view.findViewById(C0096R.id.etPassword);
        this.cPassword = (EditText) view.findViewById(C0096R.id.etCPassword);
        this.signUp = (Button) view.findViewById(C0096R.id.btnPassagerSignUp);
    }

    public boolean validateEmail(String email) {
        if (Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(email).matches()) {
            return true;
        }
        return false;
    }

    private boolean validateViews() {
        this.Fullnames = this.fullnames.getText().toString();
        this.MobileNumber = this.mobile.getText().toString();
        this.Email = this.email.getText().toString();
        this.pass = this.password.getText().toString();
        this.cPass = this.cPassword.getText().toString();
        if (this.Fullnames.equals("")) {
            this.fullnames.setError("Full Names Empty!");
            return false;
        } else if (this.MobileNumber.equals("")) {
            this.mobile.setError("Lastname Empty!");
            return false;
        } else if (this.Email.equals("")) {
            this.email.setError("Email Empty!");
            return false;
        } else if (this.pass.equals("")) {
            this.password.setError("Password Empty!");
            return false;
        } else if (this.cPass.equals("")) {
            this.cPassword.setError("Confirm Password Empty");
            return false;
        } else if (!validateEmail(this.email.getText().toString())) {
            this.email.setError("Invalid Email Format ");
            this.email.requestFocus();
            return false;
        } else if (this.pass.equals(this.cPass)) {
            return true;
        } else {
            this.password.setError("Password Dont Match");
            this.password.setText("");
            this.cPassword.setText("");
            this.password.requestFocus();
            return false;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0096R.id.btnPassagerSignUp:
                if (!checkNetworkState()) {
                    Builder alert = new Builder(getActivity());
                    alert.setTitle("2131099699::Network Error");
                    alert.setMessage("Unable to connect. Please check that you are connected to the Internet and try again. \n Please reboot your phone if your connection problem persists.");
                    alert.setNeutralButton("Ok", new C00951());
                    alert.show();
                    return;
                } else if (validateViews()) {
                    List<NameValuePair> params = new ArrayList();
                    params.add(new BasicNameValuePair("fullnames", this.Fullnames));
                    params.add(new BasicNameValuePair("email", this.Email));
                    params.add(new BasicNameValuePair("password", this.pass));
                    params.add(new BasicNameValuePair("mobile_number", this.MobileNumber));
                    params.add(new BasicNameValuePair("reg_no", ""));
                    params.add(new BasicNameValuePair("user_type", "2"));
                    Create_User user = new Create_User();
                    user.parameters = params;
                    user.f1c = getActivity();
                    user.fromPassager = true;
                    user.execute(new String[0]);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
