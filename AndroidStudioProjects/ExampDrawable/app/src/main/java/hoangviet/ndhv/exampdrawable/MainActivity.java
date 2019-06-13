package hoangviet.ndhv.exampdrawable;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =(ImageView)findViewById(R.id.imageView);
        btn = (Button)findViewById(R.id.buttonImage);
        imageView.setImageLevel(1000);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        int currentLevel = clipDrawable.getLevel();
//                        if (currentLevel>=10000){
//                            currentLevel = 0;
//                        }
//                        imageView.setImageLevel(currentLevel + 500);
//                        handler.postDelayed(this,1000);
//                    }
//                },500);
                CountDownTimer countDownTimer = new CountDownTimer(60000,200) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int currentLevel = clipDrawable.getLevel();
                        if (currentLevel >= 10000){
                            currentLevel = 0;
                        }
                        imageView.setImageLevel(currentLevel + 500);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                countDownTimer.start();


            }
        });


    }
}
