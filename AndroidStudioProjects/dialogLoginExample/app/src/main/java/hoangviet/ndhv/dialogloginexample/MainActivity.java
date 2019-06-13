package hoangviet.ndhv.dialogloginexample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDongY,btnHuy;
    EditText edtName,edtPass;
    TextView txtclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtclick = (TextView)findViewById(R.id.clickme);
        txtclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diglogNotify();
            }
        });
    }
    private void diglogNotify(){
        final Dialog dialog = new Dialog(this);
        // phải đặt dialog.requestWindowFrature trên dialog.setContentView
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.diglognotify);
        // click vào bên ngoài dialog không làm mất dialog
        dialog.setCanceledOnTouchOutside(false);
        // ánh xạ
        btnDongY = (Button)dialog.findViewById(R.id.buttonOk);
        btnHuy = (Button)dialog.findViewById(R.id.buttoncannel);
        edtName =(EditText)dialog.findViewById(R.id.editTextName);
        edtPass = (EditText)dialog.findViewById(R.id.editTextPass);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtName.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (ten.equals("Hoang Viet") && pass.equals("300196")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
//                dialog.dismiss();
            }
        });
        dialog.show();
    }


}
