package com.sluggard.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysPermission;
import com.sluggard.user.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 系统权限表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysPermissionController",tags={"系统权限操作接口"})
@RequestMapping("/v1/sysPermission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "查询系统权限", notes = "查询系统权限")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysPermissionService.getById(id));
    }

    @ApiOperation(value = "更新系统权限", notes = "更新系统权限")
    @ApiImplicitParam(name="sysPermission",value = "系统权限",dataType = "SysPermission",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysPermission sysPermission) {
        sysPermissionService.saveOrUpdate(sysPermission);
        return ResponseResult.ok(sysPermission);
    }

    @ApiOperation(value = "新增系统权限", notes = "新增系统权限")
    @ApiImplicitParam(name="sysPermission",value = "系统权限",dataType = "SysPermission",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysPermission sysPermission) {
        sysPermissionService.saveOrUpdate(sysPermission);
        return ResponseResult.ok(sysPermission);
    }

    @ApiOperation(value = "删除系统权限", notes = "删除系统权限")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysPermissionService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询系统权限", notes = "分页条件查询系统权限")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysPermission> pageQuery) {
        return ResponseResult.ok(sysPermissionService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
