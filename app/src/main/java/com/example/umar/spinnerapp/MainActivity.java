package com.example.umar.spinnerapp;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2,spinner3;
    private Button btnSubmit;
    TextView tvModel;
    TextView tvDefect;
    TextView tvName;
    static TextView tvResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addItemsOnSpinner1();
        addItemsOnSpinner2();
        addItemsOnSpinner3();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
      //  addListenerOnSpinner2ItemSelection();
    }

    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> deviceModel = new ArrayList<String>();

        deviceModel.add("SAMSUNG");
        deviceModel.add("APPLE");
        deviceModel.add("HUAWEI");
        deviceModel.add("HTC");
        deviceModel.add("QMOBILE");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, deviceModel);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }



    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> deviceName = new ArrayList<String>();

        deviceName.add("GALAXY S Series");
        deviceName.add("GALAXY J Series");
        deviceName.add("GALAXY A Series");
        deviceName.add("GALAXY C Series");
        deviceName.add("GALAXY Note Series");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, deviceName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }


    public void addItemsOnSpinner3() {

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> deviceIssue = new ArrayList<String>();

        deviceIssue.add("Screen Broken");
        deviceIssue.add("Mic Issue");
        deviceIssue.add("On/Off issue");
        deviceIssue.add("Battery Issue");
        deviceIssue.add("Other Internal Issue");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, deviceIssue);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }








    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());


        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());


    }
    /*public void addListenerOnSpinner2ItemSelection() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }*/
    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);


        tvModel=findViewById(R.id.tvModel);
        tvName=findViewById(R.id.tvName);
        tvDefect=findViewById(R.id.tvDefect);
        tvResult=findViewById(R.id.tvRes);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                tvResult.setText("Device Model :"+String.valueOf(spinner1.getSelectedItem()));

                Toast.makeText(MainActivity.this,
                                "Model : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nName : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}