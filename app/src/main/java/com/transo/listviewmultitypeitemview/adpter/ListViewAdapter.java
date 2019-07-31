package com.transo.listviewmultitypeitemview.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.transo.listviewmultitypeitemview.R;
import com.transo.listviewmultitypeitemview.adpter.viewholder.ButtonViewHolder;
import com.transo.listviewmultitypeitemview.adpter.viewholder.EdittextViewHolder;
import com.transo.listviewmultitypeitemview.adpter.viewholder.SpinnerViewHolder;
import com.transo.listviewmultitypeitemview.adpter.viewholder.ViewHolder;
import com.transo.listviewmultitypeitemview.entity.ButtonListRow;
import com.transo.listviewmultitypeitemview.entity.EditTextListRow;
import com.transo.listviewmultitypeitemview.entity.Question;
import com.transo.listviewmultitypeitemview.entity.SpinnerListRow;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Question> questions = null;
    private Context context;

    public ListViewAdapter(Context context, ArrayList<Question> questions) {
        this.questions = questions;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (questions.get(position) instanceof ButtonListRow) {
            return 0;
        } else if (questions.get(position) instanceof SpinnerListRow) {
            return 1;
        } else if (questions.get(position) instanceof EditTextListRow) {
            return 2;
        }

        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = null;
        ViewHolder viewHolder = null;

        switch (viewType) {
            case 0:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_list_row, parent, false);
                viewHolder = new ButtonViewHolder(itemView);
                break;
            case 1:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_list_row, parent, false);
                viewHolder = new SpinnerViewHolder(itemView);
                break;
            case 2:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittext_list_row, parent, false);
                viewHolder = new EdittextViewHolder(itemView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Question question = questions.get(position);

        if (question instanceof ButtonListRow) {
            handleButtonQuestion((ButtonViewHolder) holder, (ButtonListRow) question);
        } else if (question instanceof SpinnerListRow) {
            handleSpinnerQuestion((SpinnerViewHolder) holder, (SpinnerListRow) question);
        } else if (question instanceof EditTextListRow) {
            handleEdittextQuestion((EdittextViewHolder) holder, (EditTextListRow) question);
        }
    }

    private void handleButtonQuestion(ButtonViewHolder buttonViewHolder, ButtonListRow buttonListRow) {
        buttonViewHolder.setQuestion(buttonListRow.getTextQuestion());
        buttonViewHolder.setYesButtonListener(buttonListRow.getYesClickListner());
        buttonViewHolder.setNoButtonListener(buttonListRow.getNoClickListner());
        buttonViewHolder.setButtonColor(buttonListRow.getResponse(), this.context);
    }

    private void handleSpinnerQuestion(SpinnerViewHolder spinnerViewHolder, SpinnerListRow spinnerListRow) {
        spinnerViewHolder.setQuestion(spinnerListRow.getTextQuestion());
        spinnerViewHolder.setAdpter(spinnerListRow.getArrayAdapter());
        spinnerViewHolder.setSpinnerChangeListener(spinnerListRow.getSpinnerChangeListener());
        spinnerViewHolder.setSectionPosition(spinnerListRow.getSelectionPosition());
    }

    private void handleEdittextQuestion(EdittextViewHolder edittextViewHolder, EditTextListRow editTextListRow) {
        edittextViewHolder.setQuestion(editTextListRow.getTextQuestion());
        edittextViewHolder.setInputType(editTextListRow.getInputType());
        edittextViewHolder.setOnFocusChangeListener(this.context);
        edittextViewHolder.setEditTextChangeListener(editTextListRow.getEditTextChangeListener());
        edittextViewHolder.setText(editTextListRow.getResponse());
    }
}
