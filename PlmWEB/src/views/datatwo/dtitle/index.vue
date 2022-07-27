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
      default: '150px'
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
      xinzengData: [],
      wanchengData: []
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
  methods: {
    selectData(){
      zhuzhuangtu().then(
        (response) => {
          this.xinzengData = response.data.zhexiantu[0];
          this.wanchengData = response.data.zhexiantu[1];
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
        
        title: {
          
        },
        tooltip: {
            trigger: 'axis',
            backgroundColor:'rgba(255,255,255,1)'
        },
        legend: {
            data: ['新增项目数量', '已完成数'],
            left: '80%',
            textStyle:{
                color: '#fff'//字体颜色
            },
        },
        grid: {
            backgroundColor:'#51d46d',
            left: '2%',
            right: '2%',
            top: '15%',
            bottom: '15%'
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            splitLine:{
              show:false
              }
        },
        yAxis: {
            type: 'value',
            splitLine:{
              show:false
              }
        },
        series: [
            {
            name: '新增项目数量',
            type: 'line',
            data: this.xinzengData,
            itemStyle : {
								normal : {
                  label : {
                    show: true,
                    textStyle:{
                        color: '#fff'//字体颜色
                    }
                  },
									lineStyle:{
										color:'#51d46d'
									}
								}
              }
            },
            {
            name: '已完成数',
            type: 'line',
            data: this.wanchengData,
            itemStyle : {
								normal : {
                  label : {
                    show: true,
                    textStyle:{
                        color: '#fff'//字体颜色
                    }
                  },
									lineStyle:{
										color:'#51a0d4'
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
