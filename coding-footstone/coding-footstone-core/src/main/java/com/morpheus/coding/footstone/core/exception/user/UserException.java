package com.morpheus.coding.footstone.core.exception.user;


import com.morpheus.coding.footstone.core.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author morpheus
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
