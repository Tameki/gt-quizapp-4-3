package com.geektech.quizapp_gt_3.data.remote;

import com.geektech.core.CoreCallback;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements IQuizApiClient {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private QuizApi client = retrofit.create(QuizApi.class);

    @Override
    public void getQuestions(final QuestionsCallback callback) {
        Call<QuestionsResponse> call = client.getQuestions(10);

        call.enqueue(new CoreCallback<QuestionsResponse>() {
            @Override
            public void onSuccess(QuestionsResponse result) {
                callback.onSuccess(result.getResults());
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }

    private interface QuizApi {
        @GET("/api.php")
        Call<QuestionsResponse> getQuestions(
                @Query("amount") int amount
        );
    }
}
