package com.sluggard.modal.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 分页条件简单模型
 * @author lizheng
 */
@Data
@ApiModel(value = "PageQuery",description = "分页查询基础信息")
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private Integer current = 1;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize = 10;

    /**
     * 条件参数
     */
    @ApiModelProperty(value = "条件参数")
    private T queryParam;
}
