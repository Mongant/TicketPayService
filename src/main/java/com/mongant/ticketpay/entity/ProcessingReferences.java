package com.mongant.ticketpay.entity;

import java.util.List;

public class ProcessingReferences {

    private List<String> processingReferences;

    public ProcessingReferences(List<String> processingReferences) {
        this.processingReferences = processingReferences;
    }

    public List<String> getProcessingReferences() {
        return processingReferences;
    }

    public void setProcessingReferences(List<String> processingReferences) {
        this.processingReferences = processingReferences;
    }
}
