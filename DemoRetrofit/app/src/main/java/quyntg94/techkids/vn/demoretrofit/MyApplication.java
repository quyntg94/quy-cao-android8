package quyntg94.techkids.vn.demoretrofit;

import android.app.Application;

/**
 * Created by quyntg94 on 27/05/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences.init(this);
    }
}
