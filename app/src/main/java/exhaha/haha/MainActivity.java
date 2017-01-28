package exhaha.haha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    HttpRequestEx httpRequestEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpRequestEx = new HttpRequestEx("http://yangyinetwork.asuscomm.com:82/api/message/");
        sendGet();
    }
    private void sendGet(){
        httpRequestEx.sendGetRequest("hi");
    }


}
