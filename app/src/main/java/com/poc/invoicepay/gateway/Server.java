package com.poc.invoicepay.gateway;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.models.Post;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Server {

    private static Server mInstance;
    private static Retrofit.Builder retrofit_builder;

    private Server() {

    }

    public static Server getInstance() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder newRequest = request.newBuilder().header(Constants.API_KEY, Constants.API_KEY_VALUE);
                return chain.proceed(newRequest.build());
            }
        });

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (mInstance == null) {
            mInstance = new Server();
            retrofit_builder = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClientBuilder.build());
        }
        return mInstance;
    }

    public void callOperation(String url, final ServerOperationCompletion listener, Object data) {

        Retrofit retrofit = retrofit_builder.baseUrl(url).build();
        RequestDispatcher dispatcher = retrofit.create(RequestDispatcher.class);
        Call<ResponseData> call = null;

        if (url.equals(Constants.PAY_TO_VPA)) {
            Log.e("Server", "URL=" + url + "calling PayToVPA");
            call = dispatcher.payToVPA(new Post());
        }

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call <ResponseData> call, Response<ResponseData> response) {
                if (response != null) {
                    Log.e("Server", response.toString());
                    listener.onResponseReceived(response.body());
                }
            }

            @Override
            public void onFailure(Call <ResponseData> call, Throwable t) {
                listener.onError(t.getMessage());
                t.printStackTrace();
                Log.e("onFailure", t.getStackTrace().toString());
            }
        });
    }

    public static interface ServerOperationCompletion {

        public void onResponseReceived(ResponseData responseData);

        public void onError(String errorMessage);
    }
}
