package com.jason.greendao.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jason.greendao.R;
import com.jason.greendao.bean.User;
import com.jason.greendao.db.UserDBHelper;
import com.jason.greendao.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JiaBo on 2017/9/19.
 */

public class DBActivity extends Activity {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.bt_delete)
    Button btDelete;
    @BindView(R.id.bt_update)
    Button btUpdate;
    @BindView(R.id.bt_query)
    Button btQuery;
    @BindView(R.id.bt_delete_all)
    Button btDeleteAll;
    @BindView(R.id.bt_show_all)
    Button btShowAll;
    private List<User> sourceDataList = new ArrayList<>();
    private List<User> queryDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_add, R.id.bt_delete, R.id.bt_update, R.id.bt_query, R.id.bt_delete_all, R.id.bt_show_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                addData();
                break;
            case R.id.bt_delete:
                deleteData();
                break;
            case R.id.bt_update:
                updateData();
                break;
            case R.id.bt_query:
                findDataAll();
                break;
            case R.id.bt_delete_all:
                deleteAll();
                break;
            case R.id.bt_show_all:
                showAllData();
                break;
        }
    }

    private void deleteAll() {
        UserDBHelper.deleteAll(this);
        if (UserDBHelper.queryUsers(this).size() == 0) {
            sourceDataList.clear();
            queryDataList.clear();
            tvContent.setText("删除完毕");
            Toast.makeText(this, "删除完毕", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 增加数据
     */
    private void addData() {
        if (sourceDataList.size() > 41) {
            return;
        }
        sourceDataList.addAll(UserDBHelper.buildUserData());
        UserDBHelper.insertUerList(this, sourceDataList);
        Toast.makeText(this, "操作成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * 删除数据
     */
    private void deleteData() {
        if (queryDataList.size() == 0) {
            Toast.makeText(this, "请先查询数据", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = queryDataList.get(0);

        User result1 = UserDBHelper.queryUserByName(this, user.getName());
        UserDBHelper.deleteUserByName(this, user.getName());
        User result2 = UserDBHelper.queryUserByName(this, user.getName());
        if (result1 != null && result2 == null) {
            tvContent.setText("删除了用户：" + user.getName() + "；userId为" + user.getUserId());
            queryDataList.remove(user);
        }
    }

    /**
     * 更改数据
     */
    private void updateData() {
        if (queryDataList.size() == 0) {
            Toast.makeText(this, "请先查询数据", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = queryDataList.get(0);
        String oldName = user.getName();
        String newName = "MM" + StringUtil.getRandomId(3) + oldName.substring(2);
        user.setName(newName);

        UserDBHelper.updateUser(this, user);
        User queryUser = UserDBHelper.queryUserByName(this, newName);

        if (queryUser != null) {
            tvContent.setText("修改了用户：" + oldName + "；新的用户名为：" + queryUser.getName());
        }
    }

    /**
     * 查找数据
     */
    private void findDataAll() {
        queryDataList.clear();
        List<User> results = UserDBHelper.queryUsers(this);
        if (results.size() == 0) {
            tvContent.setText("数据为空");
        } else {
            queryDataList.addAll(results);
            tvContent.setText("有" + results.size() + "条数据");
        }
    }

    /**
     * 展示所有数据
     */
    private void showAllData() {
        List<User> results = UserDBHelper.queryUsers(this);
        if (results.size() == 0) {
            tvContent.setText("数据为空");
        }else {
            String str = "有" + results.size() + "条数据: "+"\n";
            for (User user:results){
                str =str+ user.getName()+"; ";
            }
            tvContent.setText(str);
        }
    }

}
