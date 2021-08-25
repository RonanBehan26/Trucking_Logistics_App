package com.trucking.logistics.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class ConstantUtil {

    public static Map<String, Date> userLists = new HashMap<>();

    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer";
    public static final String USER = "USER";
    public static final SimpleDateFormat FORMAT_TOKEN_ISSUE_AT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

}
