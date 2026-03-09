package shan.icd.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shan.utils.ByteEnum;

@AllArgsConstructor
public enum MessageType implements ByteEnum {
    LOGIN(1),
    LOGOUT(2),
    RESPONSE(3),
    MIKA(4),
    PING(5),
    ALERT(6);

    @Getter
    private final int value;
}
