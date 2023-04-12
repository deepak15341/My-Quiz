package com.deepak15341.myquiz.Model;

public class QuizQuestion {

    private String QuestionText;

    private  boolean trueAnswer;

    public QuizQuestion(String questionText, boolean trueAnswer) {
        QuestionText = questionText;
        this.trueAnswer = trueAnswer;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
