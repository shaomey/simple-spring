package convert;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现String类型到其他类型的转换
 * Created by shaomy on 2019/10/23/023.
 */
public class ConverterFactory {
    private static Map<Type, Converter> converterMap = new HashMap<>();

    public static Map<Type, Converter> getConverterMap() {
        return converterMap;
    }

    static {
        converterMap.put(Integer.TYPE, new IntConverter());
        converterMap.put(Short.TYPE, new ShortConverter());
        converterMap.put(Byte.TYPE, new ByteConverter());
        converterMap.put(Long.TYPE, new LongConverter());
        converterMap.put(Double.TYPE, new DoubleConverter());
        converterMap.put(Float.TYPE, new FloatConverter());
        converterMap.put(Character.TYPE, new CharacterConverter());
        converterMap.put(Boolean.TYPE, new BooleanConverter());
    }

    public ConverterFactory() {
    }


    static class IntConverter implements Converter {

        @Override
        public Type getType() {
            return Integer.TYPE;
        }

        @Override
        public Integer convertParameter(String value) throws Exception {
            return Integer.parseInt(value);
        }
    }

    static class LongConverter implements Converter {

        @Override
        public Type getType() {
            return Long.TYPE;
        }

        @Override
        public Long convertParameter(String value) throws Exception {
            return Long.valueOf(value);
        }
    }

    static class ShortConverter implements Converter {

        @Override
        public Type getType() {
            return Short.TYPE;
        }

        @Override
        public Short convertParameter(String value) throws Exception {
            return Short.valueOf(value);
        }
    }

    static class ByteConverter implements Converter {

        @Override
        public Type getType() {
            return Byte.TYPE;
        }

        @Override
        public Byte convertParameter(String value) throws Exception {
            return Byte.valueOf(value);
        }
    }

    static class BooleanConverter implements Converter {

        @Override
        public Type getType() {
            return Boolean.TYPE;
        }

        @Override
        public Boolean convertParameter(String value) throws Exception {
            return Boolean.valueOf(value);
        }
    }

    static class CharacterConverter implements Converter {

        @Override
        public Type getType() {
            return Character.TYPE;
        }

        @Override
        public Character convertParameter(String value) throws Exception {
            return value.charAt(0);
        }
    }

    static class FloatConverter implements Converter {

        @Override
        public Type getType() {
            return Float.TYPE;
        }

        @Override
        public Float convertParameter(String value) throws Exception {
            return Float.valueOf(value);
        }
    }

    static class DoubleConverter implements Converter {

        @Override
        public Type getType() {
            return Double.TYPE;
        }

        @Override
        public Double convertParameter(String value) throws Exception {
            return Double.valueOf(value);
        }
    }
}

