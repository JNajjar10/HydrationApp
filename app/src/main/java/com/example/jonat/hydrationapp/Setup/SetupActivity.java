package com.example.jonat.hydrationapp.Setup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jonat.hydrationapp.DatabaseHelper;
import com.example.jonat.hydrationapp.R;

public class SetupActivity extends AppCompatActivity {
    private static final String TAG = SetupActivity.class.getName();
    DatabaseHelper myDb;
    SetupPresenter mSetupPresenter;
    EditText weight;
    EditText wakeupTime;
    EditText sleepTime;
    Spinner activityLevel;
    Button doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        weight = findViewById(R.id.userWeightText);
        wakeupTime = findViewById(R.id.wakeUpTimeText);
        sleepTime = findViewById(R.id.sleepTimeText);
        activityLevel = findViewById(R.id.activityLevelSpinner);
        doneButton = findViewById(R.id.doneButton);

        mSetupPresenter = new SetupPresenter();
        myDb = new DatabaseHelper(this);
    }

    public void addData() {
        doneButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInsereted = myDb.insertData(weight.getText().toString(),
                                wakeupTime.getText().toString(), sleepTime.getText().toString(),
                                activityLevel.getSelectedItem().toString());
                       if (isInsereted == true) {
                           Log.d(TAG, "onClick: data has been added to SQLite");
                       } else {
                           Log.d(TAG, "onClick: data not added to SQLite")
                       }
                    }
                }
        );
    }


}
