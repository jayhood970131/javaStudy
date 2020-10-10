import {commonParams} from './config-migu'
import axios from '../common/js/axios'

export function getRecommend () {
  const url = '/api/migu/remoting/cms_list_tag'
  const data = Object.assign({}, commonParams, {
    nid: 23831003,
    type: 2006
  })
  return axios(url, data)
}
