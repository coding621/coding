package com.morpheus.coding.footstone.core.exception.file;


import com.morpheus.coding.footstone.core.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author morpheus
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
