package com.ssw.prod.mincer.exceptions;

/**
 *
 * @author m.genova
 * @since 0.1
 */
public class MincerException extends Exception {
    
    protected int code;
    
    public MincerException() {
        super();
        code = -1;
    }
    
    public MincerException(int errorCode) {
        super();
        code = errorCode;
    }
    
    public MincerException(int errorCode, String message) {
        super(message);
        code = errorCode;
    }
    
    public MincerException(int errorCode, String message, Throwable innerException) {
        super(message, innerException);
        code = errorCode;
    }
    
    public MincerException(String message) {
        super(message);
        code = -1;
    }
    
    public MincerException(String message, Throwable innerException) {
        super(message, innerException);
        code = -1;
    }
    
}
