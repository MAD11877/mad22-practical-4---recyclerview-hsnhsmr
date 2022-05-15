package sg.edu.np.mad.wk4practical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter
        extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;
    Context c;
    public UserAdapter(Context c, ArrayList<User> data){
        this.c = c;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        User content = data.get(position);
        if (content.Name.charAt(content.Name.length() - 1) == '7')
        {
            return 0;
        }
        else
            return 1;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if (viewType == 1) {
            item = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.user_layout, null, false);
        }
        else
            item = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.user_layout2, parent, false);
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User content = data.get(position);
        holder.Name.setText(content.Name);
        holder.Description.setText(content.Description);
        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(c);
                b.setTitle("Profile");
                b.setMessage(content.Name);
                b.setPositiveButton("view", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(c, MainActivity2.class);
                        intent.putExtra("n", content.Name);
                        intent.putExtra("d", content.Description);
                        c.startActivity(intent);
                    }
                });
                b.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
