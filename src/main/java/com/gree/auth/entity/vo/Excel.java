package com.gree.auth.entity.vo;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/11/12 14:02.
 */
public class Excel {
    private List<String> titles;//表头名
    private List<List<Object>> rows;//表数据（里层list为横向数据，外层为纵向数据）
    private String name;//表名

    public Excel() {
    }

    public Excel(List<String> titles, List<List<Object>> rows, String name) {
        this.titles = titles;
        this.rows = rows;
        this.name = name;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
