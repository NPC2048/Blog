<template>
  <div id="app">
    <el-container class="el-container">
      <el-header class="el-header">
        <!-- 路由加载区 -->
        <el-main class="el-main">
          <router-view/>
        </el-main>
        <!-- 底部信息栏 -->
        <el-footer class="el-footer">
          © 2020 <a href="http://www.miit.gov.cn/" target="_blank">粤ICP备 19015296 号</a>
        </el-footer>
      </el-header>
    </el-container>
  </div>
</template>
<script>
  export default {
    name: 'app',
    data() {
      return {

      };
    },
    methods: {

    }
  }
</script>
<style scoped>
  .el-card {
    text-align: center;
    width: 350px;
    margin: 0 auto;
  }

  .login {
    width: 85%;
  }

  .text-default {
    color: #000;
  }

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
