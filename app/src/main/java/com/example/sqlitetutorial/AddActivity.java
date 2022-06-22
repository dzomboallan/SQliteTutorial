package com.example.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  title, author, pages;
    Button add;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = new MyDatabaseHelper(AddActivity.this);

        title = findViewById(R.id.title_input);
        author = findViewById(R.id.author_input);
        pages = findViewById(R.id.pages_input);
        add = findViewById(R.id.add_button);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch( view.getId()){
            case R.id.add_button:{
                db.AddBook(title.getText().toString().trim(), author.getText().toString().trim(),
                        Integer.valueOf(pages.getText().toString().trim()));
            }

        }
    }
}