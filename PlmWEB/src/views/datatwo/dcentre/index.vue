<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>
<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import {zhuzhuangtu} from '@/api/plmApi'

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
      default: '280px'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      chart: null,
      histogramData: []
    }
  },
  watch: {
   monthData:{
      deep: true,
      handler() {
        this.setOptions()
      }
    }
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
    created() {
      this.selectData()
    },
    mounted(){
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
  methods: {
    selectData(){
      zhuzhuangtu().then(
        (response) => {
          this.histogramData = response.data.zhuzhuangtu;
          this.initChart()
        }
      ).catch(e => {
        
        console.log(e)
      })
    },


    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions()
    },
    setOptions() {
      this.chart.setOption({
        legend: {
          left: '80%',
          textStyle:{
                color: '#fff'//字体颜色
           },
        },
        tooltip: {
          backgroundColor:'rgba(255,255,255,1)',
        },
        grid:{
          left: '2%',
          right: '2%',
          top: '10%',
          bottom: '10%'
        },
        dataset: {
          source: this.histogramData
        },
        xAxis: { type: 'category',
                splitLine:{
                      show:false
                      }
              },
        yAxis: {
          splitLine:{
              show:false
              }
        },
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{ type: 'bar',
                   itemStyle:{
                    color:'#51d46d',
                    normal : {
                      label : {
                        show: true,
                        textStyle:{
                            color: '#fff'//字体颜色
                        }
                      }
                    }
                  }
                }, 
                 { type: 'bar',
                   itemStyle:{
                    color:'#51a0d4',
                    normal : {
                      label : {
                        show: true,
                        textStyle:{
                            color: '#fff'//字体颜色
                        }
                      }
                    }
                    }
                }
                ]
      })
    }
  }
}
</script>
