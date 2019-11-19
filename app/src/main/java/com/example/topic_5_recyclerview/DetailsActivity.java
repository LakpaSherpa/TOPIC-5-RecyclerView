package com.example.topic_5_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView imgProfile;
    TextView tvName, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imgProfile = findViewById(R.id.imgProfile);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);

        Bundle bundle = getIntent().getExtras();




        if(bundle!=null){
            imgProfile.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPhone.setText(bundle.getString("phone"));
        }
    }
}
