package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity8_2 extends AppCompatActivity {

    private MyDatabaseHelper8_2 dbHelper;

    private List<Book8_2> bookList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8_2);
        dbHelper = new MyDatabaseHelper8_2(this,"Library.db",null,1);
        Button add_message = (Button) findViewById(R.id.add_message);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Book",null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                Double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                int category_id=cursor.getInt(cursor.getColumnIndexOrThrow("category_id"));
                Book8_2 book=new Book8_2(name,price,category_id);
                bookList.add(book);
            }while(cursor.moveToNext());
        }
        BookAdapter8_2 adapter=new BookAdapter8_2(MainActivity8_2.this,R.layout.book_item_layout,bookList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        add_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity8_2.this, AddBookActivity8_2.class);
                startActivity(intent);
            }
        });
    }
}