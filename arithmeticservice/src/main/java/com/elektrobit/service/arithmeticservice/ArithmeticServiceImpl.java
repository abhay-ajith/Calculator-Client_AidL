package com.elektrobit.service.arithmeticservice;

import static android.os.Build.VERSION_CODES.S;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class ArithmeticServiceImpl extends IArithmeticService.Stub{
    private final String TAG = ArithmeticServiceImpl.class.getName();
    @Override
    public IBinder asBinder() {
        return super.asBinder();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        Log.d(TAG, "in add");
        return a+b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        Log.d(TAG, "in subtract");
        return a-b;
    }
    public int multiply(int a, int b) throws RemoteException{
        Log.d(TAG, "in multiply");
        return a*b;
    }
    public int divide(int a, int b) throws RemoteException{
        Log.d(TAG, "in division");
        if(b==0){
            //Toast.makeText(this,"Cannot divide by 0",Toast.LENGTH_SHORT).show();
            throw new ArithmeticException("Goes INfinite");
        }
        else{
            return a/b;
        }
    }
}
