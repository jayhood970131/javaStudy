export default function axios(url, data) {
  url += (url.indexOf('?') < 0 ? '?' : '&') + param(data)
  return url
}

function param (data) {
  let params = ''
  for (var k in data) {
    let value = data[k] !== undefined ? data[k] : ''
    params += `&${k}=${encodeURIComponent(value)}`
  }
  return params ? params.substring(1) : ''
}
