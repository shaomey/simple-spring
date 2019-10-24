package convert;

import java.lang.reflect.Type;

/**
 * 这个接口的目的是将String转换为其他基本类型
 * 可以通过实现此接口实现自定义类
 * Created by shaomy on 2019/10/23/023.
 */
public interface Converter<T> {
    Type getType();

    T convertParameter(String value) throws Exception;
}
