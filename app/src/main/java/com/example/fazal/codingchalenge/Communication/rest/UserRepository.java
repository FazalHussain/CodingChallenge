package com.example.fazal.codingchalenge.Communication.rest;

import android.content.Context;

import com.example.fazal.codingchalenge.Communication.IResponseCallback;
import com.example.fazal.codingchalenge.Models.response.WorkerResponse;

public class UserRepository {
    private Context context;
    private IUserDataHandler userDataHandler;
    private static UserRepository userRepository = new UserRepository();
    private RestRequestHandler restRequestHandler;

    private UserRepository() {
        restRequestHandler = new RestRequestHandler();
    }

    public static UserRepository getInstance() {
        return userRepository;
    }

    /**
     * Request for workers data.
     *
     * @param context Holding the reference of an activity.
     * @param iUserDataHandler callback to be invoked when API Call initiate.
     */
    public void requestWorkers(Context context, IUserDataHandler iUserDataHandler) {
        userDataHandler = iUserDataHandler;
        restRequestHandler.getWorkers(context, mDataHandler);
    }

    private IResponseCallback mDataHandler = new IResponseCallback() {

        @Override
        public void onSuccess(Object object) {
            String className = object.getClass().getSimpleName();
            if (userDataHandler != null) {
                switch (className) {
                    case "WorkerResponse": {
                        userDataHandler.onWorkerFetched((WorkerResponse) object);
                        break;
                    }
                }
            }
        }

        @Override
        public void onError(String error, int errorCode) {
            userDataHandler.onError(error);
        }

    };
}
