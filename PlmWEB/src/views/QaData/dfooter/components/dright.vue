<template>
  <div class="min partcomwithborder border">
    <div style="display: inline-block; width: 100%">
      <div class="user_skills">
          <el-table :data="tableData" class="top"  cell-style="font-weight: 700;color:#fff" :row-class-name="tableRowClassName" :header-cell-style="{background:'#19d2d8',color:'#000000'}">
            <el-table-column align="center" type="index" label="序号"  width="70px"/>
            <el-table-column align="center" prop="xiangmubianhao" label="项目编号"></el-table-column>
            <el-table-column align="center" prop="xiangmuName" label="项目名称"> </el-table-column>
            <el-table-column align="center" prop="xiangmuleixing" label="项目类型"></el-table-column>
            <el-table-column align="center" prop="renwumingcheng" label="任务名称" ></el-table-column>
            <el-table-column align="center" prop="fuzeren" label="负责人" ></el-table-column>
            <el-table-column align="center" prop="jieshushijian" label="预计完成时间"  ></el-table-column>
            <el-table-column align="center" prop="jindu" label="进度" ></el-table-column>
          </el-table>
  
          <vue-seamless-scroll :data="tableData" class="seamless-warp" :class-option="classOption" >
            <el-table :data="tableData" class="bottom"  cell-style="font-weight: 700;color:#fff" :row-class-name="tableRowClassName" :header-cell-style="{background:'#19d2d8',color:'#000000'}">
              <el-table-column align="center" type="index" label="序号"  width="70px"/> 
              <el-table-column align="center" prop="xiangmubianhao" label="项目编号"></el-table-column>
              <el-table-column align="center" prop="xiangmuName" label="项目名称"> </el-table-column>
              <el-table-column align="center" prop="xiangmuleixing" label="项目类型"></el-table-column>
              <el-table-column align="center" prop="renwumingcheng" label="任务名称" ></el-table-column>
              <el-table-column align="center" prop="fuzeren" label="负责人"></el-table-column>
              <el-table-column align="center" prop="jieshushijian" label="预计完成时间" ></el-table-column>
              <el-table-column align="center" prop="jindu" label="进度" ></el-table-column>
            </el-table>
          </vue-seamless-scroll>
      </div>
    </div>
  </div>
  </template>
  
  <script>
  import {selectPojNumFType} from '@/api/plmApi'
  
  export default {
    components: {
    
    },
    
  data() {
      return {
        tableData: [ ]
      }
    },
  
    created() {
       this.selectData()
      },
   computed: {
      classOption() {
          return {
            step: 0.5, // 数值越大速度滚动越快
            limitMoveNum: 4, // 无缝滚动的数据量
            hoverStop: true, // 是否开启鼠标悬停stop
            direction: 1, // 0向下 1向上 2向左 3向右
            openWatch: true, // 开启数据实时监控刷新dom
            singleHeight: 0, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
            singleWidth: 0, // 单步运动停止的宽度(默认值0是无缝不停止的滚动) direction => 2/3
            waitTime: 1000, // 单步运动停止的时间(默认值1000ms)
          };
        },
    },
  
    mounted(){
        //在mounted 声明周期中创建定时器
        const timer = setInterval(()=>{
          // 这里调用调用需要执行的方法，1为自定义的参数，由于特殊的需求它将用来区分，定时器调用和手工调用，然后执行不同的业务逻辑
          this.selectData();
        }, 3*60*1000) // 每五分钟执行1次
        // 通过$once来监听定时器，在beforeDestroy钩子可以被清除
        this.$once('hook:beforeDestroy',()=>{
          // 在页面销毁时，销毁定时器
          clearInterval(timer)
        })
      },
  
    methods: {
      handleSetLineChartData(type) {
        this.$emit('handleSetLineChartData', type)
      },
      viewdetial(){
        this.$router.push({name:'Weighdetailall'})
      },
      tableRowClassName({row, rowIndex}) {
        if (row.jindu == 0) {
          return 'warning-row';
        } 
        if (row.jindu >= 50 && row.jindu < 80 ) {
          return 'yellow-row';
        }
        return 'ok-row';
      },
      selectData(){
        selectPojNumFType().then(
          (response) => {
            this.tableData = response.data;
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
    height:343px;
     width: 100%;
  }
  .user_skills /deep/ .el-table--fit{
      padding: 5px;
  }
  .user_skills /deep/  .el-table, .el-table__expanded-cell {
      background-color: transparent;
  }
  
  
  .user_skills /deep/  .el-table--enable-row-transition .el-table__body td, .el-table .cell{
     background-color: transparent;
  }
  
  .user_skills /deep/ .el-table__body tr,
    .el-table__body td {
      padding: 0;
      height: 80px;
  }
  
  .user_skills /deep/ .el-table .warning-row {
    background:#d46051;
  }
  .user_skills /deep/ .el-table .yellow-row {
    background:#d3c506;
  }
  .user_skills /deep/ .el-table .ok-row {
      background: transparent!important;
  }
  .user_skills /deep/ .el-table tbody tr:hover>td { background-color: #1075ad }
  .el-table::before {//去除底部白线
     left: 0;
     bottom: 0;
     width: 100%;
     height: 0px;
  }
  >>>.seamless-warp {
      height: 400px;
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
    border: 3px solid #19d2d8; /*定义div的边框与边框颜色 */
  }
  //边框四角
  .partcomwithborder{
      background:
              linear-gradient(to bottom,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) left top no-repeat,
              linear-gradient(to right,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) left top no-repeat,
              linear-gradient(to bottom,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) right top no-repeat,
              linear-gradient(to left,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) right top no-repeat,
              linear-gradient(to top,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) left bottom no-repeat,
              linear-gradient(to right,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) left bottom no-repeat,
              linear-gradient(to top,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) right bottom no-repeat,
              linear-gradient(to left,#19d2d8 0px,#19d2d8 2px,transparent 3px,transparent 100%) right bottom no-repeat;
      background-size: 18px 18px;
      padding:2px;
  }
  </style>
  