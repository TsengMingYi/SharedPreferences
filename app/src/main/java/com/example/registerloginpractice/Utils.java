package com.example.registerloginpractice;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static void toast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void toastAccountAlreadyExist(Context context){
        toast(context,context.getResources().getString(R.string.register_fail_account_already_exist));
    }

}
