package mvp.dagger.yify.yify.views;

/**
 * Created by HP LAPTOP on 11-01-2015.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by HP LAPTOP on 11-01-2015.
 */
public class QuickButton extends Button {
    public QuickButton(Context context) {
        super(context);
        style(context);
    }

    public QuickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context);
    }

    public QuickButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        style(context);
    }

    private void style(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/RobotoCondensed-Bold.ttf");
        setTypeface(tf);
    }
}
