package com.example.contact;

import android.os.Bundle;

import com.example.contact.Adapter.CustomAdapter;
import com.example.contact.Model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtPhoneNumber;
    private Button btnAdd;
    private ListView lvContact;
    private CustomAdapter CustomAdapter;
    private  ArrayList<Contact> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWidget();

        arrayList = new ArrayList<>();

        CustomAdapter = new CustomAdapter(this, R.layout.item_contact,arrayList);

        lvContact.setAdapter(CustomAdapter);
    }

    public void setWidget(){
        edtName = (EditText) findViewById(R.id.edtName);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvContact = (ListView) findViewById(R.id.lvContact);
    }

    public void addContact(View view){
        boolean gender = true;
        String name = edtName.getText().toString().trim();
        String phonenumber = edtPhoneNumber.getText().toString().trim();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(phonenumber)){
            Toast.makeText(this,"Vui long nhap ten hoac so dien thoai",Toast.LENGTH_SHORT).show();
        }else {
            Contact contact = new Contact(gender,name,phonenumber);
            arrayList.add(contact);
        }
        CustomAdapter.notifyDataSetChanged();
    }
}
