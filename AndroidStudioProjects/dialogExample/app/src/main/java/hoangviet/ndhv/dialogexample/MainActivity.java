package hoangviet.ndhv.dialogexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lvHinhAnh;
EditText editText;
Button btn,btnC;
ArrayList<String> arrayMonHoc;
ArrayAdapter adapter;
int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        lvHinhAnh=(ListView)findViewById(R.id.listViewHinhAnh);
        editText = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.buttonAdd);
        btnC =(Button)findViewById(R.id.buttonSua);

        lvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(arrayMonHoc.get(position));
                vitri = position;
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayMonHoc.set(vitri,editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        //code

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editText.getText().toString();
                arrayMonHoc.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        arrayMonHoc = new ArrayList<>();
        monhoc();

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayMonHoc);
        lvHinhAnh.setAdapter(adapter);


        lvHinhAnh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xacnhanxoa(position);
                return false;
            }
        });

    }
    private void xacnhanxoa(final int posionti){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Bạn muốn xóa môn học này không?");
        alertdialog.setIcon(R.mipmap.ic_launcher);
        alertdialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayMonHoc.remove(posionti);
                adapter.notifyDataSetChanged();
            }
        });
        alertdialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertdialog.show();
    }
    private void monhoc(){
        arrayMonHoc.add("Javascipt");
        arrayMonHoc.add("PHP");
        arrayMonHoc.add("Android");
        arrayMonHoc.add("IOS");
        arrayMonHoc.add("java");
        arrayMonHoc.add("C#");
    }

}
