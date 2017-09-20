package com.jason.greendao.db;


import com.jason.greendao.utils.StringUtil;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JiaBo on 2017/9/19.
 * 列表对象和字符串之间的转换器
 */

public class StringConverter implements PropertyConverter<List<String>, String> {

    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (StringUtil.isBlank(databaseValue)) {
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
