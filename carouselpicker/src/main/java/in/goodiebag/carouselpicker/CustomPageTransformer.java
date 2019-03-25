package in.goodiebag.carouselpicker;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by pavan on 25/04/17.
 */

import android.content.Context;
import android.widget.TextView;

public class CustomPageTransformer implements ViewPager.PageTransformer {

    private ViewPager viewPager;
    private Boolean isPlain = false;
    private int primaryColor;
    private int secundaryColor;
    private Boolean hasSecundaryColor;

    public CustomPageTransformer(Context context) {
    }

    public CustomPageTransformer(Context context, Boolean isPlain, @ColorInt int primaryColor, @ColorInt int secundaryColor){
        this.isPlain = isPlain;
        this.primaryColor = primaryColor;
        this.secundaryColor = secundaryColor;
        this.hasSecundaryColor = true;

    }

    public CustomPageTransformer(Context context, Boolean isPlain){
        this.isPlain = isPlain;
        this.hasSecundaryColor = false;
    }

    public void transformPage(@NonNull View view, float position) {
        if (viewPager == null) {
            viewPager = (ViewPager) view.getParent();
        }

        if(!isPlain) {
            view.setScaleY(1 - Math.abs(position));
            view.setScaleX(1 - Math.abs(position));
        } else {
            if(position < 0.1 && position > -0.1) {
                view.setScaleY(1);
                view.setScaleX(1);
            } else {
                view.setScaleY((float) 0.8);
                view.setScaleX((float) 0.8);
            }
        }

        if(hasSecundaryColor) {
            if (position < 0.1 && position > -0.1)
                ((TextView) view.findViewById(R.id.tv)).setTextColor(primaryColor);
            else
                ((TextView) view.findViewById(R.id.tv)).setTextColor(secundaryColor);
        }
    }

}
