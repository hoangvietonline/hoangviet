package hoangviet.ndhv.listviewlan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay ;
    ArrayList<traiCay> arrayTraiCay;
    traiCayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new traiCayAdapter(this,R.layout.dong_trai_cay,arrayTraiCay);
        lvTraiCay.setAdapter(adapter);

    }

    private void Anhxa() {
        lvTraiCay = (ListView)findViewById(R.id.listViewTraiCay);
        arrayTraiCay = new ArrayList<>();
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));
        arrayTraiCay.add(new traiCay("Dâu","Dâu tây Đà Lạt",R.drawable.dautay));
        arrayTraiCay.add(new traiCay("Cam","Cam sành Nam bộ",R.drawable.cam));
        arrayTraiCay.add((new traiCay("Táo","Táo mỹ",R.drawable.apple)));
        arrayTraiCay.add(new traiCay("Xoài","Xoài cát hòa lộc",R.drawable.xoai));


    }
}
