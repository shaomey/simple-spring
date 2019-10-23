package com.smy.io;

import java.net.URL;

/**
 * 返回一个Resource
 * 这里需要注意getClass().getResource()和getClass().getClassLoader().getResource()的区别
 * Created by shaomy on 2019/10/23/023.
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
