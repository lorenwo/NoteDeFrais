package com.example.formationapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formationapp.entity.User;
import com.example.formationapp.dao.UserDao;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;
    private ActivityResultLauncher<Intent> editUserActivityResultLauncher;

    public UserAdapter(List<User> userList, Context context, ActivityResultLauncher<Intent> editUserActivityResultLauncher) {
        this.userList = userList;
        this.context = context;
        this.editUserActivityResultLauncher = editUserActivityResultLauncher;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view, editUserActivityResultLauncher);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewNom.setText(user.getNom());
        holder.textViewPrenom.setText(user.getPrenom());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<User> updatedUserList) {
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNom, textViewPrenom;
        ImageView imageViewDelete, imageViewEdit;

        UserViewHolder(View itemView,  ActivityResultLauncher<Intent> editUserActivityResultLauncher) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewPrenom = itemView.findViewById(R.id.textViewPrenom);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
            imageViewEdit = itemView.findViewById(R.id.imageViewEdit);

            imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition() ;
                    User user = userList.get(position);

                   // Create an instance of UserDao
                    UserDao.deleteUser(user.getId());
                    userList.remove(position);
                    notifyItemRemoved(position);
                }
            });

            imageViewEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position =getAdapterPosition() ;
                    User userToEdit = userList.get(position);
                    Intent editIntent = new Intent(context, EditUserActivity.class);

                    editIntent.putExtra("user_id", userToEdit.getId()); // Pass user ID instead of the user object
                    //editIntent.putExtra("user", userToEdit;
                    editUserActivityResultLauncher.launch(editIntent);

imageViewEdit.setOnClickListener(new View.OnClickListener() {
    @Override
public void onClick (View view){
        int position = getAdapterPosition() ;
        User userToEdit = userList.get(position);

        Intent editIntent = new Intent(context, EditUserActivity.class);
        editIntent.putExtra("user.id", userToEdit);
        context.startActivity(editIntent);
        }
});
                }
            })
        ;}
    }
}