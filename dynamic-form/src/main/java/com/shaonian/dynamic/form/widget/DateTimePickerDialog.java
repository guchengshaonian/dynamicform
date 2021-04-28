package com.shaonian.dynamic.form.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import com.shaonian.dynamic.form.R;

import java.util.Calendar;

/**
 * 精确到年月日时分秒的选择器
 *
 * @author wk
 * @date 2021/04/27
 */

public class DateTimePickerDialog extends AlertDialog implements NumberPicker.Formatter, NumberPicker.OnValueChangeListener, DialogInterface.OnClickListener {

    private NumberPicker dayPicker;
    private NumberPicker yearPicker;
    private NumberPicker monthPicker;
    private NumberPicker hourPicker;
    private NumberPicker minutePicker;
    private NumberPicker secondPicker;
    private DataTimeSetListener mDataTimeSetListener;

    public void setDataTimeSetListener(DataTimeSetListener dataTimeSetListener) {
        mDataTimeSetListener = dataTimeSetListener;
    }

    public DateTimePickerDialog(Context context, DataTimeSetListener listener) {
        super(context);
        this.mDataTimeSetListener = listener;
        Calendar calendar = Calendar.getInstance();
        init(context,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }

    public DateTimePickerDialog(Context context, DataTimeSetListener listener, int year, int month, int day, int hour, int minute, int second) {
        super(context);
        this.mDataTimeSetListener = listener;
        init(context, year, month, day, hour, minute, second);
    }

    /**
     * 初始化界面并设置事件
     *
     * @param context 上下文
     * @param year    年
     * @param month   月
     * @param day     日
     * @param hour    时
     * @param minute  分
     * @param second  秒
     */
    private void init(Context context, int year, int month, int day, int hour, int minute, int second) {
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_date_time_picker, null);
        setView(view);
        yearPicker = view.findViewById(R.id.np_year);
        monthPicker = view.findViewById(R.id.np_month);
        dayPicker = view.findViewById(R.id.np_day);
        hourPicker = view.findViewById(R.id.np_hour);
        minutePicker = view.findViewById(R.id.np_minute);
        secondPicker = view.findViewById(R.id.np_second);
        // 这个每一个numberPicker的初始化參數
        Calendar calendar = Calendar.getInstance();
        yearPicker.setOnValueChangedListener(this);
        yearPicker.setMaxValue(calendar.get(Calendar.YEAR));
        yearPicker.setMinValue(calendar.get(Calendar.YEAR) - 50);
        yearPicker.setValue(year);

        monthPicker.setFormatter(this);
        monthPicker.setOnValueChangedListener(this);
        monthPicker.setMaxValue(12);
        monthPicker.setMinValue(1);
        monthPicker.setValue(month);

        dayPicker.setFormatter(this);
        dayPicker.setMaxValue(getMonthDay(year, month));
        dayPicker.setMinValue(1);
        dayPicker.setValue(day);

        hourPicker.setFormatter(this);
        hourPicker.setMaxValue(24);
        hourPicker.setMinValue(0);
        hourPicker.setValue(hour);

        minutePicker.setFormatter(this);
        minutePicker.setMaxValue(60);
        minutePicker.setMinValue(0);
        minutePicker.setValue(minute);

        secondPicker.setFormatter(this);
        secondPicker.setMaxValue(60);
        secondPicker.setMinValue(0);
        secondPicker.setValue(second);
        setButton(BUTTON_POSITIVE, context.getResources().getString(R.string.sure), this);
        setButton(BUTTON_NEGATIVE, context.getResources().getString(R.string.cancel), this);
    }

    /**
     * 根据年份和月份获取最大天数
     *
     * @param year  年
     * @param month 月
     * @return 天数
     */
    private int getMonthDay(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        //先指定年份
        calendar.set(Calendar.YEAR, year);
        //再指定月份
        calendar.set(Calendar.MONTH, month - 1);
        //获取指定年份中指定月份有几天
        return calendar.getActualMaximum(Calendar.DATE);
    }

    @Override
    public String format(int value) {
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if (picker.getId() == R.id.np_year) {
            dayPicker.setMaxValue(getMonthDay(newVal, monthPicker.getValue()));
        }
        if (picker.getId() == R.id.np_month) {
            dayPicker.setMaxValue(getMonthDay(yearPicker.getValue(), newVal));
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case BUTTON_POSITIVE:
                if (mDataTimeSetListener != null) {
                    mDataTimeSetListener.onDateSet(
                            yearPicker.getValue(),
                            monthPicker.getValue(),
                            dayPicker.getValue(),
                            hourPicker.getValue(),
                            minutePicker.getValue(),
                            secondPicker.getValue());
                }
                break;
            case BUTTON_NEGATIVE:
                cancel();
                break;
            default:
                break;
        }
    }

    public interface DataTimeSetListener {
        /**
         * 获取设置的时间回调
         *
         * @param year   年
         * @param month  月
         * @param day    日
         * @param hour   时
         * @param minute 分
         * @param second 秒
         */
        void onDateSet(int year, int month, int day, int hour, int minute, int second);
    }
}
