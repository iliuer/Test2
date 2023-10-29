package com.example.onlyofmy;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessControlContext;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    List<String> list1;
    Context context1;
    public MyAdapter(Context context,List<String> list ) {
        context1 = context;
        list1 = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context1,R.layout.item,null);
//        View view= LayoutInflater.from(context1).inflate(R.layout.item,parent,false);
        MyHolder myHolder = new MyHolder(view);
        myHolder.setIsRecyclable(false);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(list1.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(context1,MainText.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("name",holder.textView.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(context1,intent,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
    // 获取个数
        return list1.size();
    }
    public String getItemText(@NonNull MyHolder holder, int position){
        return list1.get(position);
        // 获取当前位置数据
    }
    class MyHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView17);
        }
    }
}
