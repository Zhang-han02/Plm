<template>
  <el-row :gutter="10" class="panel-group">
    <el-col  :lg="6" class="card-panel-col">
      <div class="partcomwithborder border" style="margin-left:10px">
          <pie-chart></pie-chart>
      </div>
    </el-col>
    <el-col  :lg="9" class="card-panel-col">
      <poj-number></poj-number>
    </el-col>
    <el-col  :lg="7" class="card-panel-col">
        <poj-manager></poj-manager>
    </el-col>
    <el-col  :lg="2" class="card-panel-col" style="width:7.2%">
        <manager-top></manager-top>
    </el-col>
  </el-row>
</template>

<script>
import PieChart from './components/PieChart'
import PojNumber from './components/PojNumber'
import PojManager from './components/PojManager'
import ManagerTop from './components/ManagerTop'


export default {
  components: {
    PieChart,
    PojNumber,
    PojManager,
    ManagerTop
  },
  
data() {
    return {
      formData:[]
    }
  },

  created() {
      
    },
  methods: {
    handleSetLineChartData(type) {
      this.$emit('handleSetLineChartData', type)
    },
    viewdetial(){
      this.$router.push({name:'Weighdetailall'})
    },
    findPound(){
      findPound().then(
        (response) => {
          this.formData = response.content;
        }
      ).catch(e => {
        
        console.log(e)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.bbttom{
  border-bottom: 1px solid #000;

}
.panel-group {
  margin-top: 9px;
  height: 100%;

  .card-panel-col {
    margin-bottom: 5px;
  }

  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);

    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }

      .icon-people {
        background: #40c9c6;
      }

      .icon-message {
        background: #36a3f7;
      }

      .icon-money {
        background: #f4516c;
      }

      .icon-shopping {
        background: #34bfa3
      }
    }

    .icon-people {
      color: #40c9c6;
    }

    .icon-message {
      color: #36a3f7;
    }

    .icon-money {
      color: #f4516c;
    }

    .icon-shopping {
      color: #34bfa3
    }

    .card-panel-icon-wrapper {
      float: left;
      margin: 14px 0 0 14px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }

    .card-panel-icon {
      float: left;
      font-size: 48px;
    }

    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;

      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }

      .card-panel-num {
        font-size: 20px;
      }
    }
  }
}

@media (max-width:550px) {
  .card-panel-description {
    display: none;
  }

  .card-panel-icon-wrapper {
    float: none !important;
    width: 100%;
    height: 100%;
    margin: 0 !important;

    .svg-icon {
      display: block;
      margin: 14px auto !important;
      float: none !important;
    }
  }
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
