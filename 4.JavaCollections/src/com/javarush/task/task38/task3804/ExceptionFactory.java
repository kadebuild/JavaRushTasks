package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable throwException(Enum variation) {
        if (variation == ExceptionApplicationMessage.SOCKET_IS_CLOSED || variation == ExceptionApplicationMessage.UNHANDLED_EXCEPTION) {
            return new Exception(variation.name().charAt(0) + variation.name().substring(1).toLowerCase().replaceAll("_", " "));
        } else if (variation == ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS || variation == ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT) {
            return new RuntimeException(variation.name().charAt(0) + variation.name().substring(1).toLowerCase().replaceAll("_", " "));
        } else if (variation == ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS || variation == ExceptionUserMessage.USER_DOES_NOT_EXIST) {
            return new Error(variation.name().charAt(0) + variation.name().substring(1).toLowerCase().replaceAll("_", " "));
        } else {
            return new IllegalArgumentException();
        }
    }
}
