<template>
<el-config-provider :locale="locale">
    <router-view />
</el-config-provider>
    <div>
        <router-view />
    </div>

</template>

<style>

</style>
<script>

  //引入vue方法
  import { ElConfigProvider } from 'element-plus'
  //中文包
  import zhCn from 'element-plus/lib/locale/lang/zh-cn'
  //引入自定义方法
  //引入自定义组件

  export default {
    name:'App',
    components:{
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
