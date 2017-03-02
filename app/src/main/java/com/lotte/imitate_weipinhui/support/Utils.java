package com.lotte.imitate_weipinhui.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by wubin on 2017/2/21.
 */

public class Utils {
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    public static int px2dip(Context context, float pxValue) {
        //scale   （DisplayMetrics类中属性density）
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    public static int dip2px(Context context, float dipValue) {
        //scale    （DisplayMetrics类中属性density）
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        //fontScale （DisplayMetrics类中属性scaledDensity）
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        //fontScale （DisplayMetrics类中属性scaledDensity）
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static void initToolbar(AppCompatActivity activity, Toolbar toolbar, String title, String subTitle, int resIcon, Drawable icon) {

        toolbar.setTitle(title);
        toolbar.setSubtitle(subTitle);

        activity.setSupportActionBar(toolbar);

        if (resIcon != 0) {
            toolbar.setNavigationIcon(resIcon);
            return;
        }
        toolbar.setNavigationIcon(icon);
    }
}
