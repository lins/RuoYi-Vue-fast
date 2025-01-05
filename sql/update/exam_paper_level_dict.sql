-- 添加试卷级别字典类型
INSERT INTO sys_dict_type(dict_name, dict_type, status, create_by, remark)
VALUES ('试卷级别', 'exam_paper_level', '0', 'admin', '试卷级别（1-8级）');

-- 添加试卷级别字典数据
INSERT INTO sys_dict_data(dict_sort, dict_label, dict_value, dict_type, status, create_by, remark)
VALUES 
(1, '一级', '1', 'exam_paper_level', '0', 'admin', '一级'),
(2, '二级', '2', 'exam_paper_level', '0', 'admin', '二级'),
(3, '三级', '3', 'exam_paper_level', '0', 'admin', '三级'),
(4, '四级', '4', 'exam_paper_level', '0', 'admin', '四级'),
(5, '五级', '5', 'exam_paper_level', '0', 'admin', '五级'),
(6, '六级', '6', 'exam_paper_level', '0', 'admin', '六级'),
(7, '七级', '7', 'exam_paper_level', '0', 'admin', '七级'),
(8, '八级', '8', 'exam_paper_level', '0', 'admin', '八级');
