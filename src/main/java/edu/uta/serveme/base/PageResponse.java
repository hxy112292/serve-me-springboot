package edu.uta.serveme.base;

import edu.uta.serveme.constant.Constant;

/**
 * @author housirvip
 */
public class PageResponse<T> extends BaseResponse<T> {

    public PageResponse(T result, long total) {

        super(Constant.SUCCESS_CODE, null, total, result);
    }
}
