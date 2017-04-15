package quyntg94.techkids.vn.musicinstrument;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quyntg94 on 11/04/2017.
 */

public class SoundManager {
    public static int NUMBER_OF_NOTE = 6;
    public static SoundPool soundPool = new SoundPool(NUMBER_OF_NOTE, AudioManager.STREAM_MUSIC, 0);

    public static ArrayList<Integer> soundList = new ArrayList<>();

    public static void loadSoundInfoList(Context context){
        for(int i = 1; i <= NUMBER_OF_NOTE; i++){
            int resIdSound = context.getResources().getIdentifier("sound_" + i, "raw", context.getPackageName());
            int soundPoolId = soundPool.load(context, resIdSound, 1);
            soundList.add(soundPoolId);
        }
    }

    static HashMap<String, Integer> listSoundID =  new HashMap<>();

    static{
        listSoundID.put("E", 0);
        listSoundID.put("B", 1);
        listSoundID.put("G", 2);
        listSoundID.put("D", 3);
        listSoundID.put("A", 4);
        listSoundID.put("E#", 5);


    }


    public static void playSound(String string){
        soundPool.play(soundList.get(listSoundID.get(string)), 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
