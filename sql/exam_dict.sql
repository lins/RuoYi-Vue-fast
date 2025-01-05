-- ----------------------------
-- 考试管理字典数据
-- ----------------------------

-- 试卷难度字典
insert into sys_dict_type values(200, '试卷难度', 'exam_paper_difficulty', '0', 'admin', sysdate(), '', null, '试卷难度字典');
insert into sys_dict_data values(2000, 1, '简单', '1', 'exam_paper_difficulty', '', 'success', 'Y', '0', 'admin', sysdate(), '', null, '简单');
insert into sys_dict_data values(2001, 2, '中等', '2', 'exam_paper_difficulty', '', 'warning', 'Y', '0', 'admin', sysdate(), '', null, '中等');
insert into sys_dict_data values(2002, 3, '困难', '3', 'exam_paper_difficulty', '', 'danger',  'Y', '0', 'admin', sysdate(), '', null, '困难');

-- 考试记录状态字典
insert into sys_dict_type values(201, '考试记录状态', 'exam_record_status', '0', 'admin', sysdate(), '', null, '考试记录状态字典');
insert into sys_dict_data values(2010, 1, '进行中', '0', 'exam_record_status', '', 'info',    'Y', '0', 'admin', sysdate(), '', null, '进行中');
insert into sys_dict_data values(2011, 2, '已完成', '1', 'exam_record_status', '', 'success', 'Y', '0', 'admin', sysdate(), '', null, '已完成');
insert into sys_dict_data values(2012, 3, '已交卷', '2', 'exam_record_status', '', 'warning', 'Y', '0', 'admin', sysdate(), '', null, '已交卷');
