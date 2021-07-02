package com.example.volleyfatchdatafrominternet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.GithubViewHolder> {

    private Context context;
//    private User[] data;
    private GitHubUser[] gitHutHubUserList;

//    public GitHubAdapter(Context context,  ArrayList<GitHubUser>gitHutHubUserList) {
//        this.context = context;
//        this.gitHutHubUserList = gitHutHubUserList;
//    }

/*public GitHubAdapter(Context context,User[] data)
    {
        this.context = context;
        this.data  =data;
    }*/

    public GitHubAdapter(Context context,GitHubUser[] data){
        this.context = context;
        this.gitHutHubUserList = data;
    }


    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubAdapter.GithubViewHolder holder, int position) {

//        User user = data[position];
        GitHubUser user = gitHutHubUserList[position];
        holder.textView.setText(user.getLogin());
        Glide.with(holder.itemView.getContext()).load(user.getAvatar_url()).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
//        Glide.with(holder.imageView.getContext()).load(R.drawable.ic_launcher_foreground).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,user.getLogin()+ "was clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
//        int length = gitHutHubUserList.length;
        return gitHutHubUserList.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public GithubViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_user);
            textView = itemView.findViewById(R.id.text_user);


        }
    }
}
