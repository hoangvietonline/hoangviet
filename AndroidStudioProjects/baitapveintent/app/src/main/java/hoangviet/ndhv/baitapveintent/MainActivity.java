package hoangviet.ndhv.baitapveintent;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static hoangviet.ndhv.baitapveintent.R.menu.menu;

public class MainActivity extends AppCompatActivity {
ImageView imgGoc,imgNhan;
int REQUEST_CODE = 1 ;
String tenHinhGoc = "";
public static ArrayList<String> arrayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGoc = (ImageView)findViewById(R.id.imageGoc);
        imgNhan = (ImageView)findViewById(R.id.imageNhan);


        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        // tron mang

        Collections.shuffle(arrayName);
        tenHinhGoc = arrayName.get(4);
        int idHinh = getResources().getIdentifier(arrayName.get(4),"drawable",getPackageName());
        imgGoc.setImageResource(idHinh);

        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,imageActivity.class);
                startActivityForResult(intent,REQUEST_CODE);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if ( requestCode == REQUEST_CODE && resultCode == RESULT_OK && data !=null){
            String tenHinhNhan = data.getStringExtra("tenHinhChon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan,"drawable",getPackageName());
            imgNhan.setImageResource(idHinhNhan);
            if (tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(this, "Chính xác", Toast.LENGTH_SHORT).show();

                //doi hinh khi chinh xác
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayName);
                        tenHinhGoc = arrayName.get(4);
                        int idHinh = getResources().getIdentifier(arrayName.get(4),"drawable",getPackageName());
                        imgGoc.setImageResource(idHinh);

                    }
                }.start();

            }else {
                Toast.makeText(this, "Sai rồi!", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuDoihinh){
            Collections.shuffle(arrayName);
            tenHinhGoc = arrayName.get(4);
            int idHinh = getResources().getIdentifier(arrayName.get(4),"drawable",getPackageName());
            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}
