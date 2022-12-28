package com.cookandroid.exservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        Intent intent = new Intent(this, MyService.class);
        switch (v.getId()) {
            case R.id.btnPlayMusic:
                intent.setAction("andbook.example.PLAYMUSIC");
                startService(intent);
                break;
            case R.id.btnDownload:
                intent.setAction("andbook.example.DOWNLOAD");
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
        }
    }
}