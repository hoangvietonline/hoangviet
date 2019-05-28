package hoangviet.ndhv.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView img;
RelativeLayout manghinh;
ArrayList<Integer> arrayImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        img = (ImageView) findViewById(R.id.img1);
        manghinh = (RelativeLayout) findViewById(R.id.imgBackground);

        // code
        arrayImage = new ArrayList<>();
        arrayImage.add(R.drawable.hinh_3);
        arrayImage.add(R.drawable.hele);
        arrayImage.add(R.drawable.hinh_4);
        arrayImage.add(R.drawable.hinh_7);
        Random random = new Random();
        int vitri = random.nextInt(arrayImage.size());
        manghinh.setBackgroundResource(arrayImage.get(vitri));

    }
}
