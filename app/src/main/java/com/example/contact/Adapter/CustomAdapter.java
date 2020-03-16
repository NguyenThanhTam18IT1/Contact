package com.example.contact.Adapter;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.Model.Contact;
import com.example.contact.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private  int resource;
    private ArrayList<Contact> arrContact;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
            viewHolder.imgAvt = (ImageView) convertView.findViewById(R.id.imgAvt);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvPhoneNumber);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrContact.get(position);

        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvPhoneNumber.setText(contact.getmNumber());

        if(contact.isGender()){
            viewHolder.imgAvt.setBackgroundResource(R.drawable.ic_male);
        }else {
            viewHolder.imgAvt.setBackgroundResource(R.drawable.ic_female);
        }

        return convertView;
    }

    public class ViewHolder{
        ImageView imgAvt;
        TextView tvName;
        TextView tvPhoneNumber;
    }
}
