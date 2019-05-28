package hoangviet.ndhv.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayMonhoc ;
    EditText editText;
    Button btn,btnCN;
    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        btnCN = (Button)findViewById(R.id.buttonCapNhat);
        editText =(EditText)findViewById(R.id.editText);
        btn =(Button)findViewById(R.id.button) ;
        listView = (ListView) findViewById(R.id.listView);
        arrayMonhoc = new ArrayList<>();
        arrayMonhoc.add("Toán");
        arrayMonhoc.add("Tin Học");
        arrayMonhoc.add("Hóa Học");
        arrayMonhoc.add("anh văn");
        arrayMonhoc.add("Ngữ Văn");
        arrayMonhoc.add("Vật Lý");
//        arrayMonhoc.add("Mỹ thuật");
//        arrayMonhoc.add("Địa lí");
//        arrayMonhoc.add("Lịch sử");
//        arrayMonhoc.add("thể dục");
//        arrayMonhoc.add("công dân");
//        arrayMonhoc.add("cộng nghệ");
//        arrayMonhoc.add("Quốc Phòng");
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayMonhoc);
        listView.setAdapter(adapter);
        // sự kiên click
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                //i trả về vị trí click trên listview giá trị bắt đầu 0
//                Toast.makeText(MainActivity.this,arrayMonhoc.get(i), Toast.LENGTH_SHORT).show();
//            }
//        });
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View v) {
                String monHoc = editText.getText().toString();
                arrayMonhoc.add(monHoc);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                editText.setText(arrayMonhoc.get(i));
                viTri = i;
            }
        });
        btnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayMonhoc.set(viTri,editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayMonhoc.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
