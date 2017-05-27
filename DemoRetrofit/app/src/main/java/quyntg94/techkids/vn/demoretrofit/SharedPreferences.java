package quyntg94.techkids.vn.demoretrofit;

import android.content.Context;

/**
 * Created by quyntg94 on 27/05/2017.
 */

public class SharedPreferences {

    private static final String KEY = "Laujilao";
    private static final String USERNAME_KEY = "Username";
    private static final String PASSWORD_KEY = "Password";
    private static final String REMEMBER_KEY = "Remember";
    private android.content.SharedPreferences sharedPreferences;

    public SharedPreferences(Context context){
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getUsername(){
        return sharedPreferences.getString(USERNAME_KEY, null);
    }

    public void putUsername(String account){
        sharedPreferences.edit().putString(USERNAME_KEY, account).apply();
    }

    public String getPassword(){
        return sharedPreferences.getString(PASSWORD_KEY, null);
    }

    public void putPassword(String password){
        sharedPreferences.edit().putString(PASSWORD_KEY, password).apply();
    }

    public String getRemember(){
        return sharedPreferences.getString(REMEMBER_KEY, null);
    }

    public void putRemember(String remember){
        sharedPreferences.edit().putString(REMEMBER_KEY, remember).apply();
    }

    private static SharedPreferences instance;
    public static SharedPreferences getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new SharedPreferences(context);
    }
}
