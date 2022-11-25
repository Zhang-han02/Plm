<template>
  <el-row :gutter="10" class="panel-group">
    <!-- <el-col :xs="12" :sm="12" :lg="12" class="card-panel-col">
        <dleft></dleft>
    </el-col> -->
    <!-- <el-col :xs="12" :sm="12" :lg="12" class="card-panel-col">
      <dright></dright>
    </el-col> -->
    <dright></dright>
  </el-row>
</template>

<script>
import dleft from './components/dleft'
import dright from './components/dright'
import dfooter from "../../datatwo/dfooter";


export default {
  components: {
    dleft,
    dright,
    dfooter
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

</style>
