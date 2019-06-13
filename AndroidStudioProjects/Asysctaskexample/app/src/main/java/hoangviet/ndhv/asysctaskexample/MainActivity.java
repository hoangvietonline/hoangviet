package hoangviet.ndhv.asysctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button ;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new congViec().execute();
            }
        });
    }
    private class congViec extends AsyncTask<Void,String,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Hoàng Việt bắt đầu nào! \n");
        }

        @Override
        protected String doInBackground(Void... voids) {

            for (int i = 1; i<=5 ;i++){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("hoàn thành xong bước " + i + "\n");
            }
            return "trở thành developer";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.append(values[0]);
        }
    }
}
