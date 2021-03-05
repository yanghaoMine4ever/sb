package com.github.sb.web.exp;

public interface SbExceptionHandler<T> {

    T handle(Exception exception);

}
