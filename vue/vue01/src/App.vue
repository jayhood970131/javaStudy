<template>
  <div id="app">
    <el-container>
<!--      左侧导航-->
      <el-aside width="200px">
        <el-menu
                default-active="1"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                router>

          <el-menu-item index="/home">
            <i class="el-icon-menu"></i>
            <span slot="title">首页</span>
          </el-menu-item>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>应用管理</span>
            </template>
            <el-menu-item index="/application">选项1</el-menu-item>
            <el-menu-item index="/about">选项2</el-menu-item>
          </el-submenu>

          <el-menu-item index="/config">
            <i class="el-icon-setting"></i>
            <span slot="title">配置管理</span>
          </el-menu-item>


        </el-menu>
      </el-aside>
<!--      左侧导航 end-->
      <el-container>
<!--        头部-->
        <el-header>Header</el-header>
<!--        主体-->
        <el-main><router-view/></el-main>
<!--        尾部-->
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

</style>
