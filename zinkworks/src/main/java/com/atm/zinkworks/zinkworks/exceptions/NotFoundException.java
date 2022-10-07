package com.atm.zinkworks.zinkworks.exceptions;

public class NotFoundException extends GlobalException{

    private static final long serialVersionUID = 1L;

    protected NotFoundException(final Issue issue){
        super(issue);
    }

    public static NotFoundException notFoundAccount() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_ACCOUNT));
    }

}
