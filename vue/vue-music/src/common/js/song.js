export default class Song {
  constructor ({mid, singer, name, album, duration, image}) {
    this.mid = mid
    this.singer = singer
    this.name = name
    this.album = album
    this.duration = duration
    this.image = image
  }
}

export function createSong (musicData) {
  return new Song({
    mid: musicData.songInfo.mid,
    singer: filterSinger(musicData.songInfo.singer),
    name: musicData.songInfo.name,
    album: musicData.songInfo.album.name,
    duration: musicData.songInfo.interval,
    image: `https://y.gtimg.cn/music/photo_new/T002R300x300M000${musicData.songInfo.album.mid}_1.jpg?max_age=2592000`
  })
}

function filterSinger (singer) {
  let ret = []
  if (!singer) {
    return
  }
  singer.forEach(s => {
    ret.push(s.name)
  })
  return ret.join('/')
}
