package com.kurazao.kurazao.mensajes;

public record ResponseMessage<T>(
        int code,
        String message,
        T    data
) {
}
