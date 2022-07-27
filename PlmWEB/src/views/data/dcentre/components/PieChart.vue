<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import { debounce } from '@/utils'
import {PojProportion} from '@/api/plmApi'

export default {
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '350px'
    }
  },
  data() {
    return {
      chart: null,
      picData:[]
    }
  },
  created() {
  this.selectData();
  },
  mounted() {
    //this.initChart()
    this.__resizeHandler = debounce(() => {
      if (this.chart) {
        this.chart.resize()
      }
    }, 100)
    window.addEventListener('resize', this.__resizeHandler)

    //在mounted 声明周期中创建定时器
      const timer = setInterval(()=>{
        // 这里调用调用需要执行的方法，1为自定义的参数，由于特殊的需求它将用来区分，定时器调用和手工调用，然后执行不同的业务逻辑
        this.selectData();
      }, 5*60*1000) // 每五分钟执行1次
      // 通过$once来监听定时器，在beforeDestroy钩子可以被清除
      this.$once('hook:beforeDestroy',()=>{
        // 在页面销毁时，销毁定时器
        clearInterval(timer)
      })
  },

  beforeDestroy() {
    if (!this.chart) {
      return
    }
    window.removeEventListener('resize', this.__resizeHandler)
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    selectData(){
        PojProportion().then(
        (response) => {
          this.picData = response.data;
          this.initChart()
        }
      ).catch(e => {
        
        console.log(e)
      })
    },
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
         title: {
          text: '项目类型占比',
          left: 'center',
          textStyle:{
                color: '#fff'//字体颜色
           },
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b} : {c} ({d}%)',
          backgroundColor:'rgba(255,255,255,1)',
        },
        legend: {
          orient: 'vertical',
          left: 'left',
          textStyle:{
                color: '#fff'//字体颜色
           },
        },
        textStyle:{
          color:'#000000'
        },
        series: [
          {
            type: 'pie',
            radius: '40%',
            label: {
              formatter: '{b}: {@2012} ({d}%)',
              textStyle:{
                color: '#fff'//字体颜色
              },
            },
            
            data: this.picData,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(137, 52, 52, 1)'
              }
            }
          }
        ]
      })
    }
  }
}
</script>


