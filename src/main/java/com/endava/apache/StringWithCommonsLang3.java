package com.endava.apache;

import org.apache.commons.lang3.StringUtils;

public class StringWithCommonsLang3 {
    public static void main(String[] args) {
        boolean result = StringUtils.isBlank(("1 23 "));
        System.out.println(result);
    }
}
