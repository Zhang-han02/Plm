<template>
  <div class="data-page">
    <dheader></dheader>

    <dcentre></dcentre>
    <div style="margin-left:10px;margin-right:10px">
        <dfooter></dfooter>
    </div>

   
  </div>
</template>

<script>
import dheader from "./dheader";
import dcentre from "./dcentre";
import dfooter from "./dfooter";


export default {
  name: 'indexv2',
  components: {
    dheader,
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
  min-width: 1220px;
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
</style>
