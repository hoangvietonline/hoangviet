package hoangviet.ndhv.shareprefenrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn ;
EditText edtName,edtPass;
CheckBox checkBox;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtName.setText(sharedPreferences.getString("taikhoan",""));
        edtPass.setText(sharedPreferences.getString("password",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checkbox",false));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtName.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (user.equals("hoangvietonline")&& pass.equals("220314")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",user);
                        editor.putString("password",pass);
                        editor.putBoolean("checkbox",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("password");
                        editor.remove("checkbox");
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        btn = (Button)findViewById(R.id.button);
        edtName = (EditText)findViewById(R.id.editUser);
        edtPass = (EditText)findViewById(R.id.editPassword);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
    }
}
