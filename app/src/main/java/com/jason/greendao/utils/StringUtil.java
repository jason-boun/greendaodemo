package com.jason.greendao.utils;

import java.util.Random;

/**
 * Created by JiaBo on 2017/9/20.
 */

public class StringUtil {

    /**
     * 剔除两侧空格后是否为空
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 获取指定位数的随机数
     *
     * @return
     */
    public static String getRandomId(int count) {
        StringBuilder str = new StringBuilder();//定义变长字符串
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for (int i = 0; i < count; i++) {
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并输出
        int num = Integer.parseInt(str.toString());
        return num + "";
    }
}
