package com.example.test8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class BookAdapter8_2 extends ArrayAdapter<Book8_2> {
    private int resourceId;

    public BookAdapter8_2(Context context, int textViewResourceId, List<Book8_2> books){
        super(context,textViewResourceId,books);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        Book8_2 book=getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView bookName=(TextView) view.findViewById(R.id.test);
        bookName.setText(book.getName()+book.getPrice()+book.getCategory_id());
        return view;
    }
}
