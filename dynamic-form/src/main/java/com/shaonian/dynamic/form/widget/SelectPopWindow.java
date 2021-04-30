package com.shaonian.dynamic.form.widget;

import android.content.Context;
import android.widget.PopupWindow;

/**
 * 下拉框的popWindow
 *
 * @author wk
 * @date 2021/04/30
 */

public class SelectPopWindow extends PopupWindow {
    /**
     * popupWindow大小，包裹内容大小
     */
    public static final int WARP_CONTENT = 0;
    /**
     * popupWindow大小，等分
     */
    public static final int AUTO = 1;
    /**
     * popupWindow大小，自定义
     */
    public static final int CUSTOM = 2;

    /**
     * 构造函数
     *
     * @param context   上下文
     * @param mode      {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#SINGLE_SELECT},
     *                  {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#MULTIPLE_SELECT},
     *                  {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#LINKED_SINGLE_SELECT},
     *                  {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#LINKED_MULTIPLE_SELECT},
     * @param styleMode {@link #WARP_CONTENT}, {@link #AUTO},{@link #CUSTOM}
     */
    public SelectPopWindow(Context context, int mode, int styleMode) {
        super(context);
        setView(mode);
    }

    /**
     * 根据不同的类型展示不同的界面
     *
     * @param mode
     */
    private void setView(int mode) {

    }
}
