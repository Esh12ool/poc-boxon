package shan.icd.messages;

import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;

public record Response(
        @BindInteger(size = "16") int clientId,
        @BindInteger(size = "32") int requestId,
        @BindInteger(size = "16") int statusCode,
        @BindInteger(size = "7") int originalId
) {
}
