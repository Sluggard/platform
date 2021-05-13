package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysUserRole;
import com.sluggard.user.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 用户角色关联表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysUserRoleController",tags={"用户角色关联操作接口"})
@RequestMapping("/v1/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @ApiOperation(value = "查询用户角色关联", notes = "查询用户角色关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserRoleService.getById(id));
    }

    @ApiOperation(value = "更新用户角色关联", notes = "更新用户角色关联")
    @ApiImplicitParam(name="sysUserRole",value = "用户角色关联",dataType = "SysUserRole",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysUserRole sysUserRole) {
        sysUserRoleService.saveOrUpdate(sysUserRole);
        return ResponseResult.ok(sysUserRole);
    }

    @ApiOperation(value = "新增用户角色关联", notes = "新增用户角色关联")
    @ApiImplicitParam(name="sysUserRole",value = "用户角色关联",dataType = "SysUserRole",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysUserRole sysUserRole) {
        sysUserRoleService.saveOrUpdate(sysUserRole);
        return ResponseResult.ok(sysUserRole);
    }

    @ApiOperation(value = "删除用户角色关联", notes = "删除用户角色关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserRoleService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询用户角色关联", notes = "分页条件查询用户角色关联")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysUserRole> pageQuery) {
        return ResponseResult.ok(sysUserRoleService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
