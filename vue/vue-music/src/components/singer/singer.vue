<template>
  <div class="singer">
    <listview @select="selectSinger" :data="singers" ></listview>
    <router-view></router-view>
  </div>
</template>

<script type="text/ecmascript-6">
  import Listview from '../../base/listview/listview'
  import {getSingerList} from '../../api/singer-qq'
  import Singer from '../../common/js/singer'
  import {ERR_OK} from '../../api/config-qq'
  import {mapMutations} from 'vuex'

  const HOT_NAME = '热门'
  const EXTRA_NAME = '#'

  export default {
    data() {
      return {
        singers: []
      }
    },
    created () {
      this._getSingerList()
    },
    methods: {
      selectSinger(singer) {
        this.$router.push({
          path: `/singer/${singer.name}`
        })
        this.setSinger(singer)
      },
      _getSingerList() {
        getSingerList().then(res => {
          if (res.data.code === ERR_OK) {
            this.singers = this._normalizeSingerList(res.data.singerList.data)
          }
        })
      },
      _normalizeSingerList(list) {
        let map = {
          hot: {
            title: HOT_NAME,
            items: []
          }
        }
        if (list.index === -100) {
          for (let singerItem of list.singerlist) {
            map.hot.items.push(new Singer({
              name: singerItem.singer_name,
              pic: singerItem.singer_pic
            }))
          }
        }
        // 为了得到有序列表，我们需要处理map
        let hot = []
        let extra = []
        let ret = []
        for (let key in map) {
          let val = map[key]
          if (val.title.match(/[a-zA-Z]/)) {
            ret.push(val)
          } else if (val.title === HOT_NAME) {
            hot.push(val)
          } else if (val.title === EXTRA_NAME) {
            extra.push(val)
          }
        }
        ret.sort((a, b) => {
          return a.title.charCodeAt(0) - b.title.charCodeAt(0)
        })
        return hot.concat(ret, extra)
      },
      ...mapMutations({
        setSinger: 'SET_SINGER'
      })
    },
    components: {
      Listview
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .singer
    position: fixed
    top: 88px
    bottom: 0
    width: 100%
</style>
