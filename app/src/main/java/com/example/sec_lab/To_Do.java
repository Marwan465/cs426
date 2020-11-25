package com.example.sec_lab;

import java.io.Serializable;

public class To_Do implements Serializable {
    private String name;
    private String desc;
    private int IconIndex;

    public To_Do(String name, String desc, int IconIndex) {
        this.name = name;
        this.desc = desc;
        this.IconIndex = IconIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIconIndex() {
        return IconIndex;
    }

    public void setIconIndex(int iconIndex) {
        IconIndex = iconIndex;
    }
}
