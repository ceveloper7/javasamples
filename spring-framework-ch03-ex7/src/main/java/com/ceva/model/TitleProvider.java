package com.ceva.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

public class TitleProvider {
    private String title = "Gravity";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static TitleProvider instance(String title){
        var childProvider = new TitleProvider();
        if(StringUtils.isNotBlank(title)){
            childProvider.setTitle(title);
        }
        return childProvider;
    }
}
