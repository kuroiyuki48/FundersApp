package com.example.funderapps.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendationResp {

    @SerializedName("data")
    @Expose
    private List<RecommendationResult> RecommendationResults = null;

    public List<RecommendationResult> getRecommendationResults() {
        return RecommendationResults;
    }

    public void setRecommendationResults(List<RecommendationResult> recommendationResults) {
        RecommendationResults = recommendationResults;
    }

    public RecommendationResp(List<RecommendationResult> recommendationResults) {
        RecommendationResults = recommendationResults;
    }
}
