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
      default: '400px'
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
  mounted() {
    this.$nextTick(() => {
      //this.initChart()
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
          this.histogramData = response.data;
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
          right: '1%',
          top: '10%',
          bottom: '10%'
        },
        dataset: {
          source: this.histogramData
        },
        xAxis: { type: 'category' },
        yAxis: {},
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{ type: 'bar' }, { type: 'bar' }]
      })
    }
  }
}
</script>
