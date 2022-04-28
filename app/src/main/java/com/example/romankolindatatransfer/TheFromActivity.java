package com.example.romankolindatatransfer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class TheFromActivity extends AppCompatActivity
{
    EditText editText1from;
    CheckBox checkBox1switch1;
    CheckBox checkBox2switch2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1checkbox1;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch2checkbox2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_first);

        editText1from = findViewById(R.id.editText1from);
        checkBox1switch1 = findViewById(R.id.checkBox1switch1);
        checkBox2switch2 = findViewById(R.id.checkBox2switch2);
        switch1checkbox1 = findViewById(R.id.switch1checkbox1);
        switch2checkbox2 = findViewById(R.id.switch2checkbox2);
    }

    public void onclicktransfernewwindow(View transfer)
    {
        String freT = editText1from.getText().toString();
        Boolean frcB1 = checkBox1switch1.isChecked();
        Boolean frcB2 = checkBox2switch2.isChecked();
        Intent toact = new Intent(this, TheToActivity.class);
        toact.putExtra("fromeT", freT);
        toact.putExtra("fromcB1", frcB1);
        toact.putExtra("fromcB2", frcB2);
        startActivityForResult(toact, 1);

        editText1from.setText("");
    }

    @Override
    protected void onActivityResult(int reqcod, int rescod, @Nullable Intent toact)
    {
        if (reqcod == 1)
        {
            if (toact != null)
            {
                String teT = toact.getStringExtra("toeT");
                Boolean tcB1 = toact.getBooleanExtra("toS1", false);
                Boolean tcB2 = toact.getBooleanExtra("toS2", false);
                Toast.makeText(this, teT, Toast.LENGTH_LONG).show();
                checkBox1switch1.setChecked(tcB1);
                checkBox2switch2.setChecked(tcB2);
            }
        }

        super.onActivityResult(reqcod, rescod, toact);
    }

    public void onclicktransferdialog(View transferdialog)
    {
        LayoutInflater transfdial = LayoutInflater.from(this);
        View transferdialogxml = transfdial.inflate(R.layout.transferdialog, null);
        TextView textView1from = transferdialogxml.findViewById(R.id.textView1from);
        EditText editText1dialog = transferdialogxml.findViewById(R.id.editText1dialog);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switch1checkbox1 = transferdialogxml.findViewById(R.id.switch1checkbox1);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switch2checkbox2 = transferdialogxml.findViewById(R.id.switch2checkbox2);

        AlertDialog.Builder transf = new AlertDialog.Builder(this);
        transf.setView(transferdialogxml);
        textView1from.setText(editText1from.getText().toString());
        transf.setPositiveButton("Cancel", ((dialogInterface, canc) -> dialogInterface.cancel()));
        transf.setNegativeButton("OK", ((dialogInterface, ok) ->
        {
            Toast.makeText(this, (editText1dialog.getText().toString()), Toast.LENGTH_LONG).show();
            checkBox1switch1.setChecked(switch1checkbox1.isChecked());
            checkBox2switch2.setChecked(switch2checkbox2.isChecked());
            dialogInterface.cancel();
        }));
        transf.show();
        switch1checkbox1.setChecked(checkBox1switch1.isChecked());
        switch2checkbox2.setChecked(checkBox2switch2.isChecked());

        editText1from.setText("");
    }
    
    public void onclickexit(View exit)
    {
        AlertDialog.Builder ex = new AlertDialog.Builder(this).setTitle("Exit");
        ex.setMessage("Do you wanna leave this app?");
        ex.setPositiveButton("No", ((dialogInterface, n) -> dialogInterface.cancel()));
        ex.setNegativeButton("Yes", ((dialogInterface, y) -> finish()));
        ex.setIcon(R.drawable.exit);
        ex.show();
    }
}