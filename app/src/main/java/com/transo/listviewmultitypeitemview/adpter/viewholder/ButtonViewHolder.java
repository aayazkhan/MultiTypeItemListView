package com.transo.listviewmultitypeitemview.adpter.viewholder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.transo.listviewmultitypeitemview.R;
import com.transo.listviewmultitypeitemview.entity.interfaces.NoClickListner;
import com.transo.listviewmultitypeitemview.entity.interfaces.YesClickListner;

public class ButtonViewHolder extends ViewHolder {

    private android.widget.Button btnYes, btnNo;
    private YesClickListner yesClickListner;
    private NoClickListner noClickListner;

    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.btnYes = itemView.findViewById(R.id.btnYes);
        this.btnNo = itemView.findViewById(R.id.btnNo);
    }

    public ButtonViewHolder(@NonNull View itemView, YesClickListner yesClickListner, NoClickListner noClickListner) {
        super(itemView);
        this.btnYes = itemView.findViewById(R.id.btnYes);
        this.btnNo = itemView.findViewById(R.id.btnNo);

        setYesButtonListener(yesClickListner);
        setNoButtonListener(noClickListner);
    }

    public void setYesButtonListener(YesClickListner listner) {
        this.yesClickListner = listner;
        this.btnYes.setOnClickListener(view -> this.yesClickListner.onItemClick(view, getAdapterPosition()));
    }

    public void setNoButtonListener(NoClickListner listner) {
        this.noClickListner = listner;
        this.btnNo.setOnClickListener(view -> this.noClickListner.onItemClick(view, getAdapterPosition()));
    }

    public void setButtonColor(String response, Context context) {
        if (response != null && !response.equals("")) {
            if (response.startsWith("Y")) {
                btnYes.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
                btnNo.setTextColor(context.getResources().getColor(android.R.color.black));
            } else if (response.startsWith("E|Y")) {
                btnYes.setTextColor(context.getResources().getColor(android.R.color.holo_red_light));
                btnNo.setTextColor(context.getResources().getColor(android.R.color.black));
            } else if (response.startsWith("N")) {
                btnNo.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
                btnYes.setTextColor(context.getResources().getColor(android.R.color.black));
            } else if (response.startsWith("E|N")) {
                btnNo.setTextColor(context.getResources().getColor(android.R.color.holo_red_light));
                btnYes.setTextColor(context.getResources().getColor(android.R.color.black));
            }
        } else {
            btnYes.setTextColor(context.getResources().getColor(android.R.color.black));
            btnNo.setTextColor(context.getResources().getColor(android.R.color.black));
        }
    }
}
