package com.github.fmatt.formbuilder.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "form_responses")
public class FormResponse extends BaseEntity {

    @Column(name = "response_timestamp")
    private LocalDateTime responseTimestamp;

    @Size(max = 50)
    private String login;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    public LocalDateTime getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(LocalDateTime responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
