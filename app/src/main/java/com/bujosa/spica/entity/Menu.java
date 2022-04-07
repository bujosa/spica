package com.bujosa.spica.entity;

import com.bujosa.spica.MainActivity;
import com.bujosa.spica.R;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String description;
    private int resourceImageView;
    private Class clase;

    public Menu(String description, int resourceImageView, Class clase) {
        this.description = description;
        this.resourceImageView = resourceImageView;
        this.clase = clase;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getResourceImageView(){
        return resourceImageView;
    }

    public void setResourceImageView(int resourceImageView){
        this.resourceImageView = resourceImageView;
    }

    public Class getClase(){
        return clase;
    }

    public void setClase(Class clase){
        this.clase = clase;
    }

    public static List<Menu> generateMenu(){
        List<Menu> menu = new ArrayList<>();
        menu.add(new Menu("Viajes Disponibles", R.drawable.travel, MainActivity.class));
        menu.add(new Menu("Viajes Seleccionados", R.drawable.travel_selection, MainActivity.class));
        return menu;
    }
}
