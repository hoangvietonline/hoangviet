package hoangviet.ndhv.menuexample;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Button btn,btnDoiMau ;
ConstraintLayout manghinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDoiMau=(Button)findViewById(R.id.buttonDoiMau) ;
        manghinh = (ConstraintLayout)findViewById(R.id.manghinh);
        // dk view cho context mau
        registerForContextMenu(btnDoiMau);


        btn= (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmenu();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Toast.makeText(this, "cái gì đó", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this,"hừ hừ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "hehe", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showmenu(){
        PopupMenu popupMenu = new PopupMenu(this,btn);
        popupMenu.getMenuInflater().inflate(R.menu.menu1,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.them:
                        btn.setTextColor(Color.RED);
                        break;
                    case R.id.xoa:
                        btn.setText("xóa đi");
                        break;
                    case R.id.sua:
                        btn.setTextSize(24);
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        menu.setHeaderTitle("chọn màu nền");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.maudo: manghinh.setBackgroundColor(Color.RED);
            break;
            case R.id.mauvang: manghinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mauxanh: manghinh.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
