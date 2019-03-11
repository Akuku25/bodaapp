package com.bodaboda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;

public class Splash extends SherlockActivity {
    boolean checked = false;
    CheckBox dontShowAgain;
    Button getStarted;
    SharedPreferences myPrefs;
    Spinner spinnerMode;
    int spinnerMode_Value = 0;

    /* renamed from: com.bodaboda.Splash$1 */
    class C00971 implements OnItemSelectedListener {
        C00971() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long arg3) {
            Splash.this.spinnerMode_Value = position;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.bodaboda.Splash$2 */
    class C00982 implements OnCheckedChangeListener {
        C00982() {
        }

        public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
            Splash.this.checked = isChecked;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0096R.layout.splash);
        initializeViews();
        this.myPrefs = getSharedPreferences("My Prefs", 0);
        this.spinnerMode.setOnItemSelectedListener(new C00971());
        this.dontShowAgain.setOnCheckedChangeListener(new C00982());
    }

    public void initializeViews() {
        this.dontShowAgain = (CheckBox) findViewById(C0096R.id.chkDontShowAgain);
        this.getStarted = (Button) findViewById(C0096R.id.btnGetStarted);
        this.spinnerMode = (Spinner) findViewById(C0096R.id.spinnerMode);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0096R.id.btnGetStarted:
                if (this.spinnerMode_Value == 0) {
                    Toast.makeText(getBaseContext(), "Please Select Mode to Continue", 1).show();
                    return;
                }
                Editor edit = this.myPrefs.edit();
                edit.putBoolean("dont_show_again", this.checked);
                edit.commit();
                if (this.spinnerMode_Value == 1) {
                    startActivity(new Intent(getBaseContext(), Passager_Login_SignUp.class));
                    finish();
                    return;
                } else if (this.spinnerMode_Value == 2) {
                    startActivity(new Intent(getBaseContext(), Operator_Login_SignUp.class));
                    finish();
                    return;
                } else {
                    Toast.makeText(getBaseContext(), "Please Select Mode to Continue", 1).show();
                    return;
                }
            default:
                return;
        }
    }
}
