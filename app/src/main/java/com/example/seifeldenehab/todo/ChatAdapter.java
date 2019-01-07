package com.example.seifeldenehab.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    List<MessageModel> messages;

    public ChatAdapter(ArrayList<MessageModel> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chat_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageModel item=messages.get(position);
        holder.message.setText(item.getMessage());
        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if(messages==null)
            return 0;

        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, message;

        public ViewHolder(View v){
            super(v);
            message=v.findViewById(R.id.messageTextView);
            name=v.findViewById(R.id.nameTextView);

        }
    }
}
