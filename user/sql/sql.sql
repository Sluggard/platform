create table platform_user.sys_dept
(
    id          int auto_increment comment '主键id',
    dept_name   varchar(20)                     not null comment '部门名称',
    parent_id   int                default 0    not null comment '父级id',
    status      enum ('ON', 'OFF') default 'ON' not null comment '状态 ON 启用 OFF',
    create_time datetime                        not null comment '创建日期',
    update_time datetime                        not null comment '更新时间',
    creator_id  int                             not null comment '创建人id',
    updater_id  int                             not null comment '更新人id',
    version     int                default 0    not null comment '版本号',
    deleted     tinyint(1)         default 0    not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint dept_id_uindex
        unique (id),
    constraint sys_dept_dept_name_uindex
        unique (dept_name)
)
    comment '部门表';

alter table platform_user.sys_dept
    add primary key (id);
create table platform_user.sys_dept_role
(
    id          int auto_increment comment '主键id',
    dept_id     int                  not null comment '部门id',
    role_id     int                  not null comment '角色id',
    create_time datetime             not null comment '创建日期',
    update_time datetime             not null comment '更新时间',
    creator_id  int                  not null comment '创建人id',
    updater_id  int                  not null comment '更新人id',
    version     int        default 0 not null comment '版本号',
    deleted     tinyint(1) default 0 not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint table_name_id_uindex
        unique (id)
)
    comment '部门角色关联表';

alter table platform_user.sys_dept_role
    add primary key (id);

create table platform_user.sys_permission
(
    id          int auto_increment comment '主键id',
    type        enum ('BUTTON', 'MENU', 'DIRECTORY')  not null comment '类型 BUTTON 按钮 MENU 菜单 DIRECTORY 文件夹',
    name        varchar(40)                           not null comment '名称',
    code        varchar(40)                           not null comment '编码',
    router      varchar(100)                          null comment '路由',
    component   varchar(100)                          null comment '组件',
    link_type   enum ('INNER', 'OUT') default 'INNER' null comment '连接类型 INNER 内部连接 OUT 外部链接',
    focus_on    varchar(100)                          null comment '聚焦菜单',
    status      enum ('ON', 'OFF')    default 'ON'    not null comment '状态 ON 启用 OFF',
    parent_id   int                   default 0       not null comment '父级id',
    create_time datetime                              not null comment '创建日期',
    update_time datetime                              not null comment '更新时间',
    creator_id  int                                   not null comment '创建人id',
    updater_id  int                                   not null comment '更新人id',
    version     int                   default 0       not null comment '版本号',
    deleted     tinyint(1)            default 0       not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint sys_permission_id_uindex
        unique (id)
)
    comment '系统权限表';

alter table platform_user.sys_permission
    add primary key (id);

create table platform_user.sys_role
(
    id          int auto_increment comment '主键id',
    name        varchar(40)                     not null comment '角色名称',
    code        varchar(40)                     not null comment '角色编码',
    status      enum ('ON', 'OFF') default 'ON' not null comment '状态 ON 启用 OFF',
    create_time datetime                        not null comment '创建日期',
    update_time datetime                        not null comment '更新时间',
    creator_id  int                             not null comment '创建人id',
    updater_id  int                             not null comment '更新人id',
    version     int                default 0    not null comment '版本号',
    deleted     tinyint(1)         default 0    not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint sys_role_code_uindex
        unique (code),
    constraint sys_role_id_uindex
        unique (id)
)
    comment '系统角色表';

alter table platform_user.sys_role
    add primary key (id);

create table platform_user.sys_role_permission
(
    id            int auto_increment comment '主键id',
    role_id       int                  not null comment '角色id',
    permission_id int                  not null comment '权限id',
    create_time   datetime             not null comment '创建日期',
    update_time   datetime             not null comment '更新时间',
    creator_id    int                  not null comment '创建人id',
    updater_id    int                  not null comment '更新人id',
    version       int        default 0 not null comment '版本号',
    deleted       tinyint(1) default 0 not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint sys_role_permission_id_uindex
        unique (id)
)
    comment '角色权限关联表';

alter table platform_user.sys_role_permission
    add primary key (id);

create table platform_user.sys_user
(
    id          int auto_increment comment '主键id',
    username    varchar(20)                      not null comment '手机号码',
    password    varchar(500)                     not null comment '密码',
    nick_name   varchar(40)                      null comment '昵称',
    birthday    date                             null comment '出生日期',
    gender      enum ('MAN', 'FEMALE', 'SECRET') null comment '性别',
    dept_id     int                              not null comment '部门id',
    create_time datetime                         not null comment '创建日期',
    update_time datetime                         not null comment '更新日期',
    creator_id  int                              not null comment '创建人id',
    updator_id  int                              not null comment '更新人id',
    version     int                default 0     not null comment '版本号',
    deleted     tinyint(1)         default 0     not null comment '逻辑删除标识 0 未删除 1 已删除',
    status      enum ('ON', 'OFF') default 'ON'  not null comment '状态 ON 启用 OFF',
    constraint customer_id_uindex
        unique (id),
    constraint sys_user_username_uindex
        unique (username)
)
    comment '用户表';

alter table platform_user.sys_user
    add primary key (id);

create table platform_user.sys_user_dept
(
    id          int auto_increment comment '主键id',
    user_id     int                  not null comment '用户id',
    dept_id     int                  not null comment '部门id',
    create_time datetime             not null comment '创建日期',
    update_time datetime             not null comment '更新时间',
    creator_id  int                  not null comment '创建人id',
    updater_id  int                  not null comment '更新人id',
    version     int        default 0 not null comment '版本号',
    deleted     tinyint(1) default 0 not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint sys_user_dept_id_uindex
        unique (id)
)
    comment '系统用户部门关联表';

alter table platform_user.sys_user_dept
    add primary key (id);

create table platform_user.sys_user_role
(
    id          int auto_increment comment '用户角色关联表',
    user_id     int                  not null comment '用户id',
    role_id     int                  not null comment '角色id',
    create_time datetime             not null comment '创建日期',
    update_time datetime             not null comment '更新时间',
    creator_id  int                  not null comment '创建人id',
    updater_id  int                  not null comment '更新人id',
    version     int        default 0 not null comment '版本号',
    deleted     tinyint(1) default 0 not null comment '逻辑删除标识 0 未删除 1 已删除',
    constraint sys_user_role_id_uindex
        unique (id)
)
    comment '用户角色关联表';

alter table platform_user.sys_user_role
    add primary key (id);


