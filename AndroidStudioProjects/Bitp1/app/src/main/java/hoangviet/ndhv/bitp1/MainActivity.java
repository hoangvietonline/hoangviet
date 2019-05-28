package hoangviet.ndhv.bitp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView Gv;
ArrayList<HinhAnh> arrayHinhAnh;
HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new HinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayHinhAnh);
        Gv.setAdapter(adapter);
    }

    private void Anhxa() {
        Gv = (GridView)findViewById(R.id.gridViewHinhanh);
        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh("Hinh anh 1",R.drawable.androidmot));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 2",R.drawable.androidhai));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 3",R.drawable.androidba));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 4",R.drawable.androidbon));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 5",R.drawable.androidnam));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 6",R.drawable.androidsau));
        arrayHinhAnh.add(new HinhAnh("Hinh anh 7",R.drawable.a));
    }
}
