package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysRolePermission;
import com.sluggard.user.service.SysRolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 角色权限关联表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysRolePermissionController",tags={"角色权限关联操作接口"})
@RequestMapping("/v1/sysRolePermission")
public class SysRolePermissionController {

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @ApiOperation(value = "查询角色权限关联", notes = "查询角色权限关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysRolePermissionService.getById(id));
    }

    @ApiOperation(value = "更新角色权限关联", notes = "更新角色权限关联")
    @ApiImplicitParam(name="sysRolePermission",value = "角色权限关联",dataType = "SysRolePermission",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysRolePermission sysRolePermission) {
        sysRolePermissionService.saveOrUpdate(sysRolePermission);
        return ResponseResult.ok(sysRolePermission);
    }

    @ApiOperation(value = "新增角色权限关联", notes = "新增角色权限关联")
    @ApiImplicitParam(name="sysRolePermission",value = "角色权限关联",dataType = "SysRolePermission",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysRolePermission sysRolePermission) {
        sysRolePermissionService.saveOrUpdate(sysRolePermission);
        return ResponseResult.ok(sysRolePermission);
    }

    @ApiOperation(value = "删除角色权限关联", notes = "删除角色权限关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysRolePermissionService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询角色权限关联", notes = "分页条件查询角色权限关联")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysRolePermission> pageQuery) {
        return ResponseResult.ok(sysRolePermissionService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
