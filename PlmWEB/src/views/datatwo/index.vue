<template>
  <div class="data-page">
    <dheader></dheader>

    
    <div class="partcomwithborder border" >
      <dtitle></dtitle>
    </div>
   
    <div class="partcomwithborder border" style="margin-top:15px" >
      <dcentre></dcentre>
    </div>
    <div style="margin-top:15px" >
      <dfooter></dfooter>
    </div>

   
  </div>
</template>

<script>
import dheader from "./dheader";
import dtitle from "./dtitle";
import dcentre from "./dcentre";
import dfooter from "./dfooter";


export default {
  name: 'indexv2',
  components: {
    dheader,
    dtitle,
    dcentre,
    dfooter
  },

  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.data-page {
  background: url(../../assets/data/true.png) repeat-x;
  top: 0;
  right: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  //min-width: 1220px;
  .data-content {
    padding-bottom: 20px;
    .data-time {
      width: 340px;
      height: 35px;
      background-color: #2c58a6;
      line-height: 35px;
      color: #fff;
      font-size: 12.8px;
      margin-bottom: 25px;
      margin-left: 20px;
      text-align: center;
    }
    .data-main {
      width: calc(100% - 40px);
      margin-bottom: 40px;
      margin-left: 20px;
      height: 720px;

      .main-left {
        width: 24%;
        float: left;
      }
      .main-center {
        float: left;
        width: 52%;
        padding: 0 20px 0 20px;
      }
      .main-right {
        float: left;
        width: 24%;
        height: 615px;
      }
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
