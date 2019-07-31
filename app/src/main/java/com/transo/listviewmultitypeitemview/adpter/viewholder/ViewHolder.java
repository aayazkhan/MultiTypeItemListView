package com.transo.listviewmultitypeitemview.adpter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.transo.listviewmultitypeitemview.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textQuestion;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textQuestion = itemView.findViewById(R.id.question);
    }

    public void setQuestion(String question) {
        textQuestion.setText(question);
    }

}
