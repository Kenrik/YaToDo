package com.kenrikmarch.admin.yetanothertodoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.view.View;


public class EditItemActivity extends ActionBarActivity {

    int REQUEST_CODE = 1337;
    EditText txtItem;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        txtItem = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.btnSave);
        Intent i = getIntent();
        final String details = i.getStringExtra("item");
        final int position = i.getIntExtra("pos", 0);
        txtItem.setText(details);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newString = txtItem.getText().toString();
                finishEdit(newString, position);
            }
        });
    }

    private void finishEdit(String newString, int position) {
        Intent intent = getIntent();
        intent.putExtra("str", newString);
        intent.putExtra("pos", position);
        setResult(REQUEST_CODE, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
