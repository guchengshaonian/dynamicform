package com.shaonian.dynamic.form.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaonian.dynamic.form.R;
import com.shaonian.dynamic.form.bean.AdapterChooseBean;
import com.shaonian.dynamic.form.bean.DictBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 下拉选择框的adapter
 *
 * @author wk
 * @date 2021/05/07
 */

public class SelectPopAdapter extends RecyclerView.Adapter<SelectPopAdapter.SelectPopViewHolder> {

    private final List<AdapterChooseBean<DictBean>> mDictBeans = new ArrayList<>();
    private final List<AdapterChooseBean<DictBean>> mChooseBeans = new ArrayList<>();
    private final boolean isMultiple;
    private final boolean isLinked;
    private SelectValueListener mSelectValueListener;

    public void setSelectValueListener(SelectValueListener selectValueListener) {
        mSelectValueListener = selectValueListener;
    }

    public interface SelectValueListener {
        /**
         * 单选的选择内容
         *
         * @param dictBean 选中的内容
         */
        void onSelectValue(DictBean dictBean);
    }

    public List<DictBean> getChooseBeans() {
        List<DictBean> beanList = new ArrayList<>();
        for (AdapterChooseBean<DictBean> chooseBean : mChooseBeans) {
            if (chooseBean.isChoose()) {
                beanList.add(chooseBean.getBean());
            }
        }
        return beanList;
    }

    public SelectPopAdapter(List<DictBean> dictBeanList, boolean isMultiple, boolean isLinked) {
        super();
        this.isMultiple = isMultiple;
        this.isLinked = isLinked;
        setNewData(dictBeanList);
    }

    public void setNewData(List<DictBean> dictBeans) {
        mDictBeans.clear();
        for (DictBean dictBean : dictBeans) {
            mDictBeans.add(new AdapterChooseBean<>(dictBean));
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SelectPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelectPopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_select_pop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SelectPopAdapter.SelectPopViewHolder holder, int position) {
        holder.fill(mDictBeans.get(position).getBean(), isMultiple, isLinked);
        holder.itemView.setOnClickListener(v -> {
            if (isMultiple) {
                if (isLinked) {
                    // TODO 展开下一层
                } else {
                    mChooseBeans.add(mDictBeans.get(position));
                }
            } else {
                if (isLinked) {
                    // TODO 展开下一层
                } else {
                    if (mSelectValueListener != null) {
                        mSelectValueListener.onSelectValue(mDictBeans.get(position).getBean());
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDictBeans.size();
    }

    public static class SelectPopViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivArrow;
        private final ImageView ivChoose;
        private final TextView tvValue;

        public SelectPopViewHolder(@NonNull View itemView) {
            super(itemView);
            ivArrow = itemView.findViewById(R.id.iv_arrow);
            ivChoose = itemView.findViewById(R.id.iv_choose);
            tvValue = itemView.findViewById(R.id.tv_item_value);
        }

        public void fill(DictBean dictBean, boolean isMultiple, boolean isLinked) {
            tvValue.setText(dictBean.getName());
            if (isMultiple) {
                ivChoose.setVisibility(View.VISIBLE);
            } else {
                ivChoose.setVisibility(View.GONE);
            }
            if (isLinked) {
                ivArrow.setVisibility(View.VISIBLE);
            } else {
                ivArrow.setVisibility(View.GONE);
            }
        }
    }
}
