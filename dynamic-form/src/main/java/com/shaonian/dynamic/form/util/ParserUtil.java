package com.shaonian.dynamic.form.util;

import com.shaonian.dynamic.form.formitem.BaseFormItem;

import java.util.List;

/**
 * 参数解析工具类
 *
 * @author wk
 * @date 2021/05/25
 */

public class ParserUtil {

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Number parseNumber(Object obj) {
        Number number = null;
        if (obj instanceof Integer) {
            number = (int) obj;
        } else if (obj instanceof Double) {
            number = (double) obj;
        } else if (obj instanceof Float) {
            number = (float) obj;
        } else if (obj instanceof Long) {
            number = (long) obj;
        } else if (obj instanceof Short) {
            number = (short) obj;
        } else if (obj instanceof Byte) {
            number = (byte) obj;
        }
        return number;
    }

    public static Number parseListNumber(List<BaseFormItem> baseFormItems) {
        Number number = null;
        for (BaseFormItem baseFormItem : baseFormItems) {

        }
        return number;
    }

}
