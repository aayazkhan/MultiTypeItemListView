package com.transo.listviewmultitypeitemview;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.transo.listviewmultitypeitemview.adpter.ListViewAdapter;
import com.transo.listviewmultitypeitemview.adpter.MultiChoiceAdapter;
import com.transo.listviewmultitypeitemview.entity.ButtonListRow;
import com.transo.listviewmultitypeitemview.entity.EditTextListRow;
import com.transo.listviewmultitypeitemview.entity.ListRow;
import com.transo.listviewmultitypeitemview.entity.Question;
import com.transo.listviewmultitypeitemview.entity.SpinnerListRow;
import com.transo.listviewmultitypeitemview.entity.interfaces.EditTextChangeListener;
import com.transo.listviewmultitypeitemview.entity.interfaces.NoClickListner;
import com.transo.listviewmultitypeitemview.entity.interfaces.SpinnerChangeListener;
import com.transo.listviewmultitypeitemview.entity.interfaces.YesClickListner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppCompatButton buttonSubmit;
    private ArrayList<Question> questions;
    private ListViewAdapter listViewAdapter;

    private String[] questionStrings1 = new String[]{"YES", "NO", "OTHERS"};
    private String[] questionStrings2 = new String[]{"Available", "Not Available", "OTHERS"};

    private String[] spinnerStrings1 = new String[]{"SELECT", "YES", "NO", "OTHERS"};
    private String[] spinnerStrings2 = new String[]{"SELECT", "Available", "Not Available", "OTHERS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        buttonSubmit = findViewById(R.id.btnSubmit);

        questions = new ArrayList<Question>();

        inilize();

        listViewAdapter = new ListViewAdapter(getApplicationContext(), questions);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(listViewAdapter);

        buttonSubmit.setOnClickListener(view -> {

            boolean flagNext = true;

            for (Question question : questions) {
                if (question instanceof ButtonListRow) {
                    ButtonListRow buttonListRow = (ButtonListRow) question;
                    flagNext = buttonListRow.getResponse() == null || buttonListRow.getResponse().equals("") ? false : true;
                } else if (question instanceof SpinnerListRow) {
                    SpinnerListRow spinnerListRow = (SpinnerListRow) question;
                    flagNext = spinnerListRow.getResponse() == null || spinnerListRow.getSelectionPosition() == 0 ? false : true;
                } else if (question instanceof EditTextListRow) {
                    EditTextListRow editTextListRow = (EditTextListRow) question;
                    flagNext = editTextListRow.getResponse() == null || editTextListRow.getResponse().equals("") ? false : true;
                }

                if (!flagNext) {
                    break;
                }
            }

            if (flagNext) {
                for (int i = 0; i < questions.size(); i++) {
                    System.out.println("i=" + i);
                    System.out.println("questions.get(i).getResponse()=" + questions.get(i).getResponse());
                    System.out.println("==========================================================================================");
                }
            }
        });

    }

    private void inilize() {
        ButtonListRow buttonListRow1 = new ButtonListRow("Question 1", yesClickListner, noClickListner, questionStrings1, questionStrings1);
        buttonListRow1.setShowYesSingleChoice(true);
        buttonListRow1.setShowNoSingleChoice(true);

        ButtonListRow buttonListRow2 = new ButtonListRow("Question 4", yesClickListner, noClickListner, questionStrings2, questionStrings2);
        buttonListRow2.setShowYesMultipleChoice(true);
        buttonListRow2.setShowNoMultipleChoice(true);

        ButtonListRow buttonListRow3 = new ButtonListRow("Question 7", yesClickListner, noClickListner, null, null);

        ButtonListRow buttonListRow4 = new ButtonListRow("Question 10", yesClickListner, noClickListner, questionStrings2, questionStrings2);
        buttonListRow4.setShowYesSingleChoice(true);
        buttonListRow4.setShowNoMultipleChoice(true);

        ButtonListRow buttonListRow5 = new ButtonListRow("Question 13", yesClickListner, noClickListner, questionStrings1, questionStrings1);
        buttonListRow5.setShowYesMultipleChoice(true);
        buttonListRow5.setShowNoSingleChoice(true);

        SpinnerListRow spinnerListRow1 = new SpinnerListRow("Question 2", new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerStrings1), 0, spinnerChangeListener);
        SpinnerListRow spinnerListRow2 = new SpinnerListRow("Question 5", new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerStrings2), 0, spinnerChangeListener);
        SpinnerListRow spinnerListRow3 = new SpinnerListRow("Question 8", new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerStrings1), 0, spinnerChangeListener);
        SpinnerListRow spinnerListRow4 = new SpinnerListRow("Question 11", new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerStrings2), 0, spinnerChangeListener);
        SpinnerListRow spinnerListRow5 = new SpinnerListRow("Question 14", new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerStrings1), 0, spinnerChangeListener);

        EditTextListRow editTextListRow1 = new EditTextListRow("Question 3", InputType.TYPE_CLASS_TEXT, editTextChangeListener);
        EditTextListRow editTextListRow2 = new EditTextListRow("Question 6", InputType.TYPE_CLASS_NUMBER, editTextChangeListener);
        EditTextListRow editTextListRow3 = new EditTextListRow("Question 9", InputType.TYPE_CLASS_TEXT, editTextChangeListener);
        EditTextListRow editTextListRow4 = new EditTextListRow("Question 12", InputType.TYPE_CLASS_NUMBER, editTextChangeListener);
        EditTextListRow editTextListRow5 = new EditTextListRow("Question 15", InputType.TYPE_CLASS_TEXT, editTextChangeListener);

        questions.add(buttonListRow1);
        questions.add(spinnerListRow1);
        questions.add(editTextListRow1);

        questions.add(buttonListRow2);
        questions.add(spinnerListRow2);
        questions.add(editTextListRow2);

        questions.add(buttonListRow3);
        questions.add(spinnerListRow3);
        questions.add(editTextListRow3);

        questions.add(buttonListRow4);
        questions.add(spinnerListRow4);
        questions.add(editTextListRow4);

        questions.add(buttonListRow5);
        questions.add(spinnerListRow5);
        questions.add(editTextListRow5);
    }

    private final YesClickListner yesClickListner = new YesClickListner() {

        private int listViewPosition;
        private ButtonListRow buttonListRow;
        private String selectedItem = "";

        @Override
        public void onItemClick(View v, int listViewPosition) {
            this.listViewPosition = listViewPosition;
            this.buttonListRow = (ButtonListRow) questions.get(this.listViewPosition);

            if (this.buttonListRow.isShowYesSingleChoice()) {
                showSingleChoiceListDialog();
            } else if (this.buttonListRow.isShowYesMultipleChoice()) {
                showMultipleChoiceListDialog();
            } else {
                this.buttonListRow.setResponse("Y");
                listViewAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void showSingleChoiceListDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String[] yesArrayStrings = buttonListRow.getYesArrayStrings();

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, yesArrayStrings);

            builder.setAdapter(stringArrayAdapter, (dialogInterface, i) -> {
                dialogInterface.dismiss();
                String value = yesArrayStrings[i];
                if (value.equalsIgnoreCase("others")) {
                    this.selectedItem = value;
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|Y" + "-" + value);
                    listViewAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                this.buttonListRow.setResponse("");
                listViewAdapter.notifyDataSetChanged();
            });

            builder.setCancelable(false);
            builder.show();


        }

        @Override
        public void showMultipleChoiceListDialog() {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String[] yesArrayStrings = buttonListRow.getYesArrayStrings();

            ArrayList<ListRow> listRows = new ArrayList<ListRow>();

            for (String s : yesArrayStrings) {
                listRows.add(new ListRow(s));
            }

            MultiChoiceAdapter stringArrayAdapter = new MultiChoiceAdapter(MainActivity.this, listRows);

            builder.setAdapter(stringArrayAdapter, null);

            builder.setPositiveButton("SUBMIT", (dialogInterface, i) -> {
                this.selectedItem = "";
                boolean flag = false;
                for (ListRow listRow : listRows) {
                    if (listRow.isFlag()) {
                        if (listRow.getDescription().equalsIgnoreCase("others")) {
                            selectedItem += listRow.getDescription();
                            flag = true;
                        } else {
                            selectedItem += listRow.getDescription() + ", ";
                        }
                    }
                }

                if (flag) {
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|Y" + selectedItem);
                    listViewAdapter.notifyDataSetChanged();
                }

            });

            builder.setCancelable(false);
            builder.show();

        }

        @Override
        public void showRemarkDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Remark");

            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(60, 0, 60, 0);

            EditText editText = new EditText(MainActivity.this);
            editText.setHint("Remark");
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setLines(3);
            editText.setPadding(20, 0, 20, 0);
            editText.setGravity(Gravity.CENTER_VERTICAL);

            linearLayout.addView(editText, layoutParams);
            builder.setView(linearLayout);

            builder.setPositiveButton("SUBMIT", (dialogInterface, i) -> {

                dialogInterface.dismiss();
                String remarkValue = editText.getText().toString().replace("'", "");

                if (remarkValue.equals("")) {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER REMARK", Toast.LENGTH_LONG).show();
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|Y" + this.selectedItem + "-" + remarkValue);
                    listViewAdapter.notifyDataSetChanged();
                }
            });
            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                this.buttonListRow.setResponse("");
                listViewAdapter.notifyDataSetChanged();
            });
            builder.setCancelable(false);
            builder.show();
        }
    };

    private NoClickListner noClickListner = new NoClickListner() {
        private int listViewPosition;
        private ButtonListRow buttonListRow;
        private String selectedItem = "";

        @Override
        public void onItemClick(View v, int listViewPosition) {
            this.listViewPosition = listViewPosition;
            this.buttonListRow = (ButtonListRow) questions.get(this.listViewPosition);
            if (this.buttonListRow.isShowNoSingleChoice()) {
                showSingleChoiceListDialog();
            } else if (this.buttonListRow.isShowNoMultipleChoice()) {
                showMultipleChoiceListDialog();
            } else {
                this.buttonListRow.setResponse("N");
                listViewAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void showSingleChoiceListDialog() {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String[] noArrayStrings = buttonListRow.getNoaArrayStrings();

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, noArrayStrings);

            builder.setAdapter(stringArrayAdapter, (dialogInterface, i) -> {
                dialogInterface.dismiss();
                String value = noArrayStrings[i];
                if (value.equalsIgnoreCase("others")) {
                    this.selectedItem = value;
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|N" + "-" + value);
                    listViewAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                this.buttonListRow.setResponse("");
                listViewAdapter.notifyDataSetChanged();
            });

            builder.setCancelable(false);
            builder.show();

        }

        @Override
        public void showMultipleChoiceListDialog() {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String[] noArrayStrings = buttonListRow.getNoaArrayStrings();

            ArrayList<ListRow> listRows = new ArrayList<ListRow>();

            for (String s : noArrayStrings) {
                listRows.add(new ListRow(s));
            }

            MultiChoiceAdapter stringArrayAdapter = new MultiChoiceAdapter(MainActivity.this, listRows);

            builder.setAdapter(stringArrayAdapter, null);

            builder.setPositiveButton("SUBMIT", (dialogInterface, i) -> {
                this.selectedItem = "";
                boolean flag = false;
                for (ListRow listRow : listRows) {
                    if (listRow.isFlag()) {
                        if (listRow.getDescription().equalsIgnoreCase("others")) {
                            selectedItem += listRow.getDescription();
                            flag = true;
                        } else {
                            selectedItem += listRow.getDescription() + ", ";
                        }
                    }
                }

                if (flag) {
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|Y" + selectedItem);
                    listViewAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                this.buttonListRow.setResponse("");
                listViewAdapter.notifyDataSetChanged();
            });

            builder.setCancelable(false);
            builder.show();

        }

        @Override
        public void showRemarkDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Remark");

            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(60, 0, 60, 0);

            EditText editText = new EditText(MainActivity.this);
            editText.setHint("Remark");
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setLines(3);
            editText.setPadding(20, 0, 20, 0);
            editText.setGravity(Gravity.CENTER_VERTICAL);

            linearLayout.addView(editText, layoutParams);
            builder.setView(linearLayout);

            builder.setPositiveButton("SUBMIT", (dialogInterface, i) -> {

                dialogInterface.dismiss();
                String remarkValue = editText.getText().toString().replace("'", "");

                if (remarkValue.equals("")) {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER REMARK", Toast.LENGTH_LONG).show();
                    showRemarkDialog();
                } else {
                    this.buttonListRow.setResponse("E|N" + this.selectedItem + "-" + remarkValue);
                    listViewAdapter.notifyDataSetChanged();
                }
            });
            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                this.buttonListRow.setResponse("");
                listViewAdapter.notifyDataSetChanged();
            });
            builder.setCancelable(false);
            builder.show();
        }

    };

    private SpinnerChangeListener spinnerChangeListener = new SpinnerChangeListener() {
        private SpinnerListRow spinnerListRow;
        private AdapterView<?> adapterView;
        private int adapterViewPositon;
        private int listViewAdapterPosition;
        private String selectedItem;

        @Override
        public void onChangeListener(AdapterView<?> adapterView, int adapterViewPositon, int listViewAdapterPosition) {

            this.adapterView = adapterView;
            this.adapterViewPositon = adapterViewPositon;
            this.listViewAdapterPosition = listViewAdapterPosition;

            this.spinnerListRow = (SpinnerListRow) questions.get(this.listViewAdapterPosition);

            this.selectedItem = adapterView.getAdapter().getItem(this.adapterViewPositon).toString();

            if (this.selectedItem.equalsIgnoreCase("OTHERS") && !this.spinnerListRow.getResponse().startsWith("OTHERS")) {
                showRemarkDialog();
            } else {
                this.spinnerListRow.setResponse(this.selectedItem);
                this.spinnerListRow.setSelectionPosition(adapterViewPositon);
            }
        }

        public void showRemarkDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Remark");

            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(60, 0, 60, 0);

            EditText editText = new EditText(MainActivity.this);
            editText.setHint("Remark");
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setLines(3);
            editText.setPadding(20, 0, 20, 0);
            editText.setGravity(Gravity.CENTER_VERTICAL);

            linearLayout.addView(editText, layoutParams);
            builder.setView(linearLayout);

            builder.setPositiveButton("SUBMIT", (dialogInterface, i) -> {

                dialogInterface.dismiss();
                String remarkValue = editText.getText().toString().replace("'", "");

                if (remarkValue.equals("")) {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER REMARK", Toast.LENGTH_LONG).show();
                    showRemarkDialog();
                } else {
                    this.spinnerListRow.setResponse(this.selectedItem + "-" + remarkValue);
                    this.spinnerListRow.setSelectionPosition(adapterViewPositon);
                }
            });
            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                spinnerListRow.setResponse("");
                spinnerListRow.setSelectionPosition(0);
                listViewAdapter.notifyDataSetChanged();
            });
            builder.setCancelable(false);
            builder.show();

        }
    };


    private EditTextChangeListener editTextChangeListener = new EditTextChangeListener() {
        @Override
        public void onTextChangeListener(Editable editable, int position) {
            EditTextListRow editTextListRow = (EditTextListRow) questions.get(position);
            editTextListRow.setResponse(editable.toString().replace("'", ""));
        }
    };

}
