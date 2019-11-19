package com.example.topic_5_recyclerview.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import com.example.topic_5_recyclerview.DetailsActivity;
import com.example.topic_5_recyclerview.R;
import com.example.topic_5_recyclerview.models.Contacts;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    Context mContext;
    List<Contacts> contactsList;

    //constructor to receive data from the activity

    public ContactsAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        return new  ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int i ){
        final  Contacts contacts = contactsList.get(i);
        holder.tvName.setText(contacts.getName());
        holder.tvPhone.setText(contacts.getPhoneNo());
        holder.imgProfile.setImageResource(contacts.getImageId());
        //adding click listener to an imageview
        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);

                intent.putExtra("image",contacts.getImageId());
                intent.putExtra("name",contacts.getName());
                intent.putExtra("phone",contacts.getPhoneNo());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgProfile;
        TextView tvName, tvPhone;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);

        }
    }

}
