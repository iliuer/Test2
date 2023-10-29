package com.example.onlyofmy;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class view2_fragment extends Fragment {

   SearchView searchView;
   RecyclerView recyclerView1,recyclerView2;
   ImageView imageView;
   View view2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view2=inflater.inflate(R.layout.view2_fragment, container, false);
        recyclerView1=view2.findViewById(R.id.RecycerViewP2_1);
        recyclerView2=view2.findViewById(R.id.RecycerViewP2_2);
        List<String> messages2=new ArrayList<>(); // 用列表插入数据，数据过多时会用滚动效果
        messages2.add("国际盲人节：身处暗夜，便用心传递光明");
        messages2.add("叫你写好高中议论文开头结尾");
        messages2.add("句子合集·不想面对周一？");
        messages2.add("披星戴月走过的路，最终将会繁华遍地");
        messages2.add("我数了数今夜的星·明月装饰了我的窗子");
        MyAdapter myAdapter2=new MyAdapter(getContext(), messages2);
        // 实现列表滚动效果
        List<String> messages1=new ArrayList<>();
        messages1.add("我的");
        MyAdapter myAdapter1=new MyAdapter(getContext(), messages1);
        recyclerView1.setAdapter(myAdapter2);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(manager1);

        recyclerView2.setAdapter(myAdapter2);
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(manager2);

        return view2;
    }
}