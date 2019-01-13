package com.example.fazal.codingchalenge.Communication.rest;

import android.content.Context;

import com.example.fazal.codingchalenge.Communication.IResponseCallback;
import com.example.fazal.codingchalenge.Models.response.WorkerResponse;
import com.example.fazal.codingchalenge.R;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class RestRequestHandler {

    private IRestClient mRestClient;

    public void getWorkers(final Context context, final IResponseCallback mDataCallback) {
        mRestClient = RestClient.getClient();
        Call<WorkerResponse> workerResponseCall = mRestClient.getWorkers(
                context.getString(R.string.x_request_with),
                context.getString(R.string.type_json),
                context.getString(R.string.type_json),
                context.getString(R.string.barear_token));
        workerResponseCall.enqueue(new Callback<WorkerResponse>() {
            @Override
            public void onResponse(Response<WorkerResponse> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mDataCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mDataCallback.onError(context.getString(R.string.error_message), 0);
            }
        });
    }
}
