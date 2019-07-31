package com.transo.listviewmultitypeitemview.entity;

public class Question {

    private String textQuestion, response;


    public Question(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return textQuestion;
    }
}
