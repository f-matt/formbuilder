package com.github.fmatt.formbuilder.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Column(name = "text_answer")
    private String textAnswer;

    @Column(name = "boolean_answer")
    private Boolean booleanAnswer;

    @ManyToOne
    @JoinColumn(name = "form_response_id")
    private FormResponse formResponse;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_choice_id")
    private AnswerChoice answerChoice;

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Boolean getBooleanAnswer() {
        return booleanAnswer;
    }

    public void setBooleanAnswer(Boolean booleanAnswer) {
        this.booleanAnswer = booleanAnswer;
    }

    public FormResponse getFormResponse() {
        return formResponse;
    }

    public void setFormResponse(FormResponse formResponse) {
        this.formResponse = formResponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerChoice getAnswerChoice() {
        return answerChoice;
    }

    public void setAnswerChoice(AnswerChoice answerChoice) {
        this.answerChoice = answerChoice;
    }
}
