package com.example.fazal.codingchalenge.Communication.rest;

import com.example.fazal.codingchalenge.Models.response.WorkerResponse;

/**
 * Interface definition for Callback to be invoked when data received from server
 */
public interface IUserDataHandler {

    /**
     * Callback to be invoked when {@linkplain WorkerResponse} received from server
     *
     * @param response The {@linkplain WorkerResponse} object.
     */
    void onWorkerFetched(WorkerResponse response);

    /**
     * Callback to be invoked when error occur.
     *
     * @param error The error message
     */
    void onError(String error);
}
