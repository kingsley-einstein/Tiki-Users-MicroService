package com.transport.tiki.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@SuppressWarnings("serial")
public class AnException extends RuntimeException implements GraphQLError {

    private Integer errorCode;

    public AnException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> attributes = new LinkedHashMap<>();

        attributes.put("errorCode", errorCode);
        attributes.put("errorMessage", this.getMessage());

        return attributes;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

}