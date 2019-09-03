package com.arkham.internfinalchat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkham.internfinalchat.MessageActivity;
import com.arkham.internfinalchat.Model.User;
import com.arkham.internfinalchat.R;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mContent;
    private List<User> mUsers;

    public UserAdapter(Context mContent, List<User> mUsers){
        this.mUsers = mUsers;
        this.mContent = mContent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user = mUsers.get(position);
        holder.username.setText(user.getUsername());
        if(user.getImageUrl().equals("default")){
            holder.profile_images.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(mContent).load(user.getImageUrl()).into(holder.profile_images);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContent, MessageActivity.class);
                intent.putExtra("userid", user.getId());
                mContent.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView username;
        public ImageView profile_images;

        public ViewHolder(View itemView){
            super(itemView);
            username = itemView.findViewById(R.id.username);
            profile_images = itemView.findViewById(R.id.profile_images);
        }
    }
}
