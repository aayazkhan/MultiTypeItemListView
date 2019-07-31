package com.transo.listviewmultitypeitemview.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.transo.listviewmultitypeitemview.R;
import com.transo.listviewmultitypeitemview.adpter.viewholder.ListRowViewHolder;
import com.transo.listviewmultitypeitemview.entity.ListRow;

import java.util.ArrayList;

public class MultiChoiceAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListRow> listRows;

    public MultiChoiceAdapter(Context context, ArrayList<ListRow> listRows) {
        this.context = context;
        this.listRows = listRows;
    }

    @Override
    public int getCount() {
        return listRows.size();
    }

    @Override
    public ListRow getItem(int position) {
        return listRows.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View view, ViewGroup parent) {
        final ListRowViewHolder holder;
        if (view == null) {
            holder = new ListRowViewHolder();
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remark_list_row, parent, false);
            holder.setTextView(view.findViewById(R.id.remarks));
            holder.setCheckBox(view.findViewById(R.id.checkBox));
            view.setTag(holder);
        } else {
            holder = (ListRowViewHolder) view.getTag();
        }

        holder.setText(listRows.get(position).getDescription());
        holder.setchecked(listRows.get(position).isFlag());

        // Listen for ListView Item Click
        view.setOnClickListener(arg0 -> listViewItemOnClick(position));

        // Listen for ListView Item Click
        holder.getCheckBox().setOnClickListener(arg0 -> listViewItemOnClick(position));

        return view;
    }

    private void listViewItemOnClick(int position) {
        if (listRows.get(position).isFlag()) {
            listRows.get(position).setFlag(false);
        } else {
            listRows.get(position).setFlag(true);
        }
        notifyDataSetChanged();
    }
}