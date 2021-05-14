package com.shaonian.dynamic.form.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.DictBean;
import com.shaonian.dynamic.form.formitem.PullSelectFormItem;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private final Context mContext;
    private int mMode;
    private int mStyleMode;
    private List<DictBean> mDictBeans;

    /**
     * 构造函数
     *
     * @param context      上下文
     * @param mode         {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#SINGLE_SELECT},
     *                     {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#MULTIPLE_SELECT},
     *                     {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#LINKED_SINGLE_SELECT},
     *                     {@link com.shaonian.dynamic.form.formitem.PullSelectFormItem#LINKED_MULTIPLE_SELECT},
     * @param styleMode    {@link #WARP_CONTENT}, {@link #AUTO},{@link #CUSTOM}
     * @param dictBeanList 数据
     */
    public SelectPopWindow(Context context, int mode, int styleMode, List<DictBean> dictBeanList) {
        super(context);
        this.mMode = mode;
        this.mStyleMode = styleMode;
        this.mDictBeans = dictBeanList;
        this.mContext = context;
        setView();
    }

    /**
     * 根据不同的类型展示不同的界面
     */
    private void setView() {
        int layoutId;
        switch (mMode) {
            case PullSelectFormItem.SINGLE_SELECT:
            case PullSelectFormItem.LINKED_SINGLE_SELECT:
            default:
                layoutId = R.layout.pop_view_select_single;
                break;
            case PullSelectFormItem.MULTIPLE_SELECT:
            case PullSelectFormItem.LINKED_MULTIPLE_SELECT:
                layoutId = R.layout.pop_view_select_multiple;
                break;
        }
        View root = LayoutInflater.from(mContext).inflate(layoutId, null, false);
        setContentView(root);
        initView(root);
    }

    private void initView(View root) {
        LinearLayout container = root.findViewById(R.id.ll_container);
        TextView sure = root.findViewById(R.id.tv_sure);
        if (sure != null) {
            sure.setOnClickListener(this::chooseData);
        }
        // 根据选择类型以及数据源的情况动态生成recycleView并设置数据
        switch (mMode) {
            case PullSelectFormItem.SINGLE_SELECT:
                setSingleView(container);
                break;
            case PullSelectFormItem.MULTIPLE_SELECT:
                break;
            default:
                break;
        }
    }

    /**
     * 设置单个的recycleView
     *
     * @param container 容器View
     */
    private void setSingleView(LinearLayout container) {
        RecyclerView recyclerView = new RecyclerView(mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        // TODO 暂时搁置
    }

    /**
     * 确定多选的内容
     */
    private void chooseData(View view) {

    }
}
