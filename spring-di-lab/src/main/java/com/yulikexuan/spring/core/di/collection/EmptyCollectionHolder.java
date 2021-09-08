//: com.yulikexuan.spring.core.di.collection.EmptyCollectionHolder.java

package com.yulikexuan.spring.core.di.collection;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@ToString
@AllArgsConstructor
class EmptyCollectionHolder {

    private final List<Element> simpleBeanList;
    private final Set<Element> simpleBeanSet;
    private final Map<String, Element> simpleBeanMap;

}///:~