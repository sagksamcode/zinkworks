package com.atm.zinkworks.zinkworks.exceptions;

public class BadRequestException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private BadRequestException(final Issue issue) {
    super(issue);
  }

  public static BadRequestException invalidPinForAccount() {

    return new BadRequestException(new Issue(IssueEnum.ACCOUNT_PIN_ERROR));
  }

  public static BadRequestException exceededCashRequested() {

    return new BadRequestException(new Issue(IssueEnum.EXCEED_FUNDS));
  }

  public static BadRequestException exceededAtmAmount() {

    return new BadRequestException(new Issue(IssueEnum.EXCEED_FUNDS_ATM));
  }
}
