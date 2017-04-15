package quyntg94.techkids.vn.musicinstrument.touches;

import android.view.View;

/**
 * Created by quyntg94 on 11/04/2017.
 */

public class Touch {

    private float x;
    private float y;
    private int id;
    private int action;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public int getAction() {
        return action;
    }

    public boolean isInside(View v){
        int[] location = new int[2];
        v.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];

        int right = left + v.getWidth();
        int bottom = top + v.getHeight();

        return x > left && x < right && y > top && y < bottom;
    }

    public Touch(float x, float y, int id, int action) {

        this.x = x;
        this.y = y;
        this.id = id;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Touch{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                ", action=" + action +
                '}';
    }
}
