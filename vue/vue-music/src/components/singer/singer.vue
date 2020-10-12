<template>
  <div class="singer">
    <listview :data="singers"></listview>
  </div>
</template>

<script type="text/ecmascript-6">
  import Listview from '../../base/listview/listview'
  import {getSingerList} from '../../api/singer-qq'
  import {ERR_OK} from '../../api/config-qq'

  export default {
    data() {
      return {
        singers: []
      }
    },
    props: {
      singerIndex: {
        type: Array,
        default: () => {
          return [-100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]
        }
      }
    },
    created () {
      this._getSingerList()
    },
    methods: {
      _getSingerList() {
        getSingerList().then(res => {
          if (res.data.code === ERR_OK) {
            this.singers = res.data.singerList.data.singerlist
          }
        })
      },
      _normalizeSingerList() {

      }
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
