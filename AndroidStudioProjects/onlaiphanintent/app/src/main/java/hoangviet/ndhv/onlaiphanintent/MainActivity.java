package hoangviet.ndhv.onlaiphanintent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn,btndulieu,btnChupHinh ;
TextView textView1;
ImageView imageHinh,imagemess,imgAnh;
int REQUEST_CODE = 1;
int REQUEST_CAMERA = 2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,secondactivity.class);
                hocSinh hocSinh =  new hocSinh("hoang viet",23);
                intent.putExtra("dulieu",hocSinh);
                startActivity(intent);
            }
        });
        imageHinh = (ImageView)findViewById(R.id.imagebrowser);
        imageHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });
        imagemess=(ImageView)findViewById(R.id.imageView2);
        imagemess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","chao ban, minh dang ban...");
                intent.setData(Uri.parse("sms:0792123160"));
                startActivity(intent);
            }
        });
        btndulieu = (Button)findViewById(R.id.buttonLayDuLieu);
        textView1 = (TextView)findViewById(R.id.textnhan);
        btndulieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,secondactivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btnChupHinh = (Button)findViewById(R.id.buttonChup);
        imgAnh = (ImageView)findViewById(R.id.imageHinhAnh);
        btnChupHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA && grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_CAMERA);
        }else {
            Toast.makeText(this, "Bạn không chọn camera!", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data!=null){
            String ten = data.getStringExtra("dulieu");
            textView1.setText(ten);
        }
        if (requestCode == REQUEST_CAMERA && resultCode ==  RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgAnh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
