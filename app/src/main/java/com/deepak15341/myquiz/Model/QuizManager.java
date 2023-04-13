package com.deepak15341.myquiz.Model;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.deepak15341.myquiz.Controller.CardStackAdapter;
import com.deepak15341.myquiz.MainActivity;
import com.deepak15341.myquiz.R;
import com.deepak15341.myquiz.VolleySingleton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue mrequestQueue;
    private String URL;
    private Context mContext;
    public QuizManager(Context context) {
        mContext = context;
        mrequestQueue = VolleySingleton.getInstance().getRequestQueue();
        URL = "https://opentdb.com/api.php?amount=10&category=9&type=boolean";


    }

    public void getQuizQuestions(Activity activity){

        List<QuizQuestion> quizQuestions = new ArrayList<>() ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("responce", response+"");

                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int index = 0; index <results.length() ; index++) {
                        JSONObject questionJsonObject = results.getJSONObject(index);
                        String questionText = questionJsonObject.getString("question");
                        Boolean questionAnswer = questionJsonObject.getBoolean("correct_answer");

                        QuizQuestion myQuestion = new QuizQuestion(questionText,questionAnswer);
                        quizQuestions.add(myQuestion);
                    }

                   CardStackView myCardStackView = activity.findViewById(R.id.myCardStackView);
                    myCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    myCardStackView.setAdapter(new CardStackAdapter(mContext,quizQuestions));
                } catch (JSONException e) {
                     e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mrequestQueue.add(jsonObjectRequest);

    }
}
