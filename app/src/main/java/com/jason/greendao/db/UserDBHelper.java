package com.jason.greendao.db;

import android.content.Context;
import android.util.Log;

import com.jason.greendao.bean.User;
import com.jason.greendao.utils.StringUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiaBo on 2017/9/19.
 */

public class UserDBHelper {

    private static final String TAG = "UserDBHelper";

    public static List<User> buildUserData() {
        List<User> list = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 20; i++) {
            user = new User();
            user.setName("Name=" + StringUtil.getRandomId(6));
            user.setAge(Integer.parseInt(StringUtil.getRandomId(2)));
            user.setIndex(Integer.parseInt(StringUtil.getRandomId(8)));
            user.setUserId("userId-" + StringUtil.getRandomId(6));
            list.add(user);
        }
        return list;
    }

    /**
     * 插入一条数据
     *
     * @param user
     */
    public static void insertUser(User user) {
        try {
            DBManager.getInstance().getUserDao().insert(user);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * 插入数据列表
     *
     * @param userList
     */
    public static void insertUerList(List<User> userList) {
        try {
            DBManager.getInstance().getUserDao().insertInTx(userList);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * 删除指定字段对应的数据
     *
     * @param name
     */
    public static void deleteUserByName(String name) {
        if (StringUtil.isBlank(name)) {
            return;
        }
        try {
            User user = queryUserByName(name);
            if (user != null) {
                DBManager.getInstance().getUserDao().delete(user);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }

    /**
     * 更新数据
     *
     * @param context
     * @param user
     */
    public static void updateUser(Context context, User user) {
        try {
            DBManager.getInstance().getUserDao().update(user);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * 查询指定id的数据
     *
     * @param userId
     * @return
     */
    public static User queryUser(String userId) {
        try {
            return DBManager.getInstance().getUserDao().queryBuilder().where(UserDao.Properties.UserId.eq(userId)).unique();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * 查询指定id的数据
     *
     * @param name
     * @return
     */
    public static User queryUserByName(String name) {
        try {
            return DBManager.getInstance().getUserDao().queryBuilder().where(UserDao.Properties.Name.eq(name)).unique();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * 查询指定字段的所有数据
     *
     * @param name
     * @return
     */
    public static List<User> queryUserList(String name) {
        try {
            QueryBuilder qb = DBManager.getInstance().getUserDao().queryBuilder();
            qb.where(UserDao.Properties.Name.eq(name), UserDao.Properties.Age.gt(1970));
            qb.orderAsc(UserDao.Properties.Index);
            return qb.list();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public static List<User> queryUsers() {
        try {
            return DBManager.getInstance().getUserDao().queryBuilder().list();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * 删除所有数据
     *
     * @return
     */
    public static void deleteAll() {
        try {
            DBManager.getInstance().getUserDao().deleteAll();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }


}
