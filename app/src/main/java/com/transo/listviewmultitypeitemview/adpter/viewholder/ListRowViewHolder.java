package com.transo.listviewmultitypeitemview.adpter.viewholder;

import android.widget.CheckBox;
import android.widget.TextView;

public class ListRowViewHolder {
    private TextView textView;
    private CheckBox checkBox;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public void setchecked(boolean flag) {
        this.checkBox.setChecked(flag);
    }
}
