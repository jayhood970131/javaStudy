<template>
  <transition name="slide">
    <music-list :songs="songs" :title="title" :bg-image="bgImage"></music-list>
  </transition>
</template>

<script type="text/ecmascript-6">
  import {createSong} from '../../common/js/song'
  import {getSingerDetail} from '../../api/singer-qq'
  import {ERR_OK} from '../../api/config-qq'
  import {mapGetters} from 'vuex'
  import MusicList from '../music-list/music-list'
  export default {
    components: {MusicList},
    data() {
      return {
        songs: []
      }
    },
    computed: {
      title() {
        return this.singer.name
      },
      bgImage() {
        return this.singer.pic
      },
      ...mapGetters([
        'singer'
      ])
    },
    created () {
      this._getDetail()
    },
    methods: {
      _getDetail() {
        if (!this.singer.mid) {
          this.$router.push('/singer')
          return
        }
        getSingerDetail(this.singer.mid).then(res => {
          if (res.data.code === ERR_OK) {
            this.songs = this._normalizeSongs(res.data.singerSongList.data.songList)
          }
        })
      },
      _normalizeSongs(list) {
        let ret = []
        list.forEach(item => {
          if (item.songInfo.mid && item.songInfo.album.mid) {
            ret.push(createSong(item))
          }
        })
        return ret
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .slide-leave-active, .slide-enter-active
    transition: all 0.3s

  .slide-leave-to, .slide-enter
    transform: translate3d(100%, 0, 0)
</style>
