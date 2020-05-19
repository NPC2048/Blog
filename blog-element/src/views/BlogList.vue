<template>
  <el-card header="欢迎来到我的个人博客" class="el-card">
    <div v-for="item in list" :key="item.id">
      <el-row>
        <el-col :span="16">
          <el-row>
            <h3>{{ item.title }}</h3>
            <p class="describe">{{ item.description }}</p>
          </el-row>
          <el-row>
            <p class="content">{{ item.content }}</p>
            <p class="operator">
              <el-button type="text">
                <i class="ali-good"></i>
              </el-button>
              {{item.upCount}}
              <el-divider direction="vertical"/>
              <el-button type="text">
                <i class="ali-comments"></i>
              </el-button>
            </p>
          </el-row>
        </el-col>
        <el-col :span="8">
          <el-image src="https://dev-file.iviewui.com/5wxHCQMUyrauMCGSVEYVxHR5JmvS7DpH/large"/>
        </el-col>
      </el-row>
      <el-divider/>
    </div>
  </el-card>
</template>
<script>
  export default {
    name: 'blogList',
    watch: {
      $route() {
        this.getList()
      }
    },
    data() {
      return {
        list: []
      }
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        this.get("/blog/list").then((data) => {
          this.list = data.records;
        })
      },
    }
  }
</script>
<style>
  .operator {
    font-size: 12px;
    color: lightgrey;
  }

  .el-card {
    width: 80%;
    margin: 0 auto;
  }

  .describe {
    color: lightgray;
    font-size: 12px;
  }

  .content {
    font-size: 14px;
  }
</style>
