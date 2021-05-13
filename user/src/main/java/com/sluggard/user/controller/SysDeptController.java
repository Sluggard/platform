package com.sluggard.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sluggard.modal.dto.ResponseResult;
import com.sluggard.modal.ro.PageQuery;
import com.sluggard.user.entity.SysDept;
import com.sluggard.user.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 部门表 前端控制器
 *
 * @author lizheng
 * @since 2021-04-30
 */
@RestController
@Api(value="SysDeptController",tags={"部门操作接口"})
@RequestMapping("/v1/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 详情
     * @param id 主键id
     */
    @ApiOperation(value = "查询部门信息", notes = "查询部门信息")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @GetMapping("get/{id}")
    public ResponseResult<SysDept> get(@PathVariable Integer id) {
        return ResponseResult.ok(sysDeptService.getById(id));
    }

    /**
     * 更新
     * @param sysDept 部门信息
     */
    @ApiOperation(value = "更新部门信息", notes = "更新部门信息")
    @ApiImplicitParam(name="sysDept",value = "部门信息",dataType = "SysDept",required=true)
    @PutMapping("update")
    public ResponseResult update(@RequestBody SysDept sysDept) {
        sysDeptService.saveOrUpdate(sysDept);
        return ResponseResult.ok(sysDept);
    }

    /**
     * 新增
     * @param sysDept 部门信息
     */
    @ApiOperation(value = "新增部门信息", notes = "新增部门信息")
    @ApiImplicitParam(name="sysDept",value = "部门信息",dataType = "SysDept",required=true)
    @PostMapping("save")
    public ResponseResult save(@RequestBody SysDept sysDept) {
        sysDeptService.saveOrUpdate(sysDept);
        return ResponseResult.ok(sysDept);
    }

    /**
     * 删除
     * @param id 主键id
     */
    @ApiOperation(value = "删除部门信息", notes = "删除部门信息")
    @ApiImplicitParam(name="id",value = "主键id",dataType = "int",required=true)
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok(sysDeptService.removeById(id));
    }

    /**
     * 分页查询
     * @param pageQuery 分页条件参数
     */
    @ApiOperation(value = "分页条件查询部门信息", notes = "分页条件查询部门信息")
    @PostMapping("list")
    public ResponseResult<Page<SysDept>> list(@RequestBody PageQuery<SysDept> pageQuery) {
        return ResponseResult.ok(sysDeptService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getPageSize())));
    }

}
