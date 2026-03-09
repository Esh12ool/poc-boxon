package shan;

import io.github.mtrevisan.boxon.annotations.bindings.BindInteger;
import io.github.mtrevisan.boxon.core.Composer;
import io.github.mtrevisan.boxon.core.Core;
import io.github.mtrevisan.boxon.core.CoreBuilder;
import io.github.mtrevisan.boxon.core.Parser;
import io.github.mtrevisan.boxon.core.Response;
import io.github.mtrevisan.boxon.core.helpers.BitReader;
import io.github.mtrevisan.boxon.core.helpers.BitWriter;
import io.github.mtrevisan.boxon.core.helpers.templates.Template;
import io.github.mtrevisan.boxon.core.parsers.TemplateParser;
import shan.icd.TcpMessage;
import shan.icd.messages.Login;
import shan.icd.types.MessageType;
import shan.utils.EnumCodec;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Core core = CoreBuilder.builder()
            .withDefaultCodecs()
            .withCodec(new EnumCodec())
            .build();

        Parser parser = Parser.create(core);
        Composer composer = Composer.create(core);
        TemplateParser templateParser = TemplateParser.getInstance();
        Template<TcpMessage> template = templateParser.createTemplate(TcpMessage.class);
        BitWriter writer = BitWriter.create();


        List<TcpMessage> samples = List.of(
                TcpMessage.builder()
                        .id(7)
                        .messageType(MessageType.LOGIN.getValue())
                        .build());

        for (TcpMessage sample : samples) {
            Response<?, byte[]> response = composer.compose(sample);

            System.out.println(Arrays.toString(response.getMessage()));
            Response<?, ?> newresponse = parser.parse(ByteBuffer.wrap(response.getMessage()));
            templateParser.decode(template, reader, null);
            System.out.println();
        }
    }
}
