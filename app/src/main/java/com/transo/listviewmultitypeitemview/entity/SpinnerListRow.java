package com.transo.listviewmultitypeitemview.entity;

import android.widget.ArrayAdapter;

import com.transo.listviewmultitypeitemview.entity.interfaces.SpinnerChangeListener;

public class SpinnerListRow extends Question {

    private ArrayAdapter<String> arrayAdapter;
    private SpinnerChangeListener spinnerChangeListener;
    private int selectionPosition = 0;

    public SpinnerListRow(String question, ArrayAdapter<String> arrayAdapter, int selectionPosition, SpinnerChangeListener spinnerChangeListener) {
        super(question);
        setArrayAdapter(arrayAdapter);
        setSpinnerChangeListener(spinnerChangeListener);
        setSelectionPosition(selectionPosition);
    }

    public ArrayAdapter<String> getArrayAdapter() {
        return arrayAdapter;
    }

    public void setArrayAdapter(ArrayAdapter<String> arrayAdapter) {
        this.arrayAdapter = arrayAdapter;
        this.arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public SpinnerChangeListener getSpinnerChangeListener() {
        return spinnerChangeListener;
    }

    public void setSpinnerChangeListener(SpinnerChangeListener spinnerChangeListener) {
        this.spinnerChangeListener = spinnerChangeListener;
    }

    public int getSelectionPosition() {
        return selectionPosition;
    }

    public void setSelectionPosition(int selectionPosition) {
        this.selectionPosition = selectionPosition;
    }
}
