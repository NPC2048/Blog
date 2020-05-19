<template>
  <el-card class="el-card">
    <UserFormHeader />
    <el-form ref="loginForm" :model="loginForm" :rules="rules">
      <el-form-item prop="username">
        <el-input v-model="loginForm.username" prefix-icon="el-icon-user" placeholder="请输入用户名或邮箱"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password></el-input>
      </el-form-item>
      <el-row type="flex" justify="space-between" >
        <el-col :span="8">
          <el-form-item>
            <el-switch></el-switch>
            记住我
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-popover placement="bottom" trigger="click">
<!--            <el-button type="text" class="text-default" @click="test">用手机号找回</el-button>-->
<!--            <el-divider />-->
            <el-button type="text" class="text-default">用邮箱找回</el-button>
            <el-button type="text" slot="reference" class="text-default">登录遇到问题？</el-button>
          </el-popover>
        </el-col>
      </el-row>
      <el-button type="primary" round @click="submitForm('loginForm')" class="login">登录</el-button>
    </el-form>
  </el-card>
</template>
<script>
  import Qs from 'qs';
  import UserFormHeader from './UserFormHeader';

  export default {
    data() {
      return {
        loginForm: {
          username: '',
          password: '',
        },
        rules:{
          username:[
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          password: [
            {required:true, message:'请输入密码',trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      login() {
        this.$axios.post("/login", Qs.stringify(this.$data.loginForm)).then(data => {
          this.$message.info("登录成功");
          this.$store.state.token = data;
          // 跳转到首页
          this.$router.push("/")
        });
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            return false;
          }
          this.login();
        });
      }
    },
    components: {
        UserFormHeader
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
</style>
