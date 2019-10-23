package com.smy;

import java.util.ArrayList;
import java.util.List;

/**
 * 类属性
 * Created by shaomy on 2019/10/23/023.
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {

    }

    public void addPropertyValue(PropertyValue value) {
        propertyValueList.add(value);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
