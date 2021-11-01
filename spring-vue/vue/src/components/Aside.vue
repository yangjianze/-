<template>
    <el-col :span="12" >
<!--        <h5>Default colors</h5>-->
        <el-menu
                active-text-color="#4CAF50"
                background-color="#545c64"
                text-color="#fff"
                style="max-width: 400px;height: calc(100vh - 100px);box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);"
                :default-active=path()
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
        >
            <el-sub-menu index="1" >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-user-solid"></i>
                    <span>学生管理</span>
                </template>
                    <el-menu-item index="1-1" @click="home">
                        <i class="el-icon-arrow-right"></i>
                        学生信息</el-menu-item>
                <el-menu-item index="1-2" @click="homeecharts">
                    <i class="el-icon-arrow-right"></i>
                    学生信息数据图表</el-menu-item>
            </el-sub-menu>

            <el-sub-menu index="2" >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-s-data"></i>
                    <span>班级管理</span>
                </template>
                    <el-menu-item index="2-1" @click="classs">
                        <i class="el-icon-arrow-right"></i>
                        班级列表</el-menu-item>
            </el-sub-menu>

            <el-sub-menu index="3" >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-s-order"></i>
                    <span>宿舍管理</span>
                </template>
                    <el-menu-item index="3-1" @click="dormitoryinfo">
                        <i class="el-icon-arrow-right"></i>
                        宿舍列表</el-menu-item>
                    <el-menu-item index="3-2" @click="dormrepair">
                        <i class="el-icon-arrow-right"></i>
                        维修登记</el-menu-item>
            </el-sub-menu>

            <el-sub-menu index="4" >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-notebook-1"></i>
                    <span>卫生管理</span>
                </template>
                    <el-menu-item index="4-1" @click="dormgrade">
                        <i class="el-icon-arrow-right"></i>
                        宿舍卫生</el-menu-item>
                    <el-menu-item index="4-2" @click="stgrade">
                        <i class="el-icon-arrow-right"></i>
                        学生卫生</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index=5 >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-user"></i>
                    <span>访问管理</span>
                </template>
                    <el-menu-item index="5-1" @click="visitor">
                        <i class="el-icon-arrow-right"></i>
                        访问列表</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index=6 >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-s-custom"></i>
                    <span>管理员管理</span>
                </template>
                    <el-menu-item index="6-1" @click="admins">
                        <i class="el-icon-arrow-right"></i>
                        管理员列表</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index=7 >
                <template #title style="background-color: #545c67">
                    <i class="el-icon-s-opportunity"></i>
                    <span>开发展望</span>
                </template>
                <el-menu-item index="7-1" @click="blogs">
                    <i class="el-icon-arrow-right"></i>
                    博客区/留言板</el-menu-item>
                <el-menu-item index="7-2" @click="exploit">
                    <i class="el-icon-arrow-right"></i>
                    开发区</el-menu-item>
            </el-sub-menu>
        </el-menu>
    </el-col>
</template>

<script>
    export default {
        name: "Aside",
        methods:{
            home() {
                this.$router.push("/home")
            },homeecharts(){
                this.$router.push("/homeecharts")
            },
            classs(){
                this.$router.push("/classs")
            },
            dormitoryinfo(){
                this.$router.push("/dormitoryinfo")
            },
            dormrepair(){
                this.$router.push("/dormrepair")
            },
            dormgrade(){
                this.$router.push("/dormgrade")
            },stgrade(){
                this.$router.push("/stgrade")
            },
            visitor(){
                this.$router.push("/visitor")
            },
            admins(){
                this.$router.push("/admins")
            },
            blogs(){
                this.$router.push("/blogs")
            },
            exploit(){
                this.$router.push("/exploit")
            },
            path(){//拿到当前路径
                // alert(this.$route.path)
                //动态判断当前应该展开的侧边栏
                var path=this.$route.path
                if (path=="/home"){
                    return "1-1"
                }else if (path=="/homeecharts"){
                    return "1-2"
                }else if (path=="/classs"){
                    return "2-1"
                }else if (path=="/dormitoryinfo"){
                    return "3-1"
                }else if (path=="/dormrepair"){
                    return "3-2"
                }else if (path=="/dormgrade"){
                    return "4-1"
                }else if (path=="/stgrade"){
                    return "4-2"
                }else if (path=="/visitor"){
                    return "5-1"
                }else if (path=="/admins"){
                    return "6-1"
                }else if (path=="/blogs"){
                    return "7-1"
                }else if (path=="/exploit"){
                    return "7-2"
                }else{
                    return ""
                }
            }
        }
    }
</script>

<style scoped>

</style>