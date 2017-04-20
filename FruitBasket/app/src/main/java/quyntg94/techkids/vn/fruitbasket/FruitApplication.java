package quyntg94.techkids.vn.fruitbasket;

import android.app.Application;

/**
 * Created by quyntg94 on 20/04/2017.
 */

public class FruitApplication extends Application {

    private FruitDatabases fruitDatabases;
    private static FruitApplication instance;

    @Override
    public void onCreate() {
        fruitDatabases = new FruitDatabases(this);
        instance = this;
        super.onCreate();

    }

    public FruitDatabases getFruitDatabases(){
        return fruitDatabases;
    }

    public static FruitApplication getInstance() {
        return instance;
    }
}
