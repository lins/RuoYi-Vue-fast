import request from '@/utils/request'

// 查询考试记录列表
export function listExamRecord(query) {
  return request({
    url: '/exam/record/list',
    method: 'get',
    params: query
  })
}

// 查询考试记录详细
export function getExamRecord(id) {
  return request({
    url: '/exam/record/' + id,
    method: 'get'
  })
}

// 新增考试记录
export function addExamRecord(data) {
  return request({
    url: '/exam/record',
    method: 'post',
    data: data
  })
}

// 修改考试记录
export function updateExamRecord(data) {
  return request({
    url: '/exam/record',
    method: 'put',
    data: data
  })
}

// 删除考试记录
export function delExamRecord(id) {
  return request({
    url: '/exam/record/' + id,
    method: 'delete'
  })
}
