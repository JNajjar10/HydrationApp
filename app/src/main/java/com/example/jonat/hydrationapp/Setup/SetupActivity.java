package com.example.jonat.hydrationapp.Setup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jonat.hydrationapp.R;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        EditText weight = findViewById(R.id.userWeightText);
        EditText wakeupTime = findViewById(R.id.wakeUpTimeText);
        EditText sleepTime = findViewById(R.id.sleepTimeText);
        Spinner activityLevel = findViewById(R.id.activityLevelSpinner);
        Button doneButton = findViewById(R.id.doneButton);

        SetupPresenter mSetupPresenter = new SetupPresenter();

    }


}
