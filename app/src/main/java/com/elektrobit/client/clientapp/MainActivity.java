package com.elektrobit.client.clientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.elektrobit.service.arithmeticservice.IArithmeticService;
import com.elektrobit.service.arithmeticservice.ServiceIntentBuilder;


public class MainActivity extends AppCompatActivity {

    private IArithmeticService service;
    private final String TAG = MainActivity.class.getName();
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder ser) {
            service = IArithmeticService.Stub.asInterface(ser);
            Log.d(TAG, "onConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
            Log.d(TAG, "onDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        EditText result = findViewById(R.id.result);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.subtract);
        Button mul =findViewById(R.id.multiply);
        Button div =findViewById(R.id.divide);
        //Button mul =
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
                    int n1 = Integer.valueOf(num1.getText().toString()).intValue();
                    int n2 = Integer.valueOf(num2.getText().toString()).intValue();
                    try {
                        int r = service.add(n1,n2);
                        result.setText("Result"+r);
                    } catch (RemoteException e) {
                        result.setText(R.string.error_text);
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Both numbers nust me entered!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
                    int n1 = Integer.valueOf(num1.getText().toString());
                    int n2 = Integer.valueOf(num2.getText().toString());
                    try {
                        int r = service.subtract(n1,n2);
                        result.setText("Result"+r);
                    } catch (RemoteException e) {
                        result.setText(R.string.error_text);
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Both numbers must me entered!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
                    int n1 = Integer.valueOf(num1.getText().toString());
                    int n2 = Integer.valueOf(num2.getText().toString());
                    try {
                        int r = service.multiply(n1,n2);
                        result.setText("Result"+r);
                    } catch (RemoteException e) {
                        result.setText(R.string.error_text);
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Both numbers must me entered!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
                    int n1 = Integer.valueOf(num1.getText().toString());
                    int n2 = Integer.valueOf(num2.getText().toString());
                    try {
                        int r = service.divide(n1,n2);
                        result.setText("Result"+r);
                    } catch (RemoteException e) {
                        result.setText(R.string.error_text);
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Both numbers must me entered!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = new Intent();
        bindService(ServiceIntentBuilder.buildArithmeticServiceBindIntent(), connection, Context.BIND_AUTO_CREATE);
        Log.d(TAG,"OnCreated");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}