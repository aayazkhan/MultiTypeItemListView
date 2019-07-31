package com.transo.listviewmultitypeitemview.entity.interfaces;

import android.widget.AdapterView;

public interface SpinnerChangeListener {
    void onChangeListener(AdapterView<?> adapterView, int adapterViewPositon, int listViewAdapterPosition);

    void showRemarkDialog();
}
