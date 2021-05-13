package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysUserDept;
import com.sluggard.user.service.SysUserDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 系统用户部门关联表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysUserDeptController",tags={"系统用户部门关联操作接口"})
@RequestMapping("/v1/sysUserDept")
public class SysUserDeptController {

    @Autowired
    private SysUserDeptService sysUserDeptService;

    @ApiOperation(value = "查询系统用户部门关联", notes = "查询系统用户部门关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserDeptService.getById(id));
    }

    @ApiOperation(value = "更新系统用户部门关联", notes = "更新系统用户部门关联")
    @ApiImplicitParam(name="sysUserDept",value = "系统用户部门关联",dataType = "SysUserDept",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysUserDept sysUserDept) {
        sysUserDeptService.saveOrUpdate(sysUserDept);
        return ResponseResult.ok(sysUserDept);
    }

    @ApiOperation(value = "新增系统用户部门关联", notes = "新增系统用户部门关联")
    @ApiImplicitParam(name="sysUserDept",value = "系统用户部门关联",dataType = "SysUserDept",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysUserDept sysUserDept) {
        sysUserDeptService.saveOrUpdate(sysUserDept);
        return ResponseResult.ok(sysUserDept);
    }

    @ApiOperation(value = "删除系统用户部门关联", notes = "删除系统用户部门关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysUserDeptService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询系统用户部门关联", notes = "分页条件查询系统用户部门关联")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysUserDept> pageQuery) {
        return ResponseResult.ok(sysUserDeptService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
