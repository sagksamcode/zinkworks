package com.atm.zinkworks.zinkworks.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IllegalFormatException;

public enum IssueEnum {

    BAD_REQUEST_ERROR(1, "Bad Request."),
    MALFORMED_REQUEST_PAYLOAD(2, "Malformed request data."),
    NOT_FOUND_ACCOUNT(3, "Account not found"),
    ACCOUNT_PIN_ERROR(4, "Pin incorrect for this account"),
    EXCEED_FUNDS(5, "Amount requested exceeds account funds"),

    EXCEED_FUNDS_ATM(6, "ATM machine doesn't have funds to withdraw that amount");

    private int code;
    private String message;

    private final Logger logger = LogManager.getLogger(IssueEnum.class);

    IssueEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getFormattedMessage(final Object... args) {
        if (message == null) {
            return "";
        }

        try {
            return String.format(message, args);
        } catch (final IllegalFormatException e) {
            logger.warn(e.getMessage(), e);
            return message.replace("%s", "");
        }
    }
}
