package com.fls.calc;

class IncorrectFileExtensionException extends Exception {
    
    public IncorrectFileExtensionException() {
        super("Incorrect file extension");
    }

    public IncorrectFileExtensionException(String message) {
        super(message);
    }
}
