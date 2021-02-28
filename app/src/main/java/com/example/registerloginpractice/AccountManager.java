package com.example.registerloginpractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountManager {

//    private ArrayList<String> accountList = new ArrayList<>();
//    private ArrayList<String> passWordList = new ArrayList<>();

    private final String ACCOUNT = "ACCOUNT";
    private final String PASSWORD = "PASSWORD";



    public static AccountManager instance = new AccountManager();

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    private AccountManager() {
    }

    public boolean login(String account, String password) {

        SharedPreferences sp = context.getSharedPreferences(account,Context.MODE_PRIVATE);
        String dataAccount = sp.getString(ACCOUNT, "");
        if (dataAccount.length() != 0){
            String dataPassword = sp.getString(PASSWORD, "");
            if(dataPassword.equals(password)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
//        for (int i = 0; i < accountList.size(); i++) {
//            if (accountList.get(i).equals(account)) {
//                if (passWordList.get(i).equals(password)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
    }

    private boolean isInValidData(String account, String password){
        if(account == null || account.length()==0){
            return true;
        }
        if(password == null || password.length()==0){
            return true;
        }
        return false;
    }

    public boolean register(String account, String password) {
        if(isInValidData(account, password)){
            return false;
        }
        SharedPreferences sp = context.getSharedPreferences(account,Context.MODE_PRIVATE);
        String dataAccount = sp.getString(ACCOUNT, "");
        if (dataAccount.length() != 0){
            return false;
        }
        sp.edit().putString(ACCOUNT, account).putString(PASSWORD, password).apply();
        //showAllAccounts();
        return true;
    }

    private void showAllAccounts() {
//        for (int i = 0; i < accountList.size(); i++) {
//            Log.i("test ", "account: " + accountList.get(i));
//            Log.i("test ", "password: " + passWordList.get(i));
//        }
    }

}
