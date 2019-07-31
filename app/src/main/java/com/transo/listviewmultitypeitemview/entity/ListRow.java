package com.transo.listviewmultitypeitemview.entity;

public class ListRow {
    private String description;
    private boolean flag;

    public ListRow(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
