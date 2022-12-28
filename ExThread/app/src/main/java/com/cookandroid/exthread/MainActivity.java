package com.cookandroid.exthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ClientThread mClientThread;
    private EditText mEditIP, mEditData;
    private Button mBtnConnect, mBtnSend;
    private TextView mTextOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditIP = (EditText) findViewById(R.id.editIP);
        mEditData = (EditText) findViewById(R.id.editData);
        mBtnConnect = (Button) findViewById(R.id.btnConnect);
        mBtnSend = (Button) findViewById(R.id.btnSend);
        mTextOutput = (TextView) findViewById(R.id.textOutput);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void mOnClick(View v){
        switch (v.getId()){
            case.R.id.btnConnect:
                if(mClientThread == null){
                    String str = mEditIP.getText().toString();
                    if(str.length() != 0) {
                        mClientThread = new ClientThread(str, mMainHandler);
                        mClientThread.start();
                        mBtnConnect.setEnabled(false);
                        mBtnSend.setEnabled(true);
                    }
                }
                break;
            case.R.id.btnQuit:
                finish();
                break;
            case .R.id.btnSend:
                if (SendThread.mHandler = new Handler(Looper.getMainLooper())){

                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                mTextOutput.append((String)msg.obj);
                                break;
                        }
                    }
                };
        }
    }
}