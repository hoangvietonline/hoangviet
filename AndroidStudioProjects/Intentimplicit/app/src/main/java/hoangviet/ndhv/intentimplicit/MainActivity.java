package hoangviet.ndhv.intentimplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView, imageViewmess,imageViewCall ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageViewmess = (ImageView)findViewById(R.id.messageq);
        imageViewCall = (ImageView)findViewById(R.id.imageView2) ;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/hoangviet.nguyendinh.5"));
                startActivity(intent);
            }
        });

        imageViewmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","tôi dang bận,nhắn tin vào luc khác");
                intent.setData(Uri.parse("sms:0792123160"));
                startActivity(intent);
            }
        });
        imageViewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0792123160"));
                startActivity(intent);
            }
        });
    }
}
