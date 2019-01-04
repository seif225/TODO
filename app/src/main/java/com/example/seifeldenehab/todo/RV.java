package com.example.seifeldenehab.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RV extends RecyclerView.Adapter<RV.ViewHolder> {

    List<Model> model;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item,viewGroup,false);
        return new ViewHolder(itemView);
    }
public RV(List<Model> model){
        this.model=model;

}
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.name.setText(model.get(i).getName());
        viewHolder.mail.setText(model.get(i).getMail());
        viewHolder.score.setText(String.valueOf(model.get(i).getScore()));

        Picasso.get().load(model.get(i).getImage()).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        if(model==null)
            return 0;
        return model.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mail,score,name;
        ImageView image;

        public ViewHolder(View view)
        {
            super(view);
            mail=view.findViewById(R.id.mail);
            name=view.findViewById(R.id.name);
            score=view.findViewById(R.id.score);
            image=view.findViewById(R.id.image);

        }
    }


}
