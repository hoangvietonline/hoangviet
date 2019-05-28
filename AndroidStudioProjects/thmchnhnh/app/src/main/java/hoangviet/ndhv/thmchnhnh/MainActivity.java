package hoangviet.ndhv.thmchnhnh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView Gv;
    ArrayList<HinhAnh>arrayHinhAnh;
    hinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new hinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayHinhAnh);
        Gv.setAdapter(adapter);

    }

    private void Anhxa() {
        Gv = (GridView)findViewById(R.id.Gridview);
        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh(R.drawable.a));
        arrayHinhAnh.add(new HinhAnh(R.drawable.androidmot));
        arrayHinhAnh.add(new HinhAnh(R.drawable.androidhai));
        arrayHinhAnh.add(new HinhAnh(R.drawable.androidba));
        arrayHinhAnh.add(new HinhAnh(R.drawable.androidbon));

        arrayHinhAnh.add(new HinhAnh(R.drawable.androidsau));


    }
}
