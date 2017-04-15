package quyntg94.techkids.vn.musicinstrument.touches;

import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_POINTER_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_UP;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by quyntg94 on 11/04/2017.
 */

public class TouchManager {

    public static List<Touch> toTouches(MotionEvent event){
        int action = event.getActionMasked();
        ArrayList<Touch> touches = new ArrayList<>();




        if(action == ACTION_DOWN || action == ACTION_POINTER_DOWN
                || action == ACTION_UP || action == ACTION_POINTER_UP){

            int pointerIndex = event.getActionIndex();

            float pointerX = event.getX(pointerIndex);
            float pointerY = event.getY(pointerIndex);
            int pointerId = event.getPointerId(pointerIndex);

            touches.add(new Touch(pointerX, pointerY, pointerId, action));

        } else if(action == ACTION_MOVE){
            for(int pointerIndex = 0; pointerIndex < event.getPointerCount(); pointerIndex++){
                float pointerX = event.getX(pointerIndex);
                float pointerY = event.getY(pointerIndex);
                int pointerId = event.getPointerId(pointerIndex);

                touches.add(new Touch(pointerX, pointerY, pointerId, action));

            }
        }

        return touches;
    }
}
