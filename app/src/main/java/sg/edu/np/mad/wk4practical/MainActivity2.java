
package sg.edu.np.mad.wk4practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    User u = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Random r = new Random();
        Button b = findViewById(R.id.follow);
        boolean randomBool = r.nextBoolean();
        u.Followed = randomBool;
        if (u.Followed == true)
            b.setText("Unfollow");
        else
            b.setText("follow");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.follow) {
                    if (u.Followed == false) {
                        u.Followed = true;
                        b.setText("Unfollow");
                        Toast.makeText(MainActivity2.this, "followed", Toast.LENGTH_LONG)
                                .show();
                    } else {
                        u.Followed = false;
                        b.setText("Follow");
                        Toast.makeText(MainActivity2.this, "unfollowed", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });

        Intent intent = getIntent();
        String n = intent.getStringExtra("n");
        TextView name = findViewById(R.id.name);
        name.setText(n);
        String d = intent.getStringExtra("d");
        TextView desc = findViewById(R.id.description);
        desc.setText(d);


    }
}