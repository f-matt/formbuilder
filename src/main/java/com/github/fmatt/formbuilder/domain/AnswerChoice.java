package com.github.fmatt.formbuilder.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_choices")
public class AnswerChoice extends BaseEntity {

    private String text;

    @Column(name = "answer_choice_order")
    private Integer answerChoiceOrder;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getAnswerChoiceOrder() {
        return answerChoiceOrder;
    }

    public void setAnswerChoiceOrder(Integer answerChoiceOrder) {
        this.answerChoiceOrder = answerChoiceOrder;
    }
}
