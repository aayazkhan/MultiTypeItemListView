package com.transo.listviewmultitypeitemview.adpter.viewholder;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.transo.listviewmultitypeitemview.R;
import com.transo.listviewmultitypeitemview.entity.interfaces.EditTextChangeListener;

public class EdittextViewHolder extends ViewHolder {

    private EditText editText;
    private int inputType = InputType.TYPE_CLASS_TEXT;
    private EditTextChangeListener editTextChangeListener;

    public EdittextViewHolder(@NonNull View itemView) {
        super(itemView);
        this.editText = itemView.findViewById(R.id.edittext);
        setInputType(this.inputType);
    }

    public EdittextViewHolder(@NonNull View itemView, int inputType, EditTextChangeListener editTextChangeListener) {
        super(itemView);
        this.editText = itemView.findViewById(R.id.edittext);
        setInputType(inputType);
        setEditTextChangeListener(editTextChangeListener);
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
        this.editText.setInputType(inputType);
    }

    public void setText(String text) {
        this.editText.setText(text);
    }

    public void setEditTextChangeListener(EditTextChangeListener textChangeListener) {
        this.editTextChangeListener = textChangeListener;
        this.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                editTextChangeListener.onTextChangeListener(editable, getAdapterPosition());
            }
        });
    }

    public void setOnFocusChangeListener(Context context) {
        this.editText.setOnFocusChangeListener((view, b) -> {
            if (!b) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }
}
