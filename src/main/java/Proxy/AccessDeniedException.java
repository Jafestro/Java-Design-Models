package Proxy;

class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}