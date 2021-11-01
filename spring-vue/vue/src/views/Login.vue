<template>
    <div id="app">

        <div id="bg" style="width: 100vw;">
<!--            <div id="triangle" style="float: left"></div>-->
            <div style="width: 100%;height: 60px; background-color: lightsteelblue"><h2 style="line-height: 60px;color: white; margin-left: 20px">宿舍后台管理系统</h2></div>
            <ul style="">
<!--                <div class="toleft" style="display: flex;margin-top: 0px">-->
<!--                    <li><img src="../assets/img/li1.png"></li>-->
<!--                    <li><img src="../assets/img/li2.png"></li>-->
<!--                    <li><img src="../assets/img/li3.png"></li>-->
<!--                    <li><img src="../assets/img/li4.png"></li>-->
<!--                    <li><img src="../assets/img/li5.png"></li>-->
<!--                    <li><img src="../assets/img/li6.png"></li>-->
<!--                    <li><img src="../assets/img/li7.png"></li>-->
<!--                    <li><img src="../assets/img/li8.png"></li>-->
<!--                    <li><img src="../assets/img/li9.png"></li>-->
<!--                    <li><img src="../assets/img/li10.png"></li>-->
<!--                    <li><img src="../assets/img/li11.png"></li>-->
<!--                    <li><img src="../assets/img/li12.png"></li>-->
<!--                    <li><img src="../assets/img/li13.png"></li>-->
<!--                    <li><img src="../assets/img/li14.png"></li>-->
<!--                </div>-->
<!--                <div class="torigth" style="display: flex">-->
<!--                    <li><img src="../assets/img/li10.png"></li>-->
<!--                    <li><img src="../assets/img/li5.png"></li>-->
<!--                    <li><img src="../assets/img/li3.png"></li>-->
<!--                    <li><img src="../assets/img/li11.png"></li>-->
<!--                    <li><img src="../assets/img/li8.png"></li>-->
<!--                    <li><img src="../assets/img/li6.png"></li>-->
<!--                    <li><img src="../assets/img/li7.png"></li>-->
<!--                    <li><img src="../assets/img/li14.png"></li>-->
<!--                    <li><img src="../assets/img/li9.png"></li>-->
<!--                    <li><img src="../assets/img/li1.png"></li>-->
<!--                    <li><img src="../assets/img/li11.png"></li>-->
<!--                    <li><img src="../assets/img/li3.png"></li>-->
<!--                    <li><img src="../assets/img/li7.png"></li>-->
<!--                    <li><img src="../assets/img/li2.png"></li>-->
<!--                </div>-->
<!--                <div class="toleft2" style="display: flex">-->
<!--                    <li><img src="../assets/img/li14.png"></li>-->
<!--                    <li><img src="../assets/img/li13.png"></li>-->
<!--                    <li><img src="../assets/img/li12.png"></li>-->
<!--                    <li><img src="../assets/img/li11.png"></li>-->
<!--                    <li><img src="../assets/img/li10.png"></li>-->
<!--                    <li><img src="../assets/img/li9.png"></li>-->
<!--                    <li><img src="../assets/img/li8.png"></li>-->
<!--                    <li><img src="../assets/img/li7.png"></li>-->
<!--                    <li><img src="../assets/img/li6.png"></li>-->
<!--                    <li><img src="../assets/img/li5.png"></li>-->
<!--                    <li><img src="../assets/img/li4.png"></li>-->
<!--                    <li><img src="../assets/img/li3.png"></li>-->
<!--                    <li><img src="../assets/img/li2.png"></li>-->
<!--                    <li><img src="../assets/img/li1.png"></li>-->
<!--                </div>-->
            </ul>
            <img class="drawer" src="../assets/img/arrows.png" width="60" @click="drawer = true" style="cursor: pointer;position: absolute;right: 0px;top: 45%">
            <el-drawer v-model="drawer" title="I am the title" :with-header="false">
                <fieldset style="width: 300px; margin: 20px;border: 0;margin-left: 130px;">
                    <!--                <legend><h3 style="font-size: 20px">许久未见···</h3></legend>-->
                    <h2 style="font-weight:unset;color: white">欢迎注册···</h2>
                    <el-form
                            ref="form2"
                            :model="form2"
                            :rules="rules2"
                            size="normal"
                            style="">
                        <el-form-item prop="username2" style="margin-top: 30px">
                            <el-input prefix-icon="el-icon-user" v-model="form2.username2" placeholder="请输入注册账号" size="small" style=""></el-input>
                        </el-form-item>
                        <el-form-item prop="password2">
                            <el-input prefix-icon="el-icon-lock" show-password v-model="form2.password2" placeholder="请输入注册密码" size="small" style=""></el-input>
                        </el-form-item>
                        <el-form-item prop="confirmpass">
                            <el-input prefix-icon="el-icon-lock" show-password v-model="form2.confirm" placeholder="确认密码" size="small" style=""></el-input>
                        </el-form-item>
                        <el-form-item prop="name" style="margin-top: 30px">
                            <el-input prefix-icon="el-icon-user-solid" v-model="form2.name" placeholder="请输入真实姓名" size="small" style=""></el-input>
                        </el-form-item>
                        <el-form-item prop="phone" style="margin-top: 30px">
                            <el-input prefix-icon="el-icon-phone" v-model="form2.phone" placeholder="请输入手机号" size="small" style=""></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" size="small" @click="reqister" style="width: 100%;">注册</el-button>
<!--                            <el-link type="primary">没有账号？请点击右侧箭头注册</el-link>-->
                        </el-form-item>
                    </el-form>
                </fieldset>
            </el-drawer>
        </div>
        <div id="box">
            <fieldset id="" style="width: 300px; margin: 20px;border: 0">
<!--                <legend><h3 style="font-size: 20px">许久未见···</h3></legend>-->
                <h2 style="font-weight:unset ">欢迎登陆···</h2>
                <el-form
                        ref="form"
                        :model="form"
                        :rules="rules"
                        size="normal"
                        style="">
                    <el-form-item prop="username" style="margin-top: 30px">
                        <el-input prefix-icon="el-icon-user" v-model="form.username" placeholder="请输入账号" size="small" style=""></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input prefix-icon="el-icon-lock" show-password v-model="form.password" placeholder="请输入密码" size="small" style=""></el-input>
                    </el-form-item>
                    <el-form-item style="">
                        <div style="display: flex">
                            <el-input prefix-icon="el-icon-key" size="mini" v-model="form.validCode" style="width: 50%" placeholder="请输入验证码"></el-input>
                            <ValidCode @input="createValidCode" />
                        </div>
                        <el-button type="primary" size="small" @click="login" style="width: 100%;">登录</el-button>
<!--                        <el-link type="primary">没有账号？请点击右侧箭头注册</el-link>-->
                    </el-form-item>
                </el-form>
            </fieldset>

            <img src="../assets/img/title.png" style="height: 167px;">
        </div>
    </div>


</template>

<script>
    import request from "../utils/request";
    import { defineComponent, ref } from 'vue'
    import ValidCode from "../components/ValidCode";

    export default {
        components: {ValidCode},
        setup() {
            return {
                drawer: ref(false),
            }
        },
        data(){
            return{
                form:{},
                form2: {},
                rules: {
                    username: [
                        {
                            required: true,
                            message: '请输入账号',
                            trigger: 'blur',
                        },
                    ], password: [
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur',
                        },
                    ],
                    },
                rules2: {
                   username2: [
                        {
                            required: true,
                            message: '请输入账号',
                            trigger: 'blur',
                        },
                    ],password2: [
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur',
                        },
                    ], name: [
                        {
                            required: true,
                            message: '请输入真实姓名',
                            trigger: 'blur',
                        },
                    ], phone: [
                        {
                            required: true,
                            message: '请输入手机号',
                            trigger: 'blur',
                        },
                    ]
                },
                validCode:''
                }
            },methods:{
            createValidCode(data){
                this.validCode=data
            },
            login(){
                this.$refs['form'].validate((valid) => {//验证是否合法
                    if (valid) {
                        if (!this.form.validCode) {
                            this.$message.error("请填写验证码")
                            return
                        }
                        if(this.form.validCode.toLowerCase() !== this.validCode.toLowerCase()) {
                            this.$message.error("验证码错误")
                            return
                        }
                        request.post("/api/admin/login",this.form).then(res=>{
                            console.log(res)
                            if (res.code=='0'){//判断返回结果是否成功
                                this.$message({
                                    type:"success",
                                    message:"登录成功"
                                })
                                sessionStorage.setItem("username",res.data.name)
                                sessionStorage.setItem("userpower",res.data.power)
                                sessionStorage.setItem("userphone",res.data.phone)
                                sessionStorage.setItem("userid",res.data.id)
                                sessionStorage.setItem("userusername",res.data.username)
                                this.$router.push("/main") //登陆成功跳转到主页
                            }else {
                                this.$message({
                                    type:"error",
                                    message:res.msg
                                })
                            }
                        })
                    }
                })
            },

            reqister(){
                if (this.form2.password2!=this.form2.confirm){
                    this.$message({
                        type:"error",
                        message:"两次密码输入不一致！",
                    })
                    return
                }
                this.form.username = this.form2.username2
                this.form.password = this.form2.password2
                this.form.name = this.form2.name
                this.form.phone = this.form2.phone

                request.post("/api/admin/reqister",this.form).then(res=>{
                    console.log(res)
                    if (res.code=='0'){//判断返回结果是否成功
                        this.$message({
                            type:"success",
                            message:"注册成功，已填写至登录信息栏，赶快登陆吧。",
                        })
                        // sessionStorage.setItem("username",res.data.name)
                        // sessionStorage.setItem("userpower",res.data.power)
                        // this.$router.push("/main")//注册成功跳转到主页

                    }else {
                        this.$message({
                            type:"error",
                            message:res.msg
                        })
                    }
                    // this.form={}
                    this.form2={}
                    this.drawer=false
                })
            }
        }
    }
    // window.onload = function () {
    //     document.onmousemove=function(event){
    //         // var ven=ev||event;
    //         var x=event.clientX+8500;
    //         var y=event.clientY+2500;//监听鼠标位置;
    //         document.getElementById("box").style.left=x/10+'px';
    //         document.getElementById("box").style.top=y/10+'px';
    //     }
    // }

</script>

<style scoped>
@import "../assets/css/login.css";
*{
    /*overflow: hidden;*/
}
#bg .drawer{
    animation: toleft .6s linear infinite;
}
@keyframes toleft{
    from{
        opacity: 0;
        right: 0px;
    }
    to{
        opacity: 1;
        right: 45px;
    }
}
    ::v-deep .el-drawer__body{
        background-image: url("../assets/img/arrows1.jpg");
        background-size: cover;
        background-position: 100% 73%;
    }
ul{
    /*width: 6000px;*/
    overflow: hidden;
}
ul li{
    width: 460px;
    list-style-type: none;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    height: 300px;
    border-radius: 20px;
    margin: 11px;
    background-color: rgba(244, 244, 244, 1.0);
}
ul li img{
    width: 450px;
}
.toleft{
    animation: tolefts 60s linear infinite;
}
.torigth{
    animation: torights 60s linear infinite alternate;
}
.toleft2{
    animation: tolefts 60s linear infinite alternate;
}
@keyframes tolefts{
    from{
        transform: translateX(0px);
    }
    to{
        transform: translateX(-4600px);
    }
}
@keyframes torights{
    from{
        transform: translateX(-6000px);
    }
    to{
        transform: translateX(1320px);
    }
}
ul{

}
#triangle{
    width: 0;
    height: 0;
    border-top: 500px solid red;
    border-right: 500px solid transparent;
}
</style>