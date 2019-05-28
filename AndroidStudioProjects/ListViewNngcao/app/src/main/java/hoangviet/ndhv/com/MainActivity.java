package hoangviet.ndhv.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<TraiCay>traiCayArrayList;
traiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new traiCayAdapter(this,R.layout.dong_trai_cay,traiCayArrayList);
        listView.setAdapter(adapter);

    }

    private void Anhxa() {

        listView = (ListView)findViewById(R.id.listView);
        traiCayArrayList = new ArrayList<>();
        traiCayArrayList.add(new TraiCay("Dâu Tây","Dâu tây Quảng Nam",R.drawable.dautay));
        traiCayArrayList.add(new TraiCay("Cam","Cam sành thơm ngon",R.drawable.cam));
        traiCayArrayList.add(new TraiCay("Táo","Táo mỹ tho",R.drawable.apple));
        traiCayArrayList.add(new TraiCay("Xoài","Xoài cát Hòa Lộc",R.drawable.xoai));

    }

}
