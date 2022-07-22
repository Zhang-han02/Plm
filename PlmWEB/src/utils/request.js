import axios from "axios";

const instance = axios.create({
    baseURL: process.env.BASE_API, // 请求基地址 
    timeout: 50000 // 请求超时
})

// 请求拦截器
instance.interceptors.request.use(config => {
    // 请求配置
    return config
}, error=> {
   return Promise.reject(error)
})

// 响应拦截器
instance.interceptors.response.use(data => {
    // 响应数据处理
    // 这个data.data是去除axios封装的外层
    return data.data
},error => {
    // 这里统一处理响应报错 提示框内容
    return Promise.reject(error)
})

export default instance