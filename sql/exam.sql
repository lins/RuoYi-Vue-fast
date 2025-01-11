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
-- 试题表
-- ----------------------------
drop table if exists exam_question;
create table exam_question (
  id              bigint(20)      not null auto_increment    comment '主键ID',
  paper_id        bigint(20)      not null                   comment '试卷ID',
  question_type   char(1)         not null                   comment '题目类型（1单选题 2多选题 3判断题 4填空题 5编程题）',
  question_score  decimal(5,1)    not null                   comment '题目分数',
  question_text   text            not null                   comment '题目内容',
  option_a        varchar(500)                               comment '选项A',
  option_b        varchar(500)                               comment '选项B',
  option_c        varchar(500)                               comment '选项C',
  option_d        varchar(500)                               comment '选项D',
  correct_answer  text    not null                   comment '正确答案',
  analysis       text                                        comment '题目解析',
  sort_order     int(4)          default 0                   comment '排序号',
  status         char(1)         default '0'                 comment '状态（0正常 1停用）',
  create_by      varchar(64)     default ''                  comment '创建者',
  create_time    datetime                                    comment '创建时间',
  update_by      varchar(64)     default ''                  comment '更新者',
  update_time    datetime                                    comment '更新时间',
  remark         varchar(500)    default null                comment '备注',
  primary key (id)
) engine=innodb auto_increment=100 comment = '试题表';

-- ----------------------------
-- 考试答题记录表
-- ----------------------------
drop table if exists exam_answer;
create table exam_answer (
  id              bigint(20)      not null auto_increment    comment '主键ID',
  record_id       bigint(20)      not null                   comment '考试记录ID',
  question_id     bigint(20)      not null                   comment '试题ID',
  user_answer     text                                       comment '用户答案',
  is_correct      char(1)         default '0'                comment '是否正确（0错误 1正确）',
  score           decimal(5,1)                               comment '得分',
  create_time     datetime                                   comment '创建时间',
  update_time     datetime                                   comment '更新时间',
  primary key (id)
) engine=innodb auto_increment=100 comment = '考试答题记录表';

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

-- ----------------------------
-- 初始化试卷数据
-- ----------------------------
INSERT INTO exam_paper (id, type_code, name, year, month, difficulty, duration, total_score, pass_score, question_count, status, create_time, update_time, remark)
VALUES 
(1, 'python', 'CEIT Python二级考试样题（2024年3月）', 2024, 3, '2', 120, 100, 60, 25, '0', sysdate(), sysdate(), '适用于Python二级考试备考');

-- ----------------------------
-- 初始化试题数据
-- ----------------------------
INSERT INTO exam_question (id, paper_id, question_type, question_score, question_text, option_a, option_b, option_c, option_d, correct_answer, analysis, sort_order, status, create_time, update_time, remark) 
VALUES
-- 单选题
(1, 1, '1', 2, '在Python中，以下哪个不是合法的变量名？', 'my_name', '_test', '123abc', 'userName', 'C', '变量名不能以数字开头，但可以包含数字、字母和下划线，且区分大小写。', 1, '0', sysdate(), sysdate(), NULL),
(2, 1, '1', 2, '关于Python的列表(List)，以下说法错误的是：', '列表是有序的序列', '列表中的元素可以修改', '列表可以包含不同类型的元素', '列表不能嵌套', 'D', '列表是可以嵌套的，即列表的元素可以是另一个列表。', 2, '0', sysdate(), sysdate(), NULL),
(3, 1, '1', 2, '以下哪个操作会产生一个新的字符串对象？', 's = "hello"', 's[0] = "H"', 's = s.upper()', 's += "world"', 'C', 'Python中的字符串是不可变对象，任何修改字符串的操作都会创建一个新的字符串对象。', 3, '0', sysdate(), sysdate(), NULL),

-- 多选题
(4, 1, '2', 4, 'Python中的以下哪些数据类型是可变的？', 'List（列表）', 'Dictionary（字典）', 'Set（集合）', 'Tuple（元组）', 'ABC', '列表、字典和集合是可变的数据类型，而元组是不可变的。', 4, '0', sysdate(), sysdate(), NULL),
(5, 1, '2', 4, '以下哪些是Python的内置函数？', 'len()', 'range()', 'print()', 'sizeof()', 'ABC', 'len()、range()和print()是Python的内置函数，而sizeof()是C语言的函数。', 5, '0', sysdate(), sysdate(), NULL),

-- 判断题
(6, 1, '3', 2, 'Python中的列表切片操作可以包含步长参数。', NULL, NULL, NULL, NULL, '1', '正确。列表切片的完整语法是[start:end:step]，step表示步长。', 6, '0', sysdate(), sysdate(), NULL),
(7, 1, '3', 2, 'Python中的字典是无序的数据类型。', NULL, NULL, NULL, NULL, '0', '在Python 3.7及以后的版本中，字典会保持插入顺序。', 7, '0', sysdate(), sysdate(), NULL),

-- 编程题
(8, 1, '5', 10, '编写一个函数，接收一个整数列表作为参数，返回列表中所有偶数的和。要求使用列表推导式实现。

示例：
输入：[1, 2, 3, 4, 5, 6]
输出：12
说明：列表中的偶数是2、4、6，它们的和是12', NULL, NULL, NULL, NULL, 'def sum_even(numbers):
    return sum([num for num in numbers if num % 2 == 0])

# 测试代码
numbers = [1, 2, 3, 4, 5, 6]
result = sum_even(numbers)
print(result)  # 输出：12', '这道题考察了以下知识点：
1. 函数定义和参数传递
2. 列表推导式的使用
3. 条件判断
4. sum()函数的使用

列表推导式[num for num in numbers if num % 2 == 0]会生成一个只包含偶数的新列表，然后使用sum()函数计算这些偶数的和。', 8, '0', sysdate(), sysdate(), NULL),

(9, 1, '5', 15, '实现一个简单的学生成绩管理系统，包含以下功能：
1. 添加学生成绩
2. 计算平均分
3. 查找最高分和最低分

要求：
- 使用字典存储学生信息，键为学生姓名，值为成绩
- 实现add_score(), get_average(), get_max_min()三个方法
- 使用异常处理确保输入的成绩是有效的数字

示例：
>>> grades = GradeSystem()
>>> grades.add_score("张三", 85)
>>> grades.add_score("李四", 92)
>>> grades.add_score("王五", 78)
>>> print(grades.get_average())  # 输出：85.0
>>> print(grades.get_max_min())  # 输出：(92, 78)', NULL, NULL, NULL, NULL, 'class GradeSystem:
    def __init__(self):
        self.grades = {}
    
    def add_score(self, name, score):
        try:
            score = float(score)
            if 0 <= score <= 100:
                self.grades[name] = score
            else:
                raise ValueError("成绩必须在0-100之间")
        except ValueError as e:
            raise ValueError("无效的成绩数据")
    
    def get_average(self):
        if not self.grades:
            return 0
        return sum(self.grades.values()) / len(self.grades)
    
    def get_max_min(self):
        if not self.grades:
            return (0, 0)
        scores = list(self.grades.values())
        return (max(scores), min(scores))

# 测试代码
grades = GradeSystem()
grades.add_score("张三", 85)
grades.add_score("李四", 92)
grades.add_score("王五", 78)
print(f"平均分：{grades.get_average()}")
print(f"最高分和最低分：{grades.get_max_min()}")', '这道题考察了以下知识点：
1. 类的定义和方法实现
2. 字典的基本操作
3. 异常处理
4. 数据类型转换
5. 基本的数学计算

实现要点：
1. 使用__init__初始化空字典
2. add_score方法包含输入验证和异常处理
3. get_average方法注意处理空字典的情况
4. get_max_min方法使用max()和min()函数', 9, '0', sysdate(), sysdate(), NULL);
