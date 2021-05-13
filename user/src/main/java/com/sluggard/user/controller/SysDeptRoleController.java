package com.sluggard.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysDeptRole;
import com.sluggard.user.service.SysDeptRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
    * 部门角色关联表 前端控制器
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysDeptRoleController",tags={"部门角色关联操作接口"})
@RequestMapping("/v1/sysDeptRole")
public class SysDeptRoleController {

    @Autowired
    private SysDeptRoleService sysDeptRoleService;

    @ApiOperation(value = "查询部门角色关联", notes = "查询部门角色关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Integer id) {
        return ResponseResult.ok(sysDeptRoleService.getById(id));
    }

    @ApiOperation(value = "更新部门角色关联", notes = "更新部门角色关联")
    @ApiImplicitParam(name="sysDeptRole",value = "部门角色关联",dataType = "SysDeptRole",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysDeptRole sysDeptRole) {
        sysDeptRoleService.saveOrUpdate(sysDeptRole);
        return ResponseResult.ok(sysDeptRole);
    }

    @ApiOperation(value = "新增部门角色关联", notes = "新增部门角色关联")
    @ApiImplicitParam(name="sysDeptRole",value = "部门角色关联",dataType = "SysDeptRole",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysDeptRole sysDeptRole) {
        sysDeptRoleService.saveOrUpdate(sysDeptRole);
        return ResponseResult.ok(sysDeptRole);
    }

    @ApiOperation(value = "删除部门角色关联", notes = "删除部门角色关联")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysDeptRoleService.removeById(id));
    }

    @ApiOperation(value = "分页条件查询部门角色关联", notes = "分页条件查询部门角色关联")
    @PostMapping("pageQuery")
    public ResponseResult pageQuery(@RequestBody PageQuery<SysDeptRole> pageQuery) {
        return ResponseResult.ok(sysDeptRoleService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }
}
