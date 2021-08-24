//: com.yulikexuan.spring.core.di.bean.scopes.WebThemeManager.java

package com.yulikexuan.spring.core.di.bean.scopes;


import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ToString
class WebThemeManager implements ThemeManager {

    private UserSettings userSettings;

    @Override
    public void initialize() {
        log.info(">>>>>>> Initializing {} Web Theme for User",
                this.userSettings.getThemeName());
    }

    @Override
    public UserSettings getUserSettings() {
        return this.userSettings;
    }

    @Override
    public String getSessionId() {
        return this.userSettings.getSessionId();
    }

    void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

}///:~