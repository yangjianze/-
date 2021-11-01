<template>
    <div class="all">
        <div>
            <el-carousel :interval="3000" :pause-on-hover="false" type="card" height="350px">
                <el-carousel-item v-for="item in imgList" :key="item.url" style="background-color: #ffcf40;border-radius: 15px;box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04)">
                    <img :src="item.url" style="width: 100%;" />
                </el-carousel-item>
            </el-carousel>
        </div>

        <div>
            <el-card class="box-card" shadow="hover" style="width: 96%;margin-left: 2%;height: 450px;border-radius: 15px">
                <template #header>
                    <div class="card-header grid" style="position: relative">
<!--                        <h2 style="position: absolute;top: 5px">{{newDate}}</h2>-->
                        <FlipClock></FlipClock>
                        <div id="weather" style="position: absolute;right: 10px;">
                            <iframe allowtransparency="true" frameborder="0" width="410" height="50" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=&ltf=009944&htf=cc0000&q=0&e=1&a=0&c=53698&w=410&h=64&align=center"></iframe>
                        </div>
                        <el-button class="button" type="text"></el-button>
                    </div>
                </template>
                <div class="grid" style="position: relative">
                    <el-calendar style="width: 480px;position: absolute;top: -20px">
                        <template #dateCell="{ data }" style="height: 400px;">
                            <p style="line-height: 20px" :class="data.isSelected ? 'is-selected' : ''">
                                {{ data.day.split('-').slice(1).join('-') }}
                                {{ data.isSelected ? '✔️' : '' }}
                            </p>
                        </template>
                    </el-calendar>
                    <div style="margin:0 auto;width: 300px;height: 300px;">
                        <ul style="text-decoration-line: none;list-style-type: none;">
                            <li><el-tag>编号：{{getuserid()}}</el-tag></li>
                            <li><el-tag class="right" type="success">账号名：{{getuserusername()}}</el-tag></li>
                            <li><el-tag type="info">姓名：{{mainname()}}</el-tag></li>
                            <li><el-tag class="right" type="warning">电话：{{getuserphone()}}</el-tag></li>
                            <li><el-tag type="danger">权限等级：{{getuserpwoer()}}</el-tag></li>
                        </ul>
                    </div>
                    <div>
                        <img src="../assets/img/main.png" height="320" style="position: absolute;right: 0px;top: -25px">
                    </div>
                </div>
<!--                <div v-for="o in 4" :key="o" class="text item">{{ 'List item ' + o }}</div>-->

            </el-card>
        </div>
    </div>

</template>

<script>

    import FlipClock from "../components/FlipClock";

    export default {
        name: "Main",
        data(){
            return{
                //图片
                imgList:[
                    {  url: require("../assets/img/code00.png")},
                    {  url: require("../assets/img/code01.jpg")},
                    {  url: require("../assets/img/code02.jpg")},
                    {  url: require("../assets/img/code04.jpg")},
                ],
                // 当前时间
                newDate: new Date(),
                user:[]
            };
        },
        created() {
            if (sessionStorage.getItem("username")==null||sessionStorage.getItem("username")==""){
                this.$router.push('/login')
            }

        },
        // 挂载时间
        mounted () {
            let that = this
            this.timer = setInterval(function () {
                that.newDate = new Date().toLocaleString()
            })
        },
        // 销毁时清除计时器
        beforeDestroy: function () {
            if (this.timer) {
                clearInterval(this.timer)
            }
        },components:{
            FlipClock
        },methods:{
            mainname() {
                return sessionStorage.getItem("username");
            },
            getuserid(){
                return sessionStorage.getItem("userid");
            },
            getuserusername(){
                return sessionStorage.getItem("userusername");
            },
            getuserphone(){
                return sessionStorage.getItem("userphone");
            },
            getuserpwoer(){
                return sessionStorage.getItem("userpower");
            }
        }
    }

</script>

<style>

</style>
<style scoped>
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
        text-align: center;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n + 1) {
        background-color: #d3dce6;
    }
    /*/deep/ .el-calendar-day{*/
    /*    height: 35px;*/
    /*}*/
    ::v-deep(.el-calendar-day){
         height: 30px;
     }
    li{
        margin-bottom: 30px;
    }
    .right{
        margin-left: 244px;
    }
</style>