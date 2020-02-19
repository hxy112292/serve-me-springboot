package edu.uta.serveme.base;

import edu.uta.serveme.constant.Constant;

/**
 * @author housirvip
 */
public class ResultResponse<T> extends BaseResponse<T> {

    public ResultResponse(T result) {

        super(Constant.SUCCESS_CODE, null, null, result);
    }
}
