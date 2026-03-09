package shan.icd;

import io.github.mtrevisan.boxon.annotations.TemplateHeader;
import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;
import io.github.mtrevisan.boxon.annotations.bindings.BindObject;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import shan.Main;
import shan.icd.messages.Login;
import shan.icd.messages.Logout;
import shan.icd.messages.Mika;
import shan.icd.messages.Response;
import shan.icd.types.MessageType;
import shan.utils.BindEnum;

@Data
@Builder
@TemplateHeader(start = "")
public class TcpMessage {
    @BindInteger(size = "7")
    public int id;
    @BindInteger(size = "8")
    public int messageType;
    @BindInteger(size = "16")
    public int payloadLength;
//    @BindObject(type = Login.class)
//    public Login login;
//    @BindObject(condition = "messageType == T(shan.icd.types.MessageType).LOGOUT", type = Logout.class)
//    public Logout logout;
//    @BindObject(condition = "messageType == T(shan.icd.types.MessageType).RESPONSE", type = Response.class)
//    public Response response;
//    @BindObject(condition = "messageType == T(shan.icd.types.MessageType).MIKA", type = Mika.class)
//    public Mika mika;
}
