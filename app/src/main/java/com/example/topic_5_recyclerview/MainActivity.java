package com.example.topic_5_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.topic_5_recyclerview.Adapters.ContactsAdapter;
import com.example.topic_5_recyclerview.models.Contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        //create a list of Contacts
        List<Contacts>contactsList = new ArrayList<>();
        contactsList.add(new Contacts("Bhuwan Kc","9843384828",R.drawable.bhuwan));
        contactsList.add(new Contacts("/DayaHang Rai","9843889899",R.drawable.daya));
        contactsList.add(new Contacts("Rajesh Hamal","9851047529",R.drawable.rajesh));
        contactsList.add(new Contacts(" Saugat Malla","9851047529",R.drawable.saugat));
        contactsList.add(new Contacts("PasangLakpa Sherpa","9851047529",R.drawable.pasanglakpsherpa));

        //pass list to  the adapter class
        ContactsAdapter contactsAdapter = new ContactsAdapter(this,contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
