package com.rish.scratch;

public enum TypeEnum {

    ANY("any"),
    ALL("all");

    private String literal;

    TypeEnum() {
    }

    TypeEnum(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}
