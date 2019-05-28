package hoangviet.ndhv.progressbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ProgressBar pGB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        btn = (Button)findViewById(R.id.button);
        pGB = (ProgressBar) findViewById(R.id.progressBar);
        // code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(100000,200) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        pGB.setMax(1000);
                        int temp = pGB.getProgress();
                        if (temp >= pGB.getMax()){
                            temp = 0 ;
                        }
                        pGB.setProgress(temp + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "hoàn thành", Toast.LENGTH_SHORT).show();
                    }
                };
            countDownTimer.start();
            }
        });
    }
}
