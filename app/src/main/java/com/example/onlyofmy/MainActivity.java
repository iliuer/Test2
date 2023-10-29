package com.example.onlyofmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.onlyofmy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    Fragment view1_fragment,view2_fragment,view3_fragment,view4_fragment,view5_fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater()); // 获取主页面
        View view=mainBinding.getRoot();  // 初始化
        setContentView(view);  // 将内容切换为主页面
        view1_fragment=new view1_fragment();
        view2_fragment=new view2_fragment();
        view3_fragment=new view3_fragment();
        view4_fragment=new view4_fragment();
        view5_fragment=new view5_fragment();
        fragmentManager=getSupportFragmentManager();  // 页面控制
        initial(); // 初始化函数
        fragmentTransaction=fragmentManager.beginTransaction().show(view1_fragment);         // 初始化为第一个页面
        fragmentTransaction.commit(); // 提交
        // 现在设计点击切换页面效果  设置监听器
        mainBinding.View1LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_hide();
                fragmentTransaction=fragmentManager.beginTransaction().show(view1_fragment);
                fragmentTransaction.commit();
            }
        });
        mainBinding.View2LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_hide();
                fragmentTransaction=fragmentManager.beginTransaction().show(view2_fragment);
                fragmentTransaction.commit();
            }
        });
        mainBinding.View3LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_hide();
                fragmentTransaction=fragmentManager.beginTransaction().show(view3_fragment);
                fragmentTransaction.commit();
            }
        });
        mainBinding.View4LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_hide();
                fragmentTransaction=fragmentManager.beginTransaction().show(view4_fragment);
                fragmentTransaction.commit();
            }
        });
        mainBinding.View5LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_hide();
                fragmentTransaction=fragmentManager.beginTransaction().show(view5_fragment);
                fragmentTransaction.commit();
            }
        });
    }

    private void fragment_hide() {  // 隐藏函数，将各个页面放在show的后面
        fragmentTransaction=fragmentManager.beginTransaction()
                .hide(view1_fragment)
                .hide(view2_fragment)
                .hide(view3_fragment)
                .hide(view4_fragment)
                .hide(view5_fragment);
        fragmentTransaction.commit();
    }


    private void initial() {
        // 添加组件，获取id 保存 最后进行页面覆盖
        fragmentTransaction=fragmentManager.beginTransaction()
                .add(R.id.content,view1_fragment)
                .add(R.id.content,view2_fragment)
                .add(R.id.content,view3_fragment)
                .add(R.id.content,view4_fragment)
                .add(R.id.content,view5_fragment);
        fragmentTransaction.commit();
        fragment_hide();
    }
}