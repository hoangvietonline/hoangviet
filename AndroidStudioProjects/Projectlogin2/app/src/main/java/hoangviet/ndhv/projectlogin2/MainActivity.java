package hoangviet.ndhv.projectlogin2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{
    ImageView imageView;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageHinhAnh);


        ImageButton btn = findViewById(R.id.btnAddImage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();
            }
        });
    }

    private void SelectImage(){
        final CharSequence[] items = {"Camera","Gallery","Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thêm hình ảnh");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (items[i].equals("Camera")){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);


                }else if (items[i].equals("Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent,SELECT_FILE);
                }else if (items[i].equals("Cannel")){
                    dialog.dismiss();
                } 
            }
        });
        builder.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_CAMERA);
        }else
        {
            Toast.makeText(this, "ko chon camera", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK && data !=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }

//        if (resultCode == RESULT_OK){
//            if (requestCode == REQUEST_CAMERA){
//                Bitmap bmp = (Bitmap)data.getExtras().get("data");
//                imageView.setImageBitmap(bmp);
//
//            }else if (requestCode == SELECT_FILE){
//                Uri selectedImageUri = data.getData();
//                Bitmap bitmap = null;
//                try {
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImageUri);
//                    imageView.setImageBitmap(bitmap);
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        switch (requestCode){
//            case 0:
//                if (requestCode == RESULT_OK){
//                    Uri selectedImage = data.getData();
//                    imageView.setImageURI(selectedImage);
//                }
//                break;
//            case 1:
//                if (requestCode == RESULT_OK){
//                    Uri selectedImage = data.getData();
//                    imageView.setImageURI(selectedImage);
//                }
//                break;
//        }
        super.onActivityResult(requestCode,resultCode,data);
    }

}
