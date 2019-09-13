package com.example.golearn.myActivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.golearn.R;

public class SplashActivity extends AppCompatActivity {

    public AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //check for user from firebase
                //check for internet
                //start next activity
                if(checkInternetConnectivity()){
                    startActivity(new Intent(getApplicationContext(),ExpandableListHomeActivity.class));
                    finish();
                }else {
                   android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(SplashActivity.this);
                    alertDialog.setCancelable(false);
                    alertDialog.setTitle("Please Enable Your Internet Connection");
                    alertDialog.setMessage("");
                    //Action on YES
                    alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Launch settings
                            Intent intent = new Intent();
                            intent.setAction(Settings.ACTION_SETTINGS);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
                    //Action on NO
                    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    //Action Neutral Button : CANCEL

//                    alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
                    android.app.AlertDialog alertDialog1 = alertDialog.create();
                    alertDialog1.show();

                }

            }
        },5000);
    }

    public boolean checkInternetConnectivity(){
        //if internet connection is enabled, return true else return false
        return true;
    }
}
