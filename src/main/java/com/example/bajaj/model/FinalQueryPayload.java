package com.example.bajaj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinalQueryPayload {

    @JsonProperty("finalQuery")
    private String finalQuery;

    public FinalQueryPayload(String finalQuery) {
        this.finalQuery = finalQuery;
    }

    public String getFinalQuery() {
        return finalQuery;
    }

    public void setFinalQuery(String finalQuery) {
        this.finalQuery = finalQuery;
    }
}