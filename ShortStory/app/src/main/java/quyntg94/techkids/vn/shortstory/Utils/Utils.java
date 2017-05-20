package quyntg94.techkids.vn.shortstory.Utils;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by quyntg94 on 16/05/2017.
 */

public class Utils {
    public static void makeFit(final TextView textView) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int maxLines = textView.getHeight() / textView.getLineHeight();
                if (textView.getLineCount() > maxLines) {
                    textView.setMaxLines(maxLines);
                }
            }
        });
    }
}
