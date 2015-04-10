package mvp.dagger.yify.yify.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HP LAPTOP on 11-01-2015.
 */
public class QuickFontTextView extends TextView {

    public QuickFontTextView(Context context) {
        super(context);
        style(context);
    }

    public QuickFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context);
    }

    public QuickFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        style(context);
    }

    private void style(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/RobotoCondensed-Bold.ttf");
        setTypeface(tf);
    }

}