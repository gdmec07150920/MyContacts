package com.example.administrator.mycontacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/1.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    //声明界面控件属性
    private TextView nameEditText, danweiEditText,qqEditText,addressEditText,mobileEditText;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_massage);
        setTitle("联系人信息");
        //获取界面控件实例
        nameEditText= (TextView) findViewById(R.id.name);
        mobileEditText= (TextView) findViewById(R.id.mobile);
        danweiEditText= (TextView) findViewById(R.id.danwei);
        qqEditText= (TextView) findViewById(R.id.qq);
        addressEditText= (TextView) findViewById(R.id.address);
        //获取activity传来的数据
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        //用id查找联系人
        ContactTable ct=new ContactTable(this);
        user =ct.getUserById(id);
        //显示联系人信息
        nameEditText.setText("姓名："+user.getName());
        mobileEditText.setText("电话："+user.getMobile());
        qqEditText.setText("qq："+user.getQq());
        danweiEditText.setText("单位："+user.getDanwei());
        addressEditText.setText("地址："+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
