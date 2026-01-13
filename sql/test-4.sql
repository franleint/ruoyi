

create table t_book (
        book_id           bigint(20)      not null auto_increment    comment '图书ID',
        book_name         varchar(30)     not null                   comment '书名',
        author            varchar(30)     not null                   comment '作者',
        store_area        varchar(30)     not null                   comment '存储区域',
        category_code     varchar(20)     not null                   comment '分类编号',
        status            char(1)         default '0'                comment '状态（0借出 1在馆）',
        borrower_id       bigint(20)                                 comment '借阅人ID',
        del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
        create_by         varchar(64)     default ''                 comment '创建者',
        create_time       datetime                                   comment '创建时间',
        update_by         varchar(64)     default ''                 comment '更新者',
        update_time       datetime                                   comment '更新时间',
        remark            varchar(500)    default null               comment '备注',
        primary key (book_id)
) engine=innodb auto_increment=100 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图书信息表';

create table t_book_borrow (
                        borrow_id         bigint(20)      not null auto_increment    comment '借阅ID',
                        book_id           bigint(20)      not null                   comment '图书ID',
                        borrower_id       bigint(20)                                 comment '借阅人ID',
                        borrow_begin      datetime                                   comment '借阅时间',
                        borrow_end        datetime                                   comment '归还时间',
                        deadline          datetime                                   comment '截止时间',
                        del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                        create_by         varchar(64)     default ''                 comment '创建者',
                        create_time       datetime                                   comment '创建时间',
                        update_by         varchar(64)     default ''                 comment '更新者',
                        update_time       datetime                                   comment '更新时间',
                        remark            varchar(500)    default null               comment '备注',
                        primary key (borrow_id)
) engine=innodb auto_increment=100 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='借阅记录表';

create table t_library_area (
                               area_id           bigint(20)      not null auto_increment    comment '区域ID',
                               area_name         varchar(30)     not null                   comment '区域名称',
                               del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                               create_by         varchar(64)     default ''                 comment '创建者',
                               create_time       datetime                                   comment '创建时间',
                               update_by         varchar(64)     default ''                 comment '更新者',
                               update_time       datetime                                   comment '更新时间',
                               remark            varchar(500)    default null               comment '备注',
                               primary key (area_id)
) engine=innodb auto_increment=100 CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='馆藏区域表';
-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域', '3', '1', 'area', 'system/area/index', 1, 0, 'C', '0', '0', 'system:area:list', '#', 'admin', sysdate(), '', null, '馆藏区域菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:area:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:area:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:area:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:area:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('馆藏区域导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:area:export',       '#', 'admin', sysdate(), '', null, '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录', '3', '1', 'borrow', 'system/borrow/index', 1, 0, 'C', '0', '0', 'system:borrow:list', '#', 'admin', sysdate(), '', null, '借阅记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:borrow:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:borrow:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:borrow:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:borrow:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('借阅记录导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:borrow:export',       '#', 'admin', sysdate(), '', null, '');


-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息', '0', '1', 'book', 'system/book/index', 1, 0, 'C', '0', '0', 'system:book:list', '#', 'admin', sysdate(), '', null, '图书信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:book:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:book:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:book:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:book:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:book:export',       '#', 'admin', sysdate(), '', null, '');