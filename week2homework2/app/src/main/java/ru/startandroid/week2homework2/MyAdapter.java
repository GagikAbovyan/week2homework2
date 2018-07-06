package ru.startandroid.week2homework2;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PostViewHolder>{


    List<Post> list;

    public MyAdapter(List<Post> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        PostViewHolder pvh = new PostViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, final int position) {
           holder.image.setImageResource(list.get(position).getIdPhoto());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   list.remove(position);
                   notifyDataSetChanged();

               }
           });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        ImageView image;
        TextView heartCount;
        ImageButton commentButton;
        TextView comment;
        Button share;
        ImageButton heartButton;
        EditText commentText;
        private static int i;
        public PostViewHolder(View itemView) {

            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            image = itemView.findViewById(R.id.image);
            heartButton = itemView.findViewById(R.id.heartButton);
            commentButton = itemView.findViewById(R.id.commentButton);
            comment = itemView.findViewById(R.id.textCount);
            heartButton = itemView.findViewById(R.id.heartButton);
            share = itemView.findViewById(R.id.share);
            heartCount = itemView.findViewById(R.id.textHeart);
            commentText = itemView.findViewById(R.id.commentText);
            heartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    heartCount.setText(String.valueOf(++i));

                }
            });
            commentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comment.setText(String.valueOf(commentText.getText()));
                    if (comment.getText().length() > 30) {
                        comment.setText("");
                    }
                }
            });
        }
    }
}
