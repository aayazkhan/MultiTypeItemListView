package com.transo.listviewmultitypeitemview.entity.interfaces;

import android.view.View;

public interface YesClickListner {
    void onItemClick(View v, int position);

    void showSingleChoiceListDialog();

    void showMultipleChoiceListDialog();

    void showRemarkDialog();
}
