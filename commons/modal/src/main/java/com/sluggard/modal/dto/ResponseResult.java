package com.sluggard.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回基础信息
 * @author lizheng
 */
@Data
@ApiModel(value = "ResponseResult",description = "返回基础信息")
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer BIZ_ERROR = 0;
    public static final Integer OK = 200;
    public static final Integer ERROR = 500;
    public static final Integer USER_NOT_LOGGED_IN = 401;
    public static final Integer PERMISSION_TOKEN_EXPIRED = 403;
    public static final Integer PARAMETER_VALIDATION_ERROR = 400;

    public static final String ERROR_MSG = "服务器繁忙，请稍后再试！";
    public static final String USER_NOT_LOGGED_IN_MSG = "用户未登录！";
    public static final String PERMISSION_TOKEN_EXPIRED_MSG = "授权失效，请重新登录！";

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String msg;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static <T> ResponseResult<T> ok(){
        return new ResponseResult<T>(OK,"success", null);
    }

    public static <T> ResponseResult<T> ok(T data){
        return new ResponseResult<T>(OK,"success", data);
    }

    public static <T> ResponseResult<T> error(Integer status, String msg){
        return new ResponseResult<T>(status,msg,null);
    }

    public static <T> ResponseResult<T> error(String msg){
        return new ResponseResult<T>(ERROR, msg,null);
    }

}
