import request from '@/utils/request'

export function zhongbiao() {
    return request({
      url: 'plm/zhongbiao',
      method: 'get'
    })
}

export function youxiaNo() {
    return request({
      url: 'plm/youxiaNo',
      method: 'get'
    })
}
export function youshangTop() {
    return request({
      url: 'plm/youshangTop',
      method: 'get'
    })
}

export function youshangTwo() {
    return request({
      url: 'plm/youshangTwo',
      method: 'get'
    })
}

export function youshangTwoFType() {
  return request({
    url: 'plm/youshangTwoFType',
    method: 'get'
  })
}

export function youshangTwoFTypeTop() {
  return request({
    url: 'plm/youshangTwoFTypeTop',
    method: 'get'
  })
}

export function PojSum() {
    return request({
      url: 'plm/PojSum',
      method: 'get'
    })
}

export function PojSumFType() {
  return request({
    url: 'plm/PojSumFType',
    method: 'get'
  })
}

export function PojProportion() {
    return request({
      url: 'plm/PojProportion',
      method: 'get'
    })
}

export function PojProportionFType() {
  return request({
    url: 'plm/PojProportionFType',
    method: 'get'
  })
}

export function youxiaTwo() {
    return request({
      url: 'plm/youxiaTwo',
      method: 'get'
    })
}

export function zhuzhuangtu() {
  return request({
    url: 'plm/zhuzhuangtu',
    method: 'get'
  })
}


export function selectPojNum() {
  return request({
    url: 'plm/selectPojNum',
    method: 'get'
  })
}

export function selectPojNumFType() {
  return request({
    url: 'plm/selectPojNumFType',
    method: 'get'
  })
}


export default {
    zhongbiao,youxiaNo
}