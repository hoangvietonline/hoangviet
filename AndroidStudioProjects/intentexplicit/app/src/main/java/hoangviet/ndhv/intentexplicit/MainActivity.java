package hoangviet.ndhv.intentexplicit;

import android.content.Intent;
import android.os.Parcelable;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                String [] arraymonhoc = {"toan" ," li" , "Hoa" ,"cong dan"};
                Hocsinh hocsinh = new Hocsinh("Hoang Tinh",22);
                Bundle bundle =  new Bundle();
                bundle.putString("ten","Hoang Viet");
                bundle.putInt("so",12345);
                bundle.putStringArray("array",arraymonhoc);
                bundle.putSerializable("hocsinh",hocsinh);
                intent.putExtra("dulieu",bundle);
                startActivity(intent);

            }
        });


        }
}
