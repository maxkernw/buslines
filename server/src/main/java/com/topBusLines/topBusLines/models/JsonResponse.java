package com.topBusLines.topBusLines.models;

public class JsonResponse {
    String message;
    private int status;

    public JsonResponse() {
    }

    public JsonResponse(String message, int status) {
        super();
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
