package com.jason.greendao.dao;

import android.text.TextUtils;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JiaBo on 2017/9/19.
 */

public class StringConverter implements PropertyConverter<List<String>, String> {
    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (TextUtils.isEmpty(databaseValue)) {
            return null;
        }
        return Arrays.asList(databaseValue.split(","));
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String link : entityProperty) {
            sb.append(link);
            sb.append(",");
        }
        return sb.toString();
    }
}
