package com.synertone.imitokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.synertone.imitokhttp.net.Call;
import com.synertone.imitokhttp.net.Callback;
import com.synertone.imitokhttp.net.HttpClient;
import com.synertone.imitokhttp.net.Request;
import com.synertone.imitokhttp.net.RequestBody;
import com.synertone.imitokhttp.net.Response;


public class MainActivity extends AppCompatActivity {

    HttpClient client;
    private TextView tv_get_content;
    private TextView tv_post_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_get_content=findViewById(R.id.tv_get_content);
        tv_post_content=findViewById(R.id.tv_post_content);
        client = new HttpClient.Builder().retrys(3).build();
    }


    public void get(View view) {
        Request request = new Request.Builder()
                .url("http://www.kuaidi100.com/query?type=yuantong&postid=222222222")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) {
                Log.e("响应体", response.getBody());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_get_content.setText(response.getBody());
                    }
                });

            }
        });
    }

    public void post(View view) {
        RequestBody body = new RequestBody()
                .add("city", "长沙")
                .add("key", "13cb58f5884f9749287abbead9c658f2");
        Request request = new Request.Builder().url("http://restapi.amap" +
                ".com/v3/weather/weatherInfo").post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) {
                Log.e("响应体", response.getBody());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_post_content.setText(response.getBody());
                    }
                });

            }
        });
    }
}
