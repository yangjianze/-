<template>
    <div>
        <!--    头部-->
        <Header></Header>
        <!--    主体-->
        <div class="grid" style="background-color: #e9edf0;">
            <!--      侧边栏-->
            <Aside class="grid-flex-1" style="max-width: 200px;"></Aside>
            <!--    内容区域-->
            <router-view class="grid-flex-1" style="width: 50%;">
            </router-view>
        </div>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Aside from "../components/Aside";

    //引入vue方法
    import { ElConfigProvider } from 'element-plus'
    //中文包
    import zhCn from 'element-plus/lib/locale/lang/zh-cn'
    //引入自定义方法
    //引入自定义组件

    export default {
        name: "Layout",
        components:{
            Header,
            Aside,
            [ElConfigProvider.name]: ElConfigProvider
        },
        setup() {
            let locale = zhCn
            return {
                locale
            }
        }
    }
</script>

<style scoped>

</style>