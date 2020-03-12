package eb.egonb.kamelenraceoefegon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Random;

import eb.egonb.kamelenraceoefegon.util.ProgressHandler;

public class MainActivity extends AppCompatActivity {

    private ProgressBar magicMikePb, sepperayPb, leonairPb;
    private Button btnStartRace;

    private boolean isRunning = false;
    private ProgressHandler mHandler, mHandler2, mHandler3;

    private View.OnClickListener startRaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!isRunning){
                startThread();
            }
            if(!isRunning){
                startThread2();
            }
            if(!isRunning){
                startThread3();
            }
        }
    };

    private void startThread() {
        Thread bgThread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                int max = 10;
                int min = 0;
                for (int i = 0; i <= 20; i++) {
                    int randomGetal = (int) ((Math.random() * max) + 1);
                    try {
                        Thread.sleep(1000/randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        Message msg = new Message();
                        msg.arg1 = i;

                        mHandler.sendMessage(msg);

                    isRunning = false;
                }
            }
        });
        bgThread.start();
    }

    private void startThread2() {
        Thread bgThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                int max = 10;
                int min = 0;
                for (int i = 0; i <= 20; i++) {
                    int randomGetal = (int) ((Math.random() * max) + 1);
                    try {
                        Thread.sleep(1000/randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        Message msg = new Message();
                        msg.arg1 = i;

                        mHandler2.sendMessage(msg);

                    isRunning = false;
                }
            }
        });
        bgThread2.start();
    }
    private void startThread3() {
        Thread bgThread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                isRunning = true;
                int max = 10;
                int min = 0;
                for (int i = 0; i <= 20; i++) {
                    int randomGetal = (int) ((Math.random() * max) + 1);
                    try {
                        Thread.sleep(1000/randomGetal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        Message msg = new Message();
                        msg.arg1 = i;

                        mHandler3.sendMessage(msg);

                    isRunning = false;
                }
            }
        });
        bgThread3.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        magicMikePb = findViewById(R.id.pb_kameel1);
        sepperayPb = findViewById(R.id.pb_kameel2);
        leonairPb = findViewById(R.id.pb_kameel3);

        mHandler = new ProgressHandler(magicMikePb);
        mHandler2 = new ProgressHandler(sepperayPb);
        mHandler3 = new ProgressHandler(leonairPb);

        btnStartRace = findViewById(R.id.btn_start_race);
        btnStartRace.setOnClickListener(startRaceListener);
    }
}
