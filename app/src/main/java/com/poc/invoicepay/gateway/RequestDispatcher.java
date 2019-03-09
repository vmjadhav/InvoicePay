package com.poc.invoicepay.gateway;

import com.poc.invoicepay.models.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestDispatcher {

    @Headers({"Content-Type: application/json"})
    @POST("api/v1/portal/upi2/pay-request")
    public Call<ResponseData> payToVPA(@Body Post post);

}
