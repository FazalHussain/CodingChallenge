package com.example.fazal.codingchalenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.fazal.codingchalenge.Communication.rest.IUserDataHandler;
import com.example.fazal.codingchalenge.Communication.rest.UserRepository;
import com.example.fazal.codingchalenge.Models.data.Items;
import com.example.fazal.codingchalenge.Models.response.WorkerResponse;
import com.example.fazal.codingchalenge.UI.helper.WorkerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindFloat;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private UserRepository repository;

    private LinearLayoutManager mLayoutManager;


    @BindView(R.id.workerRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    List<Items> itemsList = new ArrayList<>();
    private WorkerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        repository = UserRepository.getInstance();

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new WorkerAdapter(this, itemsList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.VISIBLE);
        repository.requestWorkers(this, userDataHandler);
    }

    /**
     * Callback to be invoked when api response received.
     */
    private IUserDataHandler userDataHandler = new IUserDataHandler() {
        @Override
        public void onWorkerFetched(WorkerResponse response) {
            if (response != null) {
                itemsList.addAll(response.getData().getItems());
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onError(String error) {
            Log.d(TAG, getString(R.string.error_message));
            progressBar.setVisibility(View.INVISIBLE);
        }
    };
}
