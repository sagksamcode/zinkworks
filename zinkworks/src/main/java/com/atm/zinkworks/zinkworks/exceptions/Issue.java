package com.atm.zinkworks.zinkworks.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Issue {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    private final int code;

    @JsonProperty private final String message;

    @JsonProperty private List<String> details;

    public Issue(final IssueEnum issue) {
        code = issue.getCode();
        message = issue.getFormattedMessage();
    }

    public Issue(final IssueEnum issue, final List<String> details) {

        this(issue);
        this.details = details;
    }

    public Issue(final IssueEnum issue, final Object... args) {
        code = issue.getCode();
        message = issue.getFormattedMessage(args);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {

        return details;
    }

    public void setDetails(List<String> details) {

        this.details = details;
    }
}
