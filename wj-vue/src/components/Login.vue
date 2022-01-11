<template>
  <body id="paper">
  <el-form ref="loginForm" :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="usersid">
      <el-input type="text" v-model="loginForm.usersid"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox class="login_remember" v-model="checked"
                 label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="login">登录</el-button>
      <el-button @click="resetForm('loginForm')" style="width: 40%;background: #505458;border: none">重置</el-button>
      <!--      <router-link to="register">-->
      <!--        <el-button type="primary" style="width: 40%;background: #505458;border: none">注册</el-button>-->
      <!--      </router-link>-->
    </el-form-item>
  </el-form>
  x
  </body>
</template>
<script>
export default {
  data () {
    return {
      rules: {
        usersid: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      checked: true,
      loginForm: {
        usersid: '',
        password: ''
      },
      loading: false
    }
  },
  methods: {
    login () {
      var _this = this
      this.$axios
        .post('/login', {
          usersid: this.loginForm.usersid,
          password: this.loginForm.password
        })
        .then(response => {
          console.log(response)
          if (response.data.flag === true) {

            _this.$store.commit('login', _this.loginForm)
            var path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})

          } else {
            this.$alert("账号或密码错误，请重新登陆！", '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {
        })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
<style>
#paper {
  background: url("../assets/img/bg/eva1.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
