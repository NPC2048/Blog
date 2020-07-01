<template>
  <el-card class="el-card">
    <UserFormHeader></UserFormHeader>
    <el-form ref="registerForm" :model="registerForm" :rules="rules">
      <el-form-item prop="email">
        <el-input v-model="registerForm.email" prefix-icon="el-icon-message" placeholder="请输入邮箱"/>
      </el-form-item>
      <el-form-item prop="username">
        <el-input v-model="registerForm.username" prefix-icon="el-icon-user" placeholder="请输入用户名"/>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="registerForm.password" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password/>
      </el-form-item>
      <el-form-item prop="confirmPassword">
        <el-input v-model="registerForm.confirmPassword" prefix-icon="el-icon-lock" placeholder="请确认密码" show-password/>
      </el-form-item>
      <el-form-item prop="verifyCode">
        <el-row justify="center">
          <el-col :span="16">
            <el-input v-model="registerForm.verifyCode" prefix-icon="el-icon-lock" placeholder="请输入验证码" show-password/>
          </el-col>
          <el-col :span="8">
            <el-button ref="getMailCode" @click="getMailCode('registerForm')">获取验证码</el-button>
          </el-col>
        </el-row>
      </el-form-item>
      <el-button type="primary" round @click="submitForm('registerForm')" class="login">注册</el-button>
    </el-form>
  </el-card>
</template>
<script>
  import Qs from 'qs';
  import UserFormHeader from './UserFormHeader';

  export default {
    data() {
      return {
        registerForm: {
          email: '',
          username: '',
          password: '',
          confirmPassword: '',
          verifyCode: '',
        },
        rules: {
          email: [
            {required: true, message: '请输入邮箱', trigger: 'blur'},
            {type: 'email', message: '邮箱格式错误', trigger: 'blur'}
          ],
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
          confirmPassword: [
            {required: true, message: '请确认密码', trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      login() {
        this.$axios.post("/register", Qs.stringify(this.$data.registerForm)).then(data => {
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
          // 判断两次数据的密码是否正确
          this.login();
        });
      },
      getMailCode(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            return false;
          }
          // this.$refs.getMailCode.loading=true;
          // this.$axios.post("/send_mail_verify_code", Qs.stringify(this.$data.registerForm)).then(data => {
          //   this.$message.info("获取验证码成功");
          //   this.$message.info(JSON.stringify(data));
          //   // 禁用发送验证码按钮
          //
          // });
        })
      }
    },
    components: {UserFormHeader}
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
