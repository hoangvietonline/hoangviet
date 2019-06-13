package hoangviet.ndhv.animationalphaexamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView, imageRotale, imagescale, imgTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView1);
        imageRotale = (ImageView)findViewById(R.id.imageView2);
        imagescale = (ImageView)findViewById(R.id.imageView3);
        imgTranslate = (ImageView)findViewById(R.id.imageView4);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
            }
        });
        final Animation animation1 =  AnimationUtils.loadAnimation(this,R.anim.anim_rotale);
        imageRotale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation1);
            }
        });
        final Animation animationscale =  AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        imagescale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationscale);
            }
        });
        final Animation animationtranslate = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationtranslate);
            }
        });
    }
}
