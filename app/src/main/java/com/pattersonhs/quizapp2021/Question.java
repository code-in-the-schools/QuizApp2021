package com.pattersonhs.quizapp2021;

public class Question {

    // instance variables
    String questionText;
    boolean questionCorrectAnswer;
    String hint;

    // constructor with just text and answer
    public Question(String questionText, boolean questionCorrectAnswer) {
        this.questionText = questionText;
        this.questionCorrectAnswer = questionCorrectAnswer;
        this.hint = "No hint found";
        // this above is bad form but getting string from OO class
        // is very difficult without Android Activity Context;
        // one possibility: we could switch the type to an int as the resource ID
        // (for both the qText and the hint); will leave hard-coded for now
    }

    //overloaded constructor with text, answer, and hint
    public Question(String questionText, boolean questionCorrectAnswer, String hint) {
        this.questionText = questionText;
        this.questionCorrectAnswer = questionCorrectAnswer;
        this.hint = hint;
    }

    // getters and setters
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String newQuestionText) {
        this.questionText = newQuestionText;
    }
    public boolean getQuestionCorrectAnswer() {
        return questionCorrectAnswer;
    }
    public void setQuestionCorrectAnswer(boolean newCorrectAnswer) {
        this.questionCorrectAnswer = newCorrectAnswer;
    }
    public String getHint() {
        return hint;
    }
    public void setHint(String newHint) {
        this.hint = newHint;
    }
}
