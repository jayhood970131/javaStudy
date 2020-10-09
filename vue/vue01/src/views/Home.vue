<template>
  <div class="home">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="12" :md="6" :lg="6" :xl="6"><el-image :src="src"></el-image></el-col>
      <el-col :span="24">
        <div id="chart" style="width: 100%;height: 400px;"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  name: 'Home',
  data() {
    return {
      src: require('../assets/logo.png')
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      var  myChart = this.$echarts.init(document.getElementById('chart'));
      var option = {
        title: {
          text: '第一个 ECharts 实例'
        },
        tooltip: {},
        legend: {
          data:['销量']
        },
        xAxis: {
          data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20]
        }]
      };
      myChart.setOption(option)
    }
  }
}
</script>
