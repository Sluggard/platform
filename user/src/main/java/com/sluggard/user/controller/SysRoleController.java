package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysRole;
import com.sluggard.user.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 系统角色表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysRoleController",tags={"系统角色操作接口"})
@RequestMapping("/v1/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "查询系统角色", notes = "查询系统角色")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysRoleService.getById(id));
    }

    @ApiOperation(value = "更新系统角色", notes = "更新系统角色")
    @ApiImplicitParam(name="sysRole",value = "系统角色",dataType = "SysRole",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysRole sysRole) {
        sysRoleService.saveOrUpdate(sysRole);
        return ResponseResult.ok(sysRole);
    }

    @ApiOperation(value = "新增系统角色", notes = "新增系统角色")
    @ApiImplicitParam(name="sysRole",value = "系统角色",dataType = "SysRole",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysRole sysRole) {
        sysRoleService.saveOrUpdate(sysRole);
        return ResponseResult.ok(sysRole);
    }

    @ApiOperation(value = "删除系统角色", notes = "删除系统角色")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysRoleService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询系统角色", notes = "分页条件查询系统角色")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysRole> pageQuery) {
        return ResponseResult.ok(sysRoleService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
