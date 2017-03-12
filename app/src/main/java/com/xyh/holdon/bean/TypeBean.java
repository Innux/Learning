package com.xyh.holdon.bean;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/12.
 */


public class TypeBean {
    public ArrayList<hotWords> tngou;

    public class hotWords {
        public String description;
        public String keywords;
        public String name;
        public String title;
        public int id;
        public int seq;

        @Override
        public String toString() {
            return "hotWords{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TypeBean{" +
                "tngou=" + tngou +
                '}';
    }
}


