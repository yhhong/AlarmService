package com.aspirecn.demo.alarmservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_count_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_count_service).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_count_service:
                Intent i = new Intent("ALARM");
                AlarmUtil.setupRepeatedAlarm(this, 99999, i, 0, 3000);

                break;
            case R.id.btn_stop_count_service:
                Intent i2 = new Intent("ALARM");
                AlarmUtil.cancelAlarm(this, 99999, i2);
                break;
        }
    }
}
