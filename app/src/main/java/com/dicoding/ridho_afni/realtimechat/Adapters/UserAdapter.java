package com.dicoding.ridho_afni.realtimechat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dicoding.ridho_afni.realtimechat.MessageActivity;
import com.dicoding.ridho_afni.realtimechat.Model.User;
import com.dicoding.ridho_afni.realtimechat.R;

import java.util.List;

public class  UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

        private Context context;
        private List<User> users;

        public UserAdapter(Context context, List<User> users){
            this.context = context;
            this.users = users;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.view_item, viewGroup, false);
            return new UserAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            final User user = users.get(i);
            viewHolder.username.setText(user.getUsername());
            if (user.getImageURL().equals("default")){
                viewHolder.profile_image.setImageResource(R.drawable.man);

            }else{
                Glide.with(context).load(user.getImageURL()).into(viewHolder.profile_image);
            }

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MessageActivity.class);
                    intent.putExtra("userId", user.getId());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return users.size();
        }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);

        }
    }
}
