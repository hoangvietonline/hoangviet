package hoangviet.ndhv.myhoangvietdrawable;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageHinhMario);
        btn= (Button)findViewById(R.id.buttonClip);

        img.setImageLevel(1000);
        final ClipDrawable clipDrawable = (ClipDrawable) img.getDrawable();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int current = clipDrawable.getLevel();
                        if (current >=10000){
                            current = 0;
                        }
                        img.setImageLevel(current + 100);
                        handler.postDelayed(this,50);
                    }
                },200);

            }
        });
    }
}
