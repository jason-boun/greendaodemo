package com.jason.greendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jason.greendao.base.MyApplication;

/**
 * Created by JiaBo on 2017/9/19.
 * 数据库管理与操作的入口类
 */

public class DBManager {

    public static final String DATABASE_NAME = "android_green_dao_db";

    private static volatile DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager();
                }
            }
        }
        return instance;
    }

    private DaoMaster.OpenHelper openHelper;
    private SQLiteDatabase sqLiteDatabase;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DBManager() {
        openHelper = new DaoMaster.DevOpenHelper(MyApplication.getAppContext(), DATABASE_NAME, null);
        sqLiteDatabase = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public UserDao getUserDao() {
        return daoSession.getUserDao();
    }

}
