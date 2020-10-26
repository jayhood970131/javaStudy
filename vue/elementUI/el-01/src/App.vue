<template>
  <div id="app">
    <a href="/button">点我显示button</a>
    <a href="/buttonDetail">按钮的详细使用</a>
    <a href="/layout">布局组件</a>
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style>
</style>
