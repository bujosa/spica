package com.bujosa.spica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bujosa.spica.entity.Menu;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Spica);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new MenuAdapter(Menu.generateMenu(), this));
    }
}

class MenuAdapter extends BaseAdapter {

    List<Menu> menus;
    Context context;

    public MenuAdapter(List<Menu> menus, Context context){
        this.menus = menus;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return menus.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Menu menu = menus.get(i);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.menu_item, viewGroup, false);
        }
        CardView cardView = view.findViewById(R.id.cardView);
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        textView.setText(menu.getDescription());
        imageView.setImageResource(menu.getResourceImageView());
        cardView.setOnClickListener(view1 -> context.startActivity(new Intent(context, menu.getClase())));

        return view;
    }
}