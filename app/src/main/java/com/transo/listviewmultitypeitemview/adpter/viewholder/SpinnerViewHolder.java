package com.transo.listviewmultitypeitemview.adpter.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.transo.listviewmultitypeitemview.R;
import com.transo.listviewmultitypeitemview.entity.interfaces.SpinnerChangeListener;

public class SpinnerViewHolder extends ViewHolder {

    private Spinner spinner;
    private BaseAdapter adpter;
    private SpinnerChangeListener spinnerChangeListener;
    private int sectionPosition = 0;

    public SpinnerViewHolder(@NonNull View itemView) {
        super(itemView);
        spinner = itemView.findViewById(R.id.spinner);
    }

    public SpinnerViewHolder(@NonNull View itemView, BaseAdapter adpter, int sectionPosition, SpinnerChangeListener spinnerChangeListener) {
        super(itemView);
        this.spinner = itemView.findViewById(R.id.spinner);
        this.sectionPosition = sectionPosition;
        setAdpter(adpter);
    }

    public void setAdpter(BaseAdapter adpter) {
        this.adpter = adpter;
        this.spinner.setAdapter(adpter);
    }

    public void setSpinnerChangeListener(SpinnerChangeListener changeListener) {
        this.spinnerChangeListener = changeListener;
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int adapterViewPositon, long l) {
                spinnerChangeListener.onChangeListener(adapterView, adapterViewPositon, getAdapterPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void setSectionPosition(int sectionPosition) {
        this.sectionPosition = sectionPosition;
        this.spinner.setSelection(this.sectionPosition);
    }
}
