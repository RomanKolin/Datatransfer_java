package com.example.romankolindatatransfer;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class TheToActivity extends AppCompatActivity
{
    TextView textView1from;
    EditText editText1to;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1checkbox1;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch2checkbox2;
    CheckBox checkBox1switch1;
    CheckBox checkBox2switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_second);

        textView1from = findViewById(R.id.textView1from);
        editText1to = findViewById(R.id.editText1to);
        switch1checkbox1 = findViewById(R.id.switch1checkbox1);
        switch2checkbox2 = findViewById(R.id.switch2checkbox2);
        checkBox1switch1 = findViewById(R.id.checkBox1switch1);
        checkBox2switch2 = findViewById(R.id.checkBox2switch2);

        Intent fromact = getIntent();
        textView1from.setText(fromact.getStringExtra("fromeT"));
        switch1checkbox1.setChecked(fromact.getBooleanExtra("fromcB1", false));
        switch2checkbox2.setChecked(fromact.getBooleanExtra("fromcB2", false));
    }

    public void onclickok(View transfer)
    {
        String t = editText1to.getText().toString();
        Boolean tS1 = switch1checkbox1.isChecked();
        Boolean tS2 = switch2checkbox2.isChecked();
        Intent fromact = new Intent();
        fromact.putExtra("toeT", t);
        fromact.putExtra("toS1", tS1);
        fromact.putExtra("toS2", tS2);
        setResult(RESULT_OK, fromact);
        finish();
    }

    public void onclickcancel(View exit)
    {
        finish();
    }
}