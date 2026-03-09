package shan.utils;

import io.github.mtrevisan.boxon.annotations.bindings.ByteOrder;
import io.github.mtrevisan.boxon.core.helpers.BitSetHelper;
import io.github.mtrevisan.boxon.core.helpers.DataTypeCaster;
import io.github.mtrevisan.boxon.exceptions.BoxonException;
import io.github.mtrevisan.boxon.io.BitReaderInterface;
import io.github.mtrevisan.boxon.io.BitWriterInterface;
import io.github.mtrevisan.boxon.io.Codec;

import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

public class EnumCodec implements Codec {

    @Override
    public Class<? extends Annotation> annotationType() {
        return BindEnum.class; // Links this codec to your custom annotation
    }

    @Override
    public Object decode(BitReaderInterface reader, Annotation annotation, Annotation collectionBinding, Object rootObject) throws BoxonException {
        BindEnum bindEnum = (BindEnum) annotation;
        // Note: For dynamic SpEL sizes, use Boxon's Evaluator. For fixed numbers, parsing works:
        int sizeInBits = Integer.parseInt(bindEnum.size());
        // Read the integer from the buffer
        int readValue = reader.readBigInteger(sizeInBits, bindEnum.byteOrder()).intValue();
        // Map it dynamically to the enum using the type() provided in the annotation
        return Arrays.stream(bindEnum.type().getEnumConstants())
                .filter(constant -> constant.getValue() == readValue)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void encode(BitWriterInterface writer, Annotation annotation, Annotation collectionBinding, Object rootObject, Object value) throws BoxonException {
        BindEnum bindEnum = (BindEnum) annotation;

        int sizeInBits = Integer.parseInt(bindEnum.size());
        ByteOrder byteOrder = bindEnum.byteOrder();

        final BigInteger v = DataTypeCaster.reinterpretToBigInteger(((ByteEnum) value).getValue());
        final BitSet bitmap = BitSetHelper.createBitSet(sizeInBits, v, byteOrder);

        writer.writeBitSet(bitmap, sizeInBits);
    }
}