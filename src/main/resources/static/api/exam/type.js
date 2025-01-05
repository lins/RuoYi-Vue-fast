import request from '@/utils/request'

// 查询考试类型列表
export function listExamType(query) {
  return request({
    url: '/exam/type/list',
    method: 'get',
    params: query
  })
}

// 查询考试类型详细
export function getExamType(id) {
  return request({
    url: '/exam/type/' + id,
    method: 'get'
  })
}

// 新增考试类型
export function addExamType(data) {
  return request({
    url: '/exam/type',
    method: 'post',
    data: data
  })
}

// 修改考试类型
export function updateExamType(data) {
  return request({
    url: '/exam/type',
    method: 'put',
    data: data
  })
}

// 删除考试类型
export function delExamType(id) {
  return request({
    url: '/exam/type/' + id,
    method: 'delete'
  })
}
