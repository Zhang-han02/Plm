<template>
  <div class="user_skills">
    <div class="partcomwithborder border">
      <el-table :data="PojData" style="width: 100%"  cell-style="font-weight: 700;color:#fff" :header-cell-style="{background:'#10D7FF',color:'#000000'}">
        <el-table-column align="center" prop="projectnum" label="项目总数"></el-table-column>
        <el-table-column align="center" prop="weiprojectnum" label="已完成数量"> </el-table-column>
        <el-table-column align="center" prop="weiwancheng" label="未完成数量"> </el-table-column>
        <el-table-column align="center" prop="baifenbi" label="已达成率"> </el-table-column>
      </el-table>
    </div>
    <div class="partcomwithborder border" style="margin-top:10px">
      <el-table :data="tableData" class="top"  cell-style="font-weight: 700;color:#fff" :header-cell-style="{background:'#10D7FF',color:'#000000'}">
        <el-table-column align="center" prop="typename" label="项目类型名称"></el-table-column>
        <el-table-column align="center" prop="projectnum" label="项目数量"> </el-table-column>
        <el-table-column align="center" prop="oknum" label="完成数量"> </el-table-column>
        <el-table-column align="center" prop="okbili" label="已达成率"> </el-table-column>
      </el-table>

      <vue-seamless-scroll :data="tableData" class="seamless-warp" :class-option="classOption" >
        <el-table :data="tableData" class="bottom"  cell-style="font-weight: 700;color:#fff" :header-cell-style="{background:'#10D7FF',color:'#000000'}">
          <el-table-column align="center" prop="typename" label="项目类型名称"></el-table-column>
          <el-table-column align="center" prop="projectnum" label="项目数量"> </el-table-column>
          <el-table-column align="center" prop="oknum" label="完成数量"> </el-table-column>
          <el-table-column align="center" prop="okbili" label="已达成率"> </el-table-column>
        </el-table>
      </vue-seamless-scroll>
    </div>
  </div>
</template>

<script>

import {zhongbiao,PojSum} from '@/api/plmApi'

export default {
  components: {
  
  },
  
data() {
    return {
      tableData: [],
      PojData:[]
    }
  },

created() {
  this.selectData();
  this.selectPoj();
     
    },
computed: {
    classOption() {
        return {
          step: 0.5, // 数值越大速度滚动越快
          limitMoveNum: 5, // 无缝滚动的数据量
          hoverStop: true, // 是否开启鼠标悬停stop
          direction: 1, // 0向下 1向上 2向左 3向右
          openWatch: false, // 开启数据实时监控刷新dom
          singleHeight: 0, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
          singleWidth: 0, // 单步运动停止的宽度(默认值0是无缝不停止的滚动) direction => 2/3
          waitTime: 1000, // 单步运动停止的时间(默认值1000ms)
        };
      },
  },

  methods: {
    handleSetLineChartData(type) {
      this.$emit('handleSetLineChartData', type)
    },
    viewdetial(){
      this.$router.push({name:'Weighdetailall'})
    },
    selectData(){
      zhongbiao().then(
        (response) => {
          this.tableData = response.data;
        }
      ).catch(e => {
        
        console.log(e)
      })
    },
    selectPoj(){
      PojSum().then(
        (response) => {
          this.PojData = response.data;
        }
      ).catch(e => {
        
        console.log(e)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.user_skills{
  height:350px;
  width: 100%;
}
.user_skills /deep/ .el-table--fit{
    padding: 5px;
}
.user_skills /deep/  .el-table, .el-table__expanded-cell {
    background-color: transparent;
}

.user_skills /deep/ .el-table tr {
    background-color: transparent!important;
}
.user_skills /deep/  .el-table--enable-row-transition .el-table__body td, .el-table .cell{
   background-color: transparent;
}
.user_skills /deep/ .el-table tbody tr:hover>td { background-color: #1075ad }
.el-table::before {//去除底部白线
	 left: 0;
	 bottom: 0;
	 width: 100%;
	 height: 0px;
}
>>>.seamless-warp {
    height: 165px;
    overflow: hidden;
    width: 100%
  }

 >>>.min {
  display: flex;
  width: 100%;
}
>>>.top .el-table__body-wrapper {
  display: none;
  width: 100%;
}
>>>.bottom .el-table__header-wrapper {
  display: none;
  width: 100%;
}
.border{
  border: 3px solid #10D7FF; /*定义div的边框与边框颜色 */
}
//边框四角
.partcomwithborder{
    background:
            linear-gradient(to bottom,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to right,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) left top no-repeat,
            linear-gradient(to bottom,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to left,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) right top no-repeat,
            linear-gradient(to top,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to right,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) left bottom no-repeat,
            linear-gradient(to top,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) right bottom no-repeat,
            linear-gradient(to left,#33cdfa 0px,#33cdfa 2px,transparent 3px,transparent 100%) right bottom no-repeat;
    background-size: 18px 18px;
    padding:2px;
}

</style>
