<template>
  <div id="app">
    <m-header></m-header>
    <tab></tab>
    <keep-alive>
    <router-view></router-view>
    </keep-alive>
    <player @next="nextSong" @prev="prevSong"></player>
  </div>
</template>

<script type="text/ecmascript-6">
  import MHeader from 'components/m-header/m-header'
  import Tab from './components/tab/tab'
  import Player from './components/player/player'
  import {mapGetters, mapMutations} from 'vuex'
  import {getPlaySongVkey} from './api/singer-qq'
  import {ERR_OK} from './api/config-qq'

  export default {
    computed: {
      ...mapGetters([
        'playlist'
      ])
    },
    methods: {
      prevSong(index) {
        let me = this
        getPlaySongVkey(this.playlist[index].mid).then(function (res) {
          if (res.data.code === ERR_OK) {
            let url = res.data.req_0.data.sip[0] + res.data.req_0.data.midurlinfo[0].purl
            me.setCurrentUrl(url)
            me.setCurrentIndex(index)
          }
        })
      },
      nextSong(index) {
        let me = this
        getPlaySongVkey(this.playlist[index].mid).then(function (res) {
          if (res.data.code === ERR_OK) {
            let url = res.data.req_0.data.sip[0] + res.data.req_0.data.midurlinfo[0].purl
            me.setCurrentUrl(url)
            me.setCurrentIndex(index)
          }
        })
      },
      ...mapMutations({
        setCurrentIndex: 'SET_CURRENT_INDEX',
        setCurrentUrl: 'SET_CURRENT_URL'
      })
    },
    components: {
      MHeader,
      Tab,
      Player
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"
  #app
    color : $color-theme
</style>
