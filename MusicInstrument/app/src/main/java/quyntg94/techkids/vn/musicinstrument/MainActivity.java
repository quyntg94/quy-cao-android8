package quyntg94.techkids.vn.musicinstrument;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView ivString1;
    private ImageView ivString2;
    private ImageView ivString3;
    private ImageView ivString4;
    private ImageView ivString5;
    private ImageView ivString6;

    private List<ImageView> ivStrings;

    private List<PressedStringInfo> pressedStringInfoList;

    class PressedStringInfo{
        private ImageView ivKey;
        private int pointerId;

        public PressedStringInfo(ImageView ivKey, int pointerId) {
            this.ivKey = ivKey;
            this.pointerId = pointerId;
        }

        public ImageView getIvKey() {
            return ivKey;
        }

        public int getPointerId() {
            return pointerId;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setupUI();

    }

    private void setupUI() {
        ivStrings = new ArrayList<>();
        pressedStringInfoList = new ArrayList<>();
        ivStrings.add((ImageView) findViewById(R.id.iv_string1));
        ivStrings.add((ImageView) findViewById(R.id.iv_string2));
        ivStrings.add((ImageView) findViewById(R.id.iv_string3));
        ivStrings.add((ImageView) findViewById(R.id.iv_string4));
        ivStrings.add((ImageView) findViewById(R.id.iv_string5));
        ivStrings.add((ImageView) findViewById(R.id.iv_string6));

    }

    private boolean isInside(float x, float y, View v){
        int[] location = new int[2];
        v.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];

        int right = left + v.getWidth();
        int bottom = top + v.getHeight();

        return x > left && x < right && y > top && y < bottom;
    }

    private ImageView findPressedString(float pointerX, float pointerY){
        for(int i = 0; i < ivStrings.size(); i++){
            if(isInside(pointerX, pointerY, ivStrings.get(i))){
                Log.d("bhihi", String.valueOf(i));
//                ivBlackKeys.get(i).setImageResource(R.drawable.pressed_black_key);
                return ivStrings.get(i);
            }
        }

        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ahihi", String.valueOf(event.getX()) + " , " + String.valueOf(event.getY()));

        int pointerIndex = MotionEventCompat.getActionIndex(event);

        int pointerId = event.getPointerId(pointerIndex);

        float pointerX = event.getX(pointerIndex);
        float pointerY = event.getY(pointerIndex);

        int pointerAction = event.getActionMasked();

        Log.d("ahuhu", String.valueOf(pointerIndex));

//        if(pointerX > ivBlackKey1.getLeft() && pointerX < ivBlackKey1.getRight()
//                && pointerY > ivBlackKey1.getTop() && pointerY < ivBlackKey1.getBottom()){
//            Log.d("ahuhu", "ahuhu");
//        }
        ImageView pressedKey = findPressedString(pointerX, pointerY);

        if(pointerAction == MotionEvent.ACTION_MOVE){
            for(int i = 0; i < pressedStringInfoList.size(); i++){
                PressedStringInfo pressedStringInfo = pressedStringInfoList.get(i);
                if(pressedStringInfo.getPointerId() == pointerId
                        && !isInside(pointerX, pointerY, pressedStringInfo.getIvKey())){

                    //touch moved outside view
                    pressedStringInfoList.remove(i);
                    setPressed(pressedStringInfo.getIvKey(), false);
                }
            }

        }
//        if(pointerAction == MotionEvent.ACTION_MOVE) {
//            for(int pointerIndex = 0; pointerIndex < event.getPointerCount(); pointerIndex++) {
//                int pointerId = event.getPointerId(pointerIndex);
//                float pointerX = event.getX(pointerIndex);
//                float pointerY = event.getY(pointerIndex);
//            }
//        }


        if(pressedKey != null){
            if(pointerAction == MotionEvent.ACTION_DOWN
                    || pointerAction == MotionEvent.ACTION_POINTER_DOWN
                    || pointerAction == MotionEvent.ACTION_MOVE){
                if(!containsKeyInfoWIth(pressedKey)){
                    pressedStringInfoList.add(new PressedStringInfo(pressedKey, pointerId));
                    setPressed(pressedKey, true);

                }
            }
            if(pointerAction == MotionEvent.ACTION_UP
                    || pointerAction == MotionEvent.ACTION_POINTER_UP){
                for(int i = 0; i < pressedStringInfoList.size(); i++){
                    if(pressedStringInfoList.get(i).getPointerId() == pointerId){
                        pressedStringInfoList.remove(i);
                    }
                    setPressed(pressedKey, false);
                }
            }
        }

        return super.onTouchEvent(event);
    }

    private boolean containsKeyInfoWIth(ImageView ivKey){
        for(int i = 0; i < pressedStringInfoList.size(); i++){
            if(pressedStringInfoList.get(i).getIvKey() == ivKey){
                return true;
            }

        }
        return false;
    }

    private void setPressed(ImageView vKey, boolean isPressed){
        if(isPressed){
            if(ivStrings.contains(vKey)) vKey.setBackgroundColor(Color.BLACK);

        } else {
            if(ivStrings.contains(vKey)) vKey.setBackgroundColor(Color.WHITE);
        }
    }
}
