package quyntg94.techkids.vn.shortstory;

import android.app.Application;
import android.util.Log;

import quyntg94.techkids.vn.shortstory.databases.StoryDatabases;

/**
 * Created by quyntg94 on 18/04/2017.
 */

public class StoryApplication extends Application {

    private StoryDatabases storyDatabases;
    private static StoryApplication instance;

    @Override
    public void onCreate() {
        storyDatabases = new StoryDatabases(this);
        Log.d("ahuhu", "onCreate");
        instance = this;
        super.onCreate();

    }

    public StoryDatabases getStoryDatabases(){
        return storyDatabases;
    }

    public static StoryApplication getInstance() {
        return instance;
    }
}
