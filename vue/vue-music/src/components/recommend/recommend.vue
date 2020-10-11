<template>
  <div class="recommend">
    <div class="recommend-content">
      <div v-if="recommends.length" class="slider-wrapper" >
        <slider>
          <div v-for="(item,index) in recommends" :key="index">
            <a :href="item.linkData.linkUrl">
              <img :src="item.linkData.linkPicUrl">
            </a>
          </div>
        </slider>
      </div>
      <div class="recommend-list">
        <h1 class="list-title">热门歌单推荐</h1>
        <ul>
          <li v-for="(item, index) in playlist" :key="index" class="item">
            <div class="icon">
              <img :src="item.image" width="60" height="60">
            </div>
            <div class="text">
              <h2 class="name" v-text="item.playlistName"></h2>
              <p class="desc" v-text="item.playlistName"></p>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  import Slider from '../../base/slider/slider'
  import {getRecommend, getPlaylist} from '../../api/recommend-migu'
  import {ERR_OK} from '../../api/config-migu'

  export default {
    data() {
      return {
        recommends: [],
        playlist: []
      }
    },
    created () {
      this._getRecommend()
      this._getPlaylist()
    },
    methods: {
      _getRecommend() {
          getRecommend().then(res => {
            if (res.statusText === ERR_OK) {
              this.recommends = res.data.result.results
            } else {
              console.log('无效轮播图数据')
            }
          }).catch(err => {
            console.log(err)
          })
        },
      _getPlaylist() {
        getPlaylist().then(res => {
          if (res.statusText === ERR_OK) {
            this.playlist = res.data.msg
          } else {
            console.log('无效歌单数据')
          }
        })
      }
    },
    components: {
      Slider
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"
  .recommend
    position: fixed
    width: 100%
    top: 88px
    bottom: 0
    .recommend-content
      height: 100%
      overflow: hidden
      .slider-wrapper
        position: relative
        width: 100%
        overflow: hidden
      .recommend-list
        .list-title
          height: 65px
          line-height: 65px
          text-align: center
          font-size: $font-size-medium
          color: $color-theme
        .item
          display: flex
          box-sizing: border-box
          align-items: center
          padding: 0 20px 20px 20px
          .icon
            flex: 0 0 60px
            width: 60px
            padding-right: 20px
          .text
            display: flex
            flex-direction: column
            justify-content: center
            flex: 1
            line-height: 20px
            overflow: hidden
            font-size: $font-size-medium
            .name
              margin-bottom: 10px
              color: $color-text
            .desc
              color: $color-text-d
      .loading-container
        position: absolute
        width: 100%
        top: 50%
        transform: translateY(-50%)
</style>
