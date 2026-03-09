package shan.icd.messages;

import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;
import io.github.mtrevisan.boxon.annotations.bindings.BindString;
import lombok.Builder;

@Builder
public record Login(
        @BindInteger(size = "32") int clientId,
        @BindString(size = "16") String clientName,
        @BindInteger(size = "32") int sessionId
) {
}
