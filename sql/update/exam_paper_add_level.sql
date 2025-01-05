-- 添加级别字段
ALTER TABLE exam_paper ADD COLUMN level int COMMENT '级别（1-8级）';

-- 更新注释
COMMENT ON COLUMN exam_paper.level IS '级别（1一级 2二级 3三级 4四级 5五级 6六级 7七级 8八级）';
