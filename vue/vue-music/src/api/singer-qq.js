import {commonParams} from './config-qq'
import axios from '../common/js/axios'
import {getSign} from '../common/js/sign'

export function getSingerList () {
  const url = '/api/cgi-bin/musics.fcg?-=getUCGI8969991182298145'
  const dataJson = {comm: {ct: 24, cv: 0}, singerList: {module: 'Music.SingerListServer', method: 'get_singer_list', param: {area: -100, sex: -100, genre: -100, index: -100, sin: 0, cur_page: 1}}}
  const queryParams = Object.assign({}, commonParams, {
    needNewCode: 0,
    platform: 'yqq.json',
    sign: getSign(dataJson),
    data: JSON.stringify(dataJson)
  })
  return axios(url, queryParams)
}
