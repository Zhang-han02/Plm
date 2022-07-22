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
      tableData:[
           
                ],
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
          this.tableData = response.data;
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
          backgroundColor:'rgba(255,255,255,0.8)',
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
            data: this.tableData,
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


