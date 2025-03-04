package com.github.fmatt.formbuilder.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    private String text;

    @Column(name = "question_order")
    private Integer questionOrder;

    @ManyToOne
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;


}
