package com.transo.listviewmultitypeitemview.entity;

import android.widget.ArrayAdapter;

import com.transo.listviewmultitypeitemview.entity.interfaces.NoClickListner;
import com.transo.listviewmultitypeitemview.entity.interfaces.YesClickListner;

public class ButtonListRow extends Question {

    private YesClickListner yesClickListner;
    private NoClickListner noClickListner;

    private String[] yesArrayStrings;
    private String[] noaArrayStrings;

    private boolean showYesSingleChoice = false;
    private boolean showYesMultipleChoice = false;

    private boolean showNoSingleChoice = false;
    private boolean showNoMultipleChoice = false;

    public ButtonListRow(String question, YesClickListner yesClickListner, NoClickListner noClickListner, String[] yesArrayStrings, String[] noaArrayStrings) {
        super(question);
        setYesClickListner(yesClickListner);
        setNoClickListner(noClickListner);
        setYesArrayStrings(yesArrayStrings);
        setNoaArrayStrings(noaArrayStrings);
    }

    public YesClickListner getYesClickListner() {
        return yesClickListner;
    }

    public void setYesClickListner(YesClickListner yesClickListner) {
        this.yesClickListner = yesClickListner;
    }

    public NoClickListner getNoClickListner() {
        return noClickListner;
    }

    public void setNoClickListner(NoClickListner noClickListner) {
        this.noClickListner = noClickListner;
    }

    public String[] getYesArrayStrings() {
        return yesArrayStrings;
    }

    public void setYesArrayStrings(String[] yesArrayStrings) {
        this.yesArrayStrings = yesArrayStrings;
    }

    public String[] getNoaArrayStrings() {
        return noaArrayStrings;
    }

    public void setNoaArrayStrings(String[] noaArrayStrings) {
        this.noaArrayStrings = noaArrayStrings;
    }

    public boolean isShowYesSingleChoice() {
        return showYesSingleChoice;
    }

    public void setShowYesSingleChoice(boolean showYesSingleChoice) {
        this.showYesSingleChoice = showYesSingleChoice;
    }

    public boolean isShowYesMultipleChoice() {
        return showYesMultipleChoice;
    }

    public void setShowYesMultipleChoice(boolean showYesMultipleChoice) {
        this.showYesMultipleChoice = showYesMultipleChoice;
    }

    public boolean isShowNoSingleChoice() {
        return showNoSingleChoice;
    }

    public void setShowNoSingleChoice(boolean showNoSingleChoice) {
        this.showNoSingleChoice = showNoSingleChoice;
    }

    public boolean isShowNoMultipleChoice() {
        return showNoMultipleChoice;
    }

    public void setShowNoMultipleChoice(boolean showNoMultipleChoice) {
        this.showNoMultipleChoice = showNoMultipleChoice;
    }
}
