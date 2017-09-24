package com.guozhe.android.spinner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Data> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glid);
        gridView = (GridView)findViewById(R.id.gridView);
        datas = Loader.getData();
        GridAdapter adapter= new GridAdapter(this,datas);
        gridView.setAdapter(adapter);
    }
}
class GridAdapter extends BaseAdapter{
    ArrayList<Data> datas;
    Context context;
    LayoutInflater inflater;
    public GridAdapter(Context context,ArrayList<Data> datas){
        this.datas = datas;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = inflater.inflate(R.layout.item_custom_grid,null);
            holder = new Holder();
            holder.textView = (TextView)view.findViewById(R.id.textView);
            holder.imageView = (ImageView)view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else {
            holder =(Holder)view.getTag();
        }
        Data data = datas.get(i);
        int suffix = (data.getNo()%5)+1;
        int id = context.getResources().getIdentifier("images"+suffix,"mipmap",context.getPackageName());
        holder.imageView.setImageResource(id);
        holder.textView.setText(data.getTitle());
        return view;
    }
    class Holder{
        public TextView textView;
        public ImageView imageView;
    }
}

