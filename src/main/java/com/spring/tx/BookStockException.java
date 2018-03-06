package com.spring.tx;

/**
 * Created by chenbin on 2018\3\6 0006.
 */
public class BookStockException extends RuntimeException {
    public BookStockException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BookStockException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BookStockException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
