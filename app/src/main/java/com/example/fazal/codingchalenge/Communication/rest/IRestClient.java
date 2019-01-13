package com.example.fazal.codingchalenge.Communication.rest;

import com.example.fazal.codingchalenge.Constants.ApiTags;
import com.example.fazal.codingchalenge.Models.response.WorkerResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;

public interface IRestClient {

    @GET(ApiTags.WORKERS_END_POINT)
    Call<WorkerResponse>  getWorkers(@Header("X-Requested-With") String requestWith,
                                     @Header("Content-Type") String contentType,
                                     @Header("Accept") String accept,
                                     @Header("Authorization") String authorization);
}
