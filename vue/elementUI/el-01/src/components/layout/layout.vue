<template>
    <div>
      <h1>布局组件的使用</h1>
      <el-row>
        <el-col :span="6">占用6份</el-col>
        <el-col :span="6">占用6份</el-col>
        <el-col :span="6">占用6份</el-col>
        <el-col :span="6">占用6份</el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "layout"
    }
</script>

<style scoped>

</style>
