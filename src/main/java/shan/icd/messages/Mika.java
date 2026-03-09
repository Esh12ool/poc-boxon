package shan.icd.messages;

import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;

public record Mika(
        @BindInteger(size = "32") int timeSeconds,
        @BindInteger(size = "16") int clientId,
        @BindInteger(size = "16") int velocity,
        @BindInteger(size = "32") int x,
        @BindInteger(size = "32") int y
) {
}
