package hoangviet.ndhv.readcontentinternetasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new readContextWeb().execute("https://www.facebook.com/");
    }
    private class readContextWeb extends AsyncTask<String, Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            // sử dụng stringBuider dùng để chứa các dữ liệu nớ đọc được, append nhiều lần thay vì dùng string chỉ gán có 1 lần
            StringBuilder stringBuilder = new StringBuilder();
            try {
                //khai báo đường dẫn, 1 đường dẫn dùng strings[0]
                URL url = new URL(strings[0]);
                // tạo URLConnection để mở kết nối
                URLConnection urlConnection = url.openConnection();
                // lấy dữ liệu từ URLConnection trên
                InputStream inputStream = urlConnection.getInputStream();
                // hỗ trợ đọc dữ liệu đầu vào
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                // BufferedReader để đọc dữ liệu liên tục
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // kiểm tra đọc dữ liệu
                String line ="";
                while ((line = bufferedReader.readLine())!=null){
                    stringBuilder.append(line + "\n");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //stringBuilder là kiểu chuỗi nên phải có .toString()
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
