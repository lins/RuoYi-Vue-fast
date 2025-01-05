-- ----------------------------
-- 考试管理菜单
-- ----------------------------

-- 考试管理父菜单
INSERT INTO sys_menu VALUES ('2000', '考试管理', '0', '5', 'exam', NULL, '', '', 1, 0, 'M', '0', '0', '', 'education', 'admin', sysdate(), '', NULL, '考试管理目录');

-- 考试类型管理菜单
INSERT INTO sys_menu VALUES ('2001', '考试类型管理', '2000', '1', 'type', 'exam/type/index', '', '', 1, 0, 'C', '0', '0', 'exam:type:list', 'tree', 'admin', sysdate(), '', NULL, '考试类型管理菜单');
-- 考试类型管理按钮
INSERT INTO sys_menu VALUES ('2011', '考试类型查询', '2001', '1', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:type:query',  '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2012', '考试类型新增', '2001', '2', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:type:add',    '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2013', '考试类型修改', '2001', '3', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:type:edit',   '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2014', '考试类型删除', '2001', '4', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:type:remove', '#', 'admin', sysdate(), '', NULL, '');

-- 试卷管理菜单
INSERT INTO sys_menu VALUES ('2002', '试卷管理', '2000', '2', 'paper', 'exam/paper/index', '', '', 1, 0, 'C', '0', '0', 'exam:paper:list', 'documentation', 'admin', sysdate(), '', NULL, '试卷管理菜单');
-- 试卷管理按钮
INSERT INTO sys_menu VALUES ('2021', '试卷查询', '2002', '1', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:paper:query',  '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2022', '试卷新增', '2002', '2', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:paper:add',    '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2023', '试卷修改', '2002', '3', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:paper:edit',   '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2024', '试卷删除', '2002', '4', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:paper:remove', '#', 'admin', sysdate(), '', NULL, '');

-- 考试记录管理菜单
INSERT INTO sys_menu VALUES ('2003', '考试记录管理', '2000', '3', 'record', 'exam/record/index', '', '', 1, 0, 'C', '0', '0', 'exam:record:list', 'form', 'admin', sysdate(), '', NULL, '考试记录管理菜单');
-- 考试记录管理按钮
INSERT INTO sys_menu VALUES ('2031', '考试记录查询', '2003', '1', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:record:query',  '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2032', '考试记录新增', '2003', '2', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:record:add',    '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2033', '考试记录修改', '2003', '3', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:record:edit',   '#', 'admin', sysdate(), '', NULL, '');
INSERT INTO sys_menu VALUES ('2034', '考试记录删除', '2003', '4', '#', '', '', '', 1, 0, 'F', '0', '0', 'exam:record:remove', '#', 'admin', sysdate(), '', NULL, '');

-- 给管理员角色授权考试管理权限
INSERT INTO sys_role_menu(role_id, menu_id) 
SELECT 1, menu_id FROM sys_menu WHERE menu_id BETWEEN 2000 AND 2034;
