package com.sluggard.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


/**
 * <p>
    * 系统权限表
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPermission", description="系统权限")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类型 BUTTON 按钮 MENU 菜单 DIRECTORY 文件夹")
    private String type;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "路由")
    private String router;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "连接类型 INNER 内部连接 OUT 外部链接")
    private String linkType;

    @ApiModelProperty(value = "聚焦菜单")
    private String focusOn;

    @ApiModelProperty(value = "状态 ON 启用 OFF")
    private String status;

    @ApiModelProperty(value = "父级id")
    private Integer parentId;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建人id")
    private Integer creatorId;

    @ApiModelProperty(value = "更新人id")
    private Integer updaterId;

    @ApiModelProperty(value = "版本号")
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @ApiModelProperty(value = "逻辑删除标识 0 未删除 1 已删除")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

}
