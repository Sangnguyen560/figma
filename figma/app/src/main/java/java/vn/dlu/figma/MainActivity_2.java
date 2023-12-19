package java.vn.dlu.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_2 extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Delay for 3 seconds and then start the main activity
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        startMainActivity();
                }
        }, 3000); // 3000 milliseconds (3 seconds)

        }

        private void startMainActivity() {
                Intent intent = new Intent(MainActivity_2.this, signin.class);
                startActivity(intent);
                finish(); // finish the splash activity so that it's not in the back stack
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        }}
