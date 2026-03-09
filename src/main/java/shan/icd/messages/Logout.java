package shan.icd.messages;

import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;

public record Logout(
        @BindInteger(size = "8") int reasonCode,
        @BindInteger(size = "8") int flags
) {
}
