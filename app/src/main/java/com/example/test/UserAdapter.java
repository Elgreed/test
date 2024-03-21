package com.example.test;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }


    // Внутри onBindViewHolder метода в UserAdapter
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tvFullName.setText(user.getFullName());
        holder.tvEmail.setText(user.getEmail());
        holder.tvPhone.setText(user.getPhone());

    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFullName, tvEmail, tvPhone;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}