<template>
    <div class="all grid" style="flex-wrap: wrap;">
        <el-card style="width: 600px;height: 400px;">
            <div id="myChart" :style="{width: '580px', height: '400px'}"></div>
        </el-card>
        <el-card style="width: 1080px;height: 400px;margin-left: 20px">
            <div id="myChart2" :style="{width: '1080px', height: '380px'}"></div>
        </el-card>
        <el-card style="width: 99%;height: 430px;">
            <div id="myChart3" :style="{width: '100%', height: '420px'}"></div>
        </el-card>
    </div>

</template>

<script>
    import request from "../utils/request";
    import Stgrade from "./Stgrade";

    export default {
        name: "Homeecharts",
        components: {Stgrade},
        methods:{
            drawLine() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$root.echarts.init(document.getElementById('myChart'))
                let option = {
                    title: {
                        text: '各班级人数数据',
                        // subtext: '虚拟数据',
                        left: 'top',
                        textStyle: {
                            fontSize: 13
                        },
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        trigger: 'item'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    series: [
                        {
                            name: '学生人数',
                            type: 'pie',
                            radius: [20, 150],
                            center: ['50%', '50%'],
                            roseType: 'area',
                            itemStyle: {
                                borderRadius: 8
                            },
                            data: []
                        }
                    ]
                }
                request.get("/api/student/count").then(res => {
                    res.data.forEach(item => {
                        option.series[0].data.push({name: item.classid, value: item.count})
                    })
                    // 绘制图表
                    myChart.setOption(option);
                })
            },
            drawLine2() {
                // 基于准备好的dom，初始化echarts实例
                let myChart2 = this.$root.echarts.init(document.getElementById('myChart2'))
                let option2 = {
                    title: {
                        text: '各宿舍人数数据',
                        // subtext: '虚拟数据',
                        left: 'top',
                        textStyle: {
                            fontSize: 13
                        },
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: [],
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '学生人数',
                            type: 'bar',
                            barWidth: '60%',
                            data: []
                        }
                    ]
                };
                request.get("/api/student/count2").then(res => {
                    res.data.forEach(item => {
                        option2.series[0].data.push({value: item.count})
                        option2.xAxis[0].data.push({value: item.dormitoryid})
                    })
                    // 绘制图表
                    myChart2.setOption(option2);
                })
            },
            drawLine3() {
                // 基于准备好的dom，初始化echarts实例
                let myChart3 = this.$root.echarts.init(document.getElementById('myChart3'))
                let option3 = {
                    title: {
                        text: '各专业人数数据',
                        // subtext: '虚拟数据',
                        left: 'top',
                        textStyle: {
                            fontSize: 13
                        },
                    },
                    xAxis: [{
                        type: 'category',
                        data: []
                    }],
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            data: [],
                            type: 'line'
                        }
                    ]
                };
                request.get("/api/student/count3").then(res => {
                    res.data.forEach(item => {
                        option3.series[0].data.push({value: item.count})
                        option3.xAxis[0].data.push({value: item.classname})
                    })
                    // 绘制图表
                    myChart3.setOption(option3);
                })
            }

        },
        mounted(){
            this.drawLine()
            this.drawLine2()
            this.drawLine3()
        }
    }
</script>

<style scoped>

</style>
<style>

</style>