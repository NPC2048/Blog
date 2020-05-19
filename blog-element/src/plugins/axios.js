import {Message} from "element-ui";
import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";
import store from '../store/index';

Vue.use(VueAxios, axios);

// 接口 url
axios.defaults.baseURL = process.env.VUE_APP_BASE_URL;
// 超时时间，7 秒视为超时
axios.defaults.timeout = 7000;
axios.defaults.withCredentials = true;

// 拦截 request
axios.interceptors.request.use(config => {
  // config.data = JSON.stringify((config.data));
  config.headers = {
    "Content-Type": "application/x-www-form-urlencoded"
  };

  if (store.state.token) {
    config.headers.Authorization = store.state.token;
  }
  return config;
}, error => {
  return Promise.reject(error);
});

// 拦截 response
axios.interceptors.response.use(response => {
  let data = response.data;
  if (!data.state) {
    Message.error(data.msg);
    throw new Error(data.msg);
  }
  return data;
}, error => {
  if (error && error.response) {
    switch (error.response.status) {
      case 400:
        Message.error("错误请求");
        break;
      case 401:
        Message.info(JSON.stringify(error.response));
        Message.error("未授权，请重新登录");
        break;
      case 403:
        Message.error("拒绝访问");
        break;
      case 404:
        Message.error("未找到该资源");
        break;
      case 405:
        Message.error("请求方法错误");
        break;
      case 408:
        Message.error("请求超时");
        break;
      case 500:
        Message.error("服务器错误");
        break;
      case 501:
        Message.error("网络未实现");
        break;
      case 502:
        Message.error("网络错误");
        break;
      case 503:
        Message.error("服务不可用");
        break;
      case 504:
        Message.error("网络超时");
        break;
      case 505:
        Message.error("http版本不支持");
        break;
      // 自定义状态码
      case 1000:
        Message.error("用户名不能为空");
        break;
      case 1001:
        Message.error("密码不能为空");
        break;
      case 1002:
        Message.error("用户名或密码错误");
        break;
      default:
        Message.error("连接错误");
    }
  } else {
    Message.error(`连接错误: ${error}`)
  }
  return Promise.reject(error.response);
});

// 封装自定义方法
export function get(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios.get(url, {params: params})
      .then(response => {
        resolve(response.data);
      }).catch(error => {
      reject(error);
    })
  })
}

export function post(url, data = {}) {
  return new Promise(((resolve, reject) => {
    axios.post(url, data).then(response => {
      resolve(response.data);
    }).catch((error) => {
      reject(error);
    })
  }))
}

Vue.prototype.get = get;
Vue.prototype.post = post;
Vue.prototype.$axios = axios;
