package sg.edu.np.mad.wk4practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> data = new ArrayList<>();

        for (int i=0; i<20; i++){
            User u = new User();
            Random r = new Random();
            int randomNo = r.nextInt(10000000+1000000 + 1) - 10000000;
            int randomNo2 = r.nextInt(10000000+1000000 + 1) - 10000000;

            u.Name = "Name" + randomNo;
            u.Description = "Description" + randomNo2;
            data.add(u);
        }

        RecyclerView rv = findViewById(R.id.RecyclerView);
        UserAdapter adapter = new UserAdapter(MainActivity.this, data);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);
    }
}