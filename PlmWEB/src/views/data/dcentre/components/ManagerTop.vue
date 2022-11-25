<template>
  <div class="partcomwithborder border user_skills">
    <el-table :data="tableData" max-height="350px" cell-style="font-weight: 700;color:#fff" :header-cell-style="{background:'#19d2d8',color:'#000000'}">
      <el-table-column align="center" prop="xiangmujinli" label="项目经理Top3" ></el-table-column>
    </el-table>
  </div>
</template>

<script>

import {youshangTop} from '@/api/plmApi'

export default {
  components: {
  
  },
  
data() {
    return {
      tableData: []
    }
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
    handleSetLineChartData(type) {
      this.$emit('handleSetLineChartData', type)
    },
    viewdetial(){
      this.$router.push({name:'Weighdetailall'})
    },
    selectData(){
      youshangTop().then(
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
/deep/.el-table__body .el-table__row.hover-row td {
  background-color: #10D7FF;
}
.user_skills /deep/ .el-table tbody tr:hover>td { background-color: #19d2d8 }
.el-table::before {//去除底部白线
	 left: 0;
	 bottom: 0;
	 width: 100%;
	 height: 0px;
}
>>>.seamless-warp {
    height: 245px;
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
