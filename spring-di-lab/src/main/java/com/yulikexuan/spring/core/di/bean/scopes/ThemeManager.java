//: com.yulikexuan.spring.core.di.bean.scopes.ThemeManager.java

package com.yulikexuan.spring.core.di.bean.scopes;


public interface ThemeManager {

    void initialize();
    UserSettings getUserSettings();
    String getSessionId();

}///:~