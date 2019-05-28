package hoangviet.ndhv.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView GvHinhAnh;
ArrayList<HinhAnh>arrayHinhAnh;
HinhAnhAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new HinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayHinhAnh);
        GvHinhAnh.setAdapter(adapter);
    }

    private void Anhxa() {
        GvHinhAnh = (GridView)findViewById(R.id.GridviewHinhAnh);
        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 1",R.drawable.androidmot));
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 2",R.drawable.androidhai));
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 3",R.drawable.androidba));
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 4",R.drawable.androidsau));
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 5",R.drawable.androidbon));
        arrayHinhAnh.add(new HinhAnh("Hình ảnh 6",R.drawable.a));


    }
}
