package com.example.onlyofmy;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@SuppressLint("UseSwitchCompatOrMaterialCode")
public class view1_fragment extends Fragment {
    Switch aSwitch1;  // 设置开关
    RecyclerView recyclerView;  // 设置循环迭代器
    View view1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent1 = new Intent(view1_fragment.this,MainText.class);
//        view1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent1);
//                Bundle bundle=new Bundle();
//                bundle.putString("name","xx");
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view1= inflater.inflate(R.layout.view1_fragment, container, false);
        aSwitch1= (Switch) view1.findViewById(R.id.switch1);
        aSwitch1.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)
                Toast.makeText(view1.getContext(),"准备开始学习！",Toast.LENGTH_LONG).show();

            else Toast.makeText(view1.getContext(),"脑子里奇怪的知识又增长了",Toast.LENGTH_LONG).show();
        }); // 针对switch开关做响应

        recyclerView=view1.findViewById(R.id.RecyclerViewP1);
        List<String>messages=new ArrayList<>(); // 用列表插入数据，数据过多时会用滚动效果
        messages.add("国际盲人节：身处暗夜，便用心传递光明");
        messages.add("叫你写好高中议论文开头结尾");
        messages.add("句子合集·不想面对周一？");
        messages.add("披星戴月走过的路，最终将会繁华遍地");
        messages.add("我数了数今夜的星·明月装饰了我的窗子");
        messages.add("不止一次，我感喟亲情之色");
        messages.add("搦管书国事，勒笔铸时章");
        messages.add("message1");
        messages.add("message2");
        messages.add("message3");
        messages.add("message4");
        messages.add("message5");
        messages.add("message4");
        messages.add("message3");
        messages.add("message2");
        messages.add("message1");
        messages.add("message2");


        MyAdapter myAdapter=new MyAdapter(getContext(),messages);
        // 实现列表滚动效果
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
        return view1;
    }
}