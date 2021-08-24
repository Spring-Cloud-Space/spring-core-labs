//: com.yulikexuan.spring.core.di.bean.scopes.WebUserSettings.java

package com.yulikexuan.spring.core.di.bean.scopes;


import java.util.Objects;


record WebUserSettings(String sessionId, String themeName) implements UserSettings {

    WebUserSettings {
        Objects.requireNonNull(sessionId);
        Objects.requireNonNull(themeName);
    }

    @Override
    public String getSessionId() {
        return this.sessionId;
    }

    @Override
    public String getThemeName() {
        return this.themeName;
    }

}///:~