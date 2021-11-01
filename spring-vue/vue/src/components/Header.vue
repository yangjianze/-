<template>
    <div class="line grid" style="border-bottom: 1px solid gray;background-color: #373d41;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
        <div style="width: 200px;padding-left: 40px;font-weight: bold;color: #ffffff;font-size: 25px">宿舍后台管理</div>
        <div class="grid-flex-1"></div>
        <div >
<!--            <el-dropdown>-->
<!--                <el-button type="primary">-->
<!--                    菜单<i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
<!--                </el-button>-->
<!--                <template #dropdown>-->
<!--                    <el-dropdown-menu>-->
<!--                        <el-dropdown-item>个人信息</el-dropdown-item>-->
<!--                        <el-dropdown-item>退出系统</el-dropdown-item>-->
<!--                    </el-dropdown-menu>-->
<!--                </template>-->
<!--            </el-dropdown>-->
            <el-dropdown>
    <span class="el-dropdown-link" style="color: #ffffff;margin-right: 20px">
        {{mainname()}}<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item @click="info">个人信息</el-dropdown-item>
                        <el-dropdown-item @click="close">切换账号</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        created() {
            // if (sessionStorage.getItem("username")==null||sessionStorage.getItem("username")==""){
            //     this.$router.push('/login')
            // }
        },
        methods:{
            info(){
                this.$router.push("/main")
            },
            close(){
                // sessionStorage.removeItem("username")
                // sessionStorage.removeItem("user")
                // sessionStorage.removeItem("userpower")
                sessionStorage.clear();
                this.$router.push('/login')
            },
            mainname(){
                return sessionStorage.getItem("username")
            }
        }
    }
</script>

<style scoped>

</style>