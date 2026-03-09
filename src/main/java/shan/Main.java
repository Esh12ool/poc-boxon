package shan;

import io.github.mtrevisan.boxon.core.Composer;
import io.github.mtrevisan.boxon.core.Core;
import io.github.mtrevisan.boxon.core.CoreBuilder;
import io.github.mtrevisan.boxon.core.Parser;
import shan.icd.TcpMessage;
import shan.icd.types.MessageType;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Core core = CoreBuilder.builder()
                .withDefaultCodecs()
                .withTemplate(TcpMessage.class)
                .build();
        Parser parser = Parser.create(core);
        Composer composer = Composer.create(core);


        List<TcpMessage> samples = List.of(
                TcpMessage.builder()
                        .id("sadsfsbgdgdsfsdsdsdsd")
                        .messagetypeCode(MessageType.LOGIN.getValue())
                        .payloadLength(4)
                        .build());

        for (TcpMessage sample : samples) {
            byte[] encoded = composer.compose(sample).getMessage();
            System.out.println(Arrays.toString(encoded));
            TcpMessage tcpMessage = (TcpMessage) parser.parse(encoded).getFirst().getMessage();
            System.out.println(tcpMessage.toString());
        }
    }
}
