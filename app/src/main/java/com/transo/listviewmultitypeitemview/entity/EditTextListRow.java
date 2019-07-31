package com.transo.listviewmultitypeitemview.entity;

import android.text.InputType;

import com.transo.listviewmultitypeitemview.entity.interfaces.EditTextChangeListener;

public class EditTextListRow extends Question {

    private int inputType = InputType.TYPE_CLASS_TEXT;
    private EditTextChangeListener editTextChangeListener;

    public EditTextListRow(String question, int inputType, EditTextChangeListener editTextChangeListener) {
        super(question);
        this.inputType = inputType;
        this.editTextChangeListener = editTextChangeListener;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    public EditTextChangeListener getEditTextChangeListener() {
        return editTextChangeListener;
    }

    public void setEditTextChangeListener(EditTextChangeListener editTextChangeListener) {
        this.editTextChangeListener = editTextChangeListener;
    }

}
