package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddBookActivity8_2 extends AppCompatActivity {

    private MyDatabaseHelper8_2 dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add8_2);
        dbHelper = new MyDatabaseHelper8_2(this,"Library.db",null,1);

//        ContentValues values = new ContentValues();
//        values.put("category_name","经济学");
//        values.put("category_code",1);
//        db.insert("Category",null,values);
//        values.clear();
//        values.put("category_name","文学");
//        values.put("category_code",2);
//        db.insert("Category",null,values);
        Button add =(Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                TextView name=(TextView) findViewById(R.id.name);
                TextView author=(TextView) findViewById(R.id.author);
                TextView price=(TextView) findViewById(R.id.price);
                TextView pages=(TextView) findViewById(R.id.pages);
                TextView category_id=(TextView) findViewById(R.id.category_id);
                db.execSQL("insert into Book (name,author,pages,price,category_id) values (?,?,?,?,?)",
                        new String[]{name.getText().toString(),author.getText().toString(),pages.getText().toString(),
                        price.getText().toString(),category_id.getText().toString()});
            }
        });

    }
}