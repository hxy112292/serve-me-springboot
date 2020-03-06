package edu.uta.serveme.constant;

/**
 * @author housirvip
 */
public class Constant {

    public static final String AUTHORIZATION = "Authorization";

    public static final int SUCCESS_CODE = 0;
    public static final int ERROR_CODE = 1;

    public static final int PAGE_NUM_VALUE = 1;
    public static final int PAGE_SIZE_VALUE = 10;
    public static final String PAGE_NUM = "pageNum";
    public static final String PAGE_SIZE = "pageSize";
    public static final String ORDER_TYPE = "orderType";
    public static final String ORDER_BY = "orderBy";
    public static final String PARAM = "param";
    public static final String ENABLE = "enable";
    public static final String DISABLE = "disable";
    public static final String ROLE = "role";
    public static final String UID = "uid";

    public static final String ORDER_STATUS_NOT_ACCEPTED = "NOT_ACCEPTED";
    public static final String ORDER_STATUS_BIDDING = "BIDDING";
    public static final String ORDER_STATUS_PROCESSING = "PROCESSING";
    public static final String ORDER_STATUS_CANCELED = "CANCELED";
    public static final String ORDER_STATUS_FINISHED = "FINISHED";
    public static final String ORDER_STATUS_REVIEWED = "REVIEWED";

    public static final String POINT_SIGN_UP = "SIGN_UP";
    public static final String POINT_PLACE_ORDER = "PLACE_ORDER";
    public static final String POINT_CANCEL_ORDER = "CANCEL_ORDER";

    public static final String SETTING_VIBRATION_ON = "true";
    public static final String SETTING_VIBRATION_OFF = "false";
    public static final String SETTING_NOTIFICATION_ON = "true";
    public static final String SETTING_NOTIFICATION_OFF = "false";


    public static final String PENDING = "pending";
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static final String LIMITED = "LIMITED";
    public static final String USER = "USER";
    public static final String GUEST = "GUEST";
    public static final String VIP = "VIP";
    public static final String ADMIN = "ADMIN";
    public static final String ROOT = "ROOT";

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ROLE_PREFIX = "ROLE_";

    public static final String SMS_ID = "X-LC-Id";
    public static final String SMS_KEY = "X-LC-Key";
    public static final String CAPTCHA_KEY = "api_key";
    public static final String DING_KEY = "access_token";

    public static final String SMS_OK = "{}";
    public static final String CAPTCHA_OK = "{\"error\":0,\"res\":\"success\"}";
    public static final String DING_OK = "{\"errmsg\":\"ok\",\"errcode\":0}";

    public static final int REPORT_SOLVE = 0;
    public static final int REPORT_UNSOLVE = 1;
}
