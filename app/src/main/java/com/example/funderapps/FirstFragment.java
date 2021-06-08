package com.example.funderapps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funderapps.network.ApiClient;
import com.example.funderapps.network.ApiInterface;
import com.example.funderapps.network.response.RecommendationResp;
import com.example.funderapps.network.response.RecommendationResult;
import com.example.funderapps.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private RecyclerAdapter adapter;
    private SharedPrefManager SharedPrefManager;
    private Context mContext;

    private ApiInterface apiInterface = null;
    private List<RecommendationResult> reccommended = new ArrayList<>();

    @BindView(R.id.rv_recommended)
    RecyclerView rv_recommended;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        ButterKnife.bind(this, view);
        rv_recommended.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            reccommended = savedInstanceState.getParcelableArrayList("data");
            prepareView();
        } else {
            getRecommendation();
        }

//        ItemClickSupport.addTo(rv_recommended).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                showDetailMovie(nowPlayMovies.get(position).getMovieId());
//            }
//        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("data", new ArrayList<>(adapter.getRecommended()));
    }

    private void prepareView() {
        adapter = new RecyclerAdapter(getActivity(), reccommended);
        rv_recommended.setAdapter(adapter);
    }

    private void getRecommendation() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        SharedPrefManager = new SharedPrefManager(getActivity());

        Call<RecommendationResp> call = apiInterface.getRecommendation(SharedPrefManager.getSPToken());

        call.enqueue(new Callback<RecommendationResp>() {
            @Override
            public void onResponse(Call<RecommendationResp> call, Response<RecommendationResp> response) {
                if (response.isSuccessful()) {
                    reccommended = response.body().getRecommendationResults();
                    if (reccommended != null) {
                        adapter = new RecyclerAdapter(getActivity(), reccommended);
                        rv_recommended.setAdapter(adapter);
                    } else {
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<RecommendationResp> call, Throwable t) {

            }
        });

    }

//    private void showDetailMovie(int movie_id) {
//        String local = "0";
//        Intent movieIdIntent = new Intent(getActivity(), DetailMoviesActivity.class);
//        movieIdIntent.putExtra(DetailMoviesActivity.MOVIE_ID, movie_id);
//        movieIdIntent.putExtra(DetailMoviesActivity.LOCAL_STATUS, local );
//        getActivity().startActivity(movieIdIntent);
//    }
}