package com.smy.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 此接口用于资源定位
 * Created by shaomy on 2019/10/23/023.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
