package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysUser;
import com.sluggard.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 用户表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysUserController",tags={"用户操作接口"})
@RequestMapping("/v1/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserService.getById(id));
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @ApiImplicitParam(name="sysUser",value = "用户",dataType = "SysUser",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysUser sysUser) {
        sysUserService.saveOrUpdate(sysUser);
        return ResponseResult.ok(sysUser);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParam(name="sysUser",value = "用户",dataType = "SysUser",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysUser sysUser) {
        sysUserService.saveOrUpdate(sysUser);
        return ResponseResult.ok(sysUser);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询用户", notes = "分页条件查询用户")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysUser> pageQuery) {
        return ResponseResult.ok(sysUserService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
