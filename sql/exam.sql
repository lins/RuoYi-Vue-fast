-- ----------------------------
-- 考试类型表
-- ----------------------------
drop table if exists exam_type;
create table exam_type (
  id           bigint(20)      not null auto_increment    comment '主键ID',
  type_code    varchar(50)     not null                   comment '类型编码',
  parent_code  varchar(50)     default null               comment '父类型编码',
  title        varchar(100)    not null                   comment '类型名称',
  description  varchar(500)    default null               comment '类型描述',
  status       char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by    varchar(64)     default ''                 comment '创建者',
  create_time  datetime                                   comment '创建时间',
  update_by    varchar(64)     default ''                 comment '更新者',
  update_time  datetime                                   comment '更新时间',
  remark       varchar(500)    default null               comment '备注',
  primary key (id),
  unique key idx_type_code (type_code)
) engine=innodb auto_increment=100 comment = '考试类型表';

-- ----------------------------
-- 试卷表
-- ----------------------------
drop table if exists exam_paper;
create table exam_paper (
  id              bigint(20)      not null auto_increment    comment '主键ID',
  type_code       varchar(50)     not null                   comment '类型编码',
  name            varchar(200)    not null                   comment '试卷名称',
  year            int(4)          not null                   comment '年份',
  month           int(2)          not null                   comment '月份',
  difficulty      char(1)         not null                   comment '难度（1简单 2中等 3困难）',
  duration        int(4)          not null                   comment '考试时长（分钟）',
  total_score     decimal(5,1)    not null                   comment '总分',
  pass_score      decimal(5,1)    not null                   comment '及格分数',
  question_count  int(4)          not null                   comment '题目数量',
  status          char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by       varchar(64)     default ''                 comment '创建者',
  create_time     datetime                                   comment '创建时间',
  update_by       varchar(64)     default ''                 comment '更新者',
  update_time     datetime                                   comment '更新时间',
  remark          varchar(500)    default null               comment '备注',
  primary key (id),
  key idx_type_code (type_code)
) engine=innodb auto_increment=100 comment = '试卷表';

-- ----------------------------
-- 考试记录表
-- ----------------------------
drop table if exists exam_record;
create table exam_record (
  id           bigint(20)      not null auto_increment    comment '主键ID',
  user_id      bigint(20)      not null                   comment '用户ID',
  paper_id     bigint(20)      not null                   comment '试卷ID',
  start_time   datetime        not null                   comment '开始时间',
  end_time     datetime                                   comment '结束时间',
  score        decimal(5,1)                               comment '得分',
  status       char(1)         default '0'                comment '状态（0进行中 1已完成 2已交卷）',
  create_by    varchar(64)     default ''                 comment '创建者',
  create_time  datetime                                   comment '创建时间',
  update_by    varchar(64)     default ''                 comment '更新者',
  update_time  datetime                                   comment '更新时间',
  remark       varchar(500)    default null               comment '备注',
  primary key (id),
  key idx_user_paper (user_id,paper_id)
) engine=innodb auto_increment=100 comment = '考试记录表';

-- ----------------------------
-- 初始化考试类型数据
-- ----------------------------
INSERT INTO exam_type (type_code, parent_code, title, description, status, create_time, update_time, remark)
VALUES 
('ceit', null, '电子学会青少年等级考试（CEIT）', '由中国电子学会主办的青少年信息技术等级考试', '0', sysdate(), sysdate(), null),
('ceit_robot', 'ceit', '机器人技术等级考试', '全面测评机器人设计、编程和控制能力', '0', sysdate(), sysdate(), null),
('ceit_scratch', 'ceit', '图形化软件编程等级考试', '考察图形化编程基础知识和应用能力', '0', sysdate(), sysdate(), null),
('ceit_python', 'ceit', 'Python软件编程等级考试', 'Python语言基础及其应用开发能力认证', '0', sysdate(), sysdate(), null),
('ceit_c', 'ceit', 'C语言软件编程等级考试', 'C语言程序设计与算法实现能力测评', '0', sysdate(), sysdate(), null),
('ceit_uav', 'ceit', '无人机技术等级考试', '无人机操控与应用开发技术认证', '0', sysdate(), sysdate(), null);
