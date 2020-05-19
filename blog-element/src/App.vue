<template>
  <div id="app">
    <el-container class="el-container">
      <!-- 头部导航栏 -->
      <el-header class="el-header">
        <!-- logo -->
        <!-- 导航-->
        <el-menu class="el-menu" mode="horizontal" default-active="/" router>
          <el-menu-item index="/" class="index">首页</el-menu-item>
          <el-menu-item index="/java">Java</el-menu-item>
          <el-menu-item index="/spring">Spring</el-menu-item>
          <el-menu-item route="tools.liangyuelong.com">小工具</el-menu-item>
          <el-menu-item style="border: none">
            <i class="el-icon-search" @click="search"></i>
            <el-input v-model="keyword" placeholder="请输入内容" @change="search"/>
          </el-menu-item>
          <el-menu-item index="/login" style="border: none; float: right">
            <i class="el-icon-user"></i>
            登录
          </el-menu-item>
        </el-menu>
      </el-header>
      <!-- 路由加载区 -->
      <el-main class="el-main">
        <router-view/>
      </el-main>
      <!-- 底部信息栏 -->
      <el-footer class="el-footer">
        © 2020 <a href="http://www.miit.gov.cn/" target="_blank">粤ICP备 19015296 号</a>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        keyword: ''
      }
    },
    methods: {
      search() {
        this.$message.info("hello world")
      }
    }
  }
</script>
<style>

  a {
    text-decoration-line: none;
  }

  a:visited {
    color: #000;
  }

  .index {
    font-size: 18px;
  }

  .el-footer {
    display: inline-block !important;
    font-size: 12px;
    text-align: center;
  }

  .el-footer a {
    color: #000;
  }

  .el-footer a:hover {
    color: #409eff;
  }

  .el-main {
    height: 75vh;
  }

  ::-webkit-scrollbar {
    width: 8px; /*滚动条宽度*/
    height: 8px;
  }

  /*定义滚动条轨道 内阴影+圆角*/
  ::-webkit-scrollbar-track {
    border-radius: 10px; /*滚动条的背景区域的圆角*/
    background-color: transparent; /*滚动条的背景颜色*/
  }

  /*定义滑块 内阴影+圆角*/
  ::-webkit-scrollbar-thumb {
    border-radius: 10px; /*滚动条的圆角*/
    background-color: lightgrey; /*滚动条的背景颜色*/
  }
</style>
