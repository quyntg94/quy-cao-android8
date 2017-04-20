package quyntg94.techkids.vn.fruitbasket;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quyntg94 on 20/04/2017.
 */

public class FruitDatabases extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "fruit.db";
    private static final int DATABASE_VERSION = 1;

    private static final String FRUIT_ID= "id";
    private static final String FRUIT_NAME = "name";
    private static final String FRUIT_IMAGE = "image";
    private static final String FRUIT_PRICE = "price";
    private static final String FRUIT_NUMBER = "number";

    private static final String[] FRUIT_ALL_COLUMN = new String[]{
            FRUIT_ID,
            FRUIT_NAME,
            FRUIT_IMAGE,
            FRUIT_PRICE,
            FRUIT_NUMBER
    };

    public FruitDatabases(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<Fruit> loadAllFruit(){

        List<Fruit> fruitList = new ArrayList<>();
        //get readable database
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //query ==> cursor
        Cursor cursor = sqLiteDatabase.query("tbl_fruit", FRUIT_ALL_COLUMN, null, null, null, null, null);

        //go through row
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(FRUIT_ID));
            String name = cursor.getString(cursor.getColumnIndex(FRUIT_NAME));
            String image = cursor.getString(cursor.getColumnIndex(FRUIT_IMAGE));
            int price = cursor.getInt(cursor.getColumnIndex(FRUIT_PRICE));
            int number = cursor.getInt(cursor.getColumnIndex(FRUIT_NUMBER));


            Fruit fruit = new Fruit(id, name, image, price, number);
            fruitList.add(fruit);

            Log.d("ahihi", fruit.toString());

        }
        return fruitList;
    }
}
