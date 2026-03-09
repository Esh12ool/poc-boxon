package shan.icd;

import io.github.mtrevisan.boxon.annotations.TemplateHeader;
import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;
import io.github.mtrevisan.boxon.annotations.bindings.BindString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TemplateHeader(start = "")
public class TcpMessage {
    @BindString(size = "16")
    private String id;
    @BindInteger(size = "16")
    private int messagetypeCode;
    @BindInteger(size = "16")
    private int payloadLength;
}
// Use the field name to dynamically evaluate the size of the payload
//    @BindObject(type = Login.class)
//    public Login login;
//    @BindObject(condition = "messageType == T(shan.icd.types.MessageType).LOGOUT", type = Logout.class)
//    public Logout logout;
