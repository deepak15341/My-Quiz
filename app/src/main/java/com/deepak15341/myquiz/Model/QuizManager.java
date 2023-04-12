package com.deepak15341.myquiz.Model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.deepak15341.myquiz.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue mrequestQueue;
    private String URL;
    public QuizManager() {

        mrequestQueue = VolleySingleton.getInstance().getRequestQueue();
        URL = "https://opentdb.com/api.php?amount=10&category=9&type=boolean";

    }

    public List<QuizQuestion> getQuizQuestions(){

        List<QuizQuestion> quizQuestions = new ArrayList<>() ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int index = 0; index <results.length() ; index++) {
                        JSONObject questionJsonObject = results.getJSONObject(index);
                        String questionText = questionJsonObject.getString("question");
                        Boolean questionAnswer = questionJsonObject.getBoolean("correct_answer");

                        QuizQuestion myQuestion = new QuizQuestion(questionText,questionAnswer);
                        quizQuestions.add(myQuestion);
                    }
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
        return quizQuestions;
    }
}
