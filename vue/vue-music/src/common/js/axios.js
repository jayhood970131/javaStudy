import Axios from 'axios'

export default function axios(url, data) {
  // url += (url.indexOf('?') < 0 ? '?' : '&') + param(data)

  // return new Promise((resolve, reject) => {
  //   Axios.get(url).then(response => {
  //     resolve(response)
  //   }).catch(err => {
  //     reject(err)
  //   })
  // })
  return Axios.get(url, {
    params: data
  })
}

// function param (data) {
//   let params = ''
//   for (var k in data) {
//     let value = data[k] !== undefined ? data[k] : ''
//     params += `&${k}=${encodeURIComponent(value)}`
//   }
//   return params ? params.substring(1) : ''
// }
