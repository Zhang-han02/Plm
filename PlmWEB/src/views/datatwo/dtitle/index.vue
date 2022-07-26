<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>
<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme

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
      default: '200px'
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
  mounted() {
    this.$nextTick(() => {
      this.initChart()
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
      
    },
  methods: {


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
            left: 'right',
          textStyle:{
                color: '#fff'//字体颜色
           },
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
            name: '新增项目数量',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210,101, 134, 90, 230, 210]
            },
            {
            name: '已完成数',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310,182, 191, 234, 290, 330]
            }
            
        ]
      })
    }
  }
}
</script>
