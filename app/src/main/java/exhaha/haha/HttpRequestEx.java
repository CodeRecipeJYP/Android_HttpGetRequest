package exhaha.haha;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;

/**
 * Created by JYP on 2017. 1. 28..
 */

public class HttpRequestEx {

    private String urlString;
    private String message = "";
    private String TAG = "AAA";


    public HttpRequestEx(String urlString){
        this.urlString = urlString;
    }

    public void sendGetRequest(String message){
        this.message = message;
        getThread.start();
    }
    public Thread getThread = new Thread() {
        @Override
        public void run() {
            HttpClient httpClient = new DefaultHttpClient();

            String reqUriString = urlString;
            String reqMessage = message;
            try{
                URI uri = new URI(reqUriString + reqMessage);
                HttpGet httpGet = new HttpGet();
                httpGet.setURI(uri);

                HttpResponse response = httpClient.execute(httpGet);
                String reponseString = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);

                Log.d(TAG, reponseString);
            }catch (URISyntaxException e){
                Log.e(TAG, e.getLocalizedMessage());
                e.printStackTrace();
            }catch (ClientProtocolException e){
                Log.e(TAG, e.getLocalizedMessage());
                e.printStackTrace();
            }catch (IOException e){
                Log.e(TAG, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    };
}
