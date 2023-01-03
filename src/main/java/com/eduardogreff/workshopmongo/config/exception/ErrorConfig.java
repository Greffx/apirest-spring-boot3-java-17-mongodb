package com.eduardogreff.workshopmongo.config.exception;


import java.time.Instant;


public class ErrorConfig {

    private Integer status;
    private String error;
    private String message;
    private String path;
    private Instant moment;

    public ErrorConfig(Integer status, String error, String message, String path, Instant moment) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.moment = moment;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
}
