package hoangviet.ndhv.login;

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
        GvHinhAnh = (GridView)findViewById(R.id.gridViewHinhAnh);
        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh(R.drawable.login1,"Home"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.login2,"Latest"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.login4,"Data Search"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.login5,"Subscribe"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.login6,"My Account"));
    }
}
