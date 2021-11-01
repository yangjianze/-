<template>
    <div style="margin: 15px;width: 100%">

        <el-button type="primary" icon="el-icon-tickets" @click="add">发帖</el-button>
<!--        <el-button type="warning" icon="el-icon-bottom">导入</el-button>-->
        <el-button @click="open" type="success">在这里你可以畅所欲言</el-button>
        <el-button @click="open" type="warning">可以写博客聊一聊技术上的事</el-button>
        <el-button @click="open" type="danger">也可也给我留言</el-button>

        <el-input v-model="search" style="width: 255px;right: 180px;position: absolute;" placeholder="查询作者" clearable></el-input>
        <el-button type="primary" style="position: absolute;right: 124px" icon="el-icon-search" @click="load"></el-button>
        <el-table
                :data="tableData"
                stripe
                style="width: 100%;border-radius: 15px;margin-top: 20px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">

            <el-table-column
                    align="center"
                    prop="id"
                    label="编号"
                    sortable
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="title"
                    label="标题"
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="author"
                    label="作者"
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="createtime"
                    label="创作时间"
                    sortable
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    fixed="right"
                    label="操作"
                    width="250">
                <template #default="scope">
                    <el-button size="mini" @click="details(scope.row)"
                    >详情</el-button
                    >
<!--                    <el-button size="mini" @click="handleEdit(scope.row)"-->
<!--                    >编辑</el-button-->
<!--                    >-->
                    <el-popconfirm
                            confirm-button-text="是的"
                            cancel-button-text="不，再想想"
                            icon="el-icon-info"
                            icon-color="red"
                            title="确定删除吗?"
                            @confirm="handleDelete(scope.row.id)"
                            @cancel="cancelEvent"
                    >
                        <template #reference>
                            <el-button
                                    size="mini"
                                    type="danger"
                            >删除</el-button>
                        </template>
                    </el-popconfirm>
                </template>

            </el-table-column>
        </el-table>
        <div style="margin: 15px 0px">
            <el-pagination
                    v-model:currentPage="currentPage"
                    :page-sizes="[5 , 8, 10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
            >
            </el-pagination>

            <el-dialog
                    v-model="dialogVisible"
                    title="信息"
                    width="60%">
                <el-form :model="form" label-width="150px">
                    <el-form-item label="标&nbsp;&nbsp;&nbsp;&nbsp;题：">
                        <el-input v-model="form.title" style="width: 90%"></el-input>
                    </el-form-item>
                        <div id="div1"></div>
<!--                    <el-form-item label="内&nbsp;&nbsp;&nbsp;&nbsp;容：">-->
<!--                        <el-input v-model="form.content" style="width: 70%"></el-input>-->
<!--                    </el-form-item>-->
                </el-form>
                <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">关闭</el-button>
        <el-button type="primary" @click="save"
        >确定</el-button
        >
      </span>
                </template>
            </el-dialog>
            <el-dialog title="详情" v-model="vis" width="60%" class="feedback_dialog">
                <el-card style="min-height: 200px">
                    <div v-html="detail.content"></div>
                </el-card>

                <el-card style="min-height: 200px;margin-top: 20px;">
                    <template #header>
                        <div class="card-header">
                            <span style="color: white;font-size: 17px">评论区</span>
                        </div>
                    </template>
                    <el-table
                            :data="tableData2"
                            stripe
                            style="width: 100%;">

<!--                        <el-table-column-->
<!--                                align="center"-->
<!--                                prop="id"-->
<!--                                label="楼号"-->
<!--                                sortable-->
<!--                                width="100">-->
<!--                        </el-table-column>-->
                        <el-table-column
                                align="center"
                                prop="name"
                                label="姓名"
                                width="100">
                        </el-table-column>
                        <el-table-column
                                align="left"
                                prop="txt"
                                label=""
                                width="">
                        </el-table-column>
                        <el-table-column
                                align="center"
                                prop="createtime"
                                label="回复日期"
                                sortable
                                width="200">
                        </el-table-column>
<!--                        <el-table-column-->
<!--                                align="center"-->
<!--                                fixed="right"-->
<!--                                label="操作"-->
<!--                                width="150">-->
<!--                            <template #default="scope">-->
<!--                                <el-button size="mini" @click="handleEdit(scope.row)"-->
<!--                                >编辑</el-button-->
<!--                                >-->
<!--                                <el-popconfirm-->
<!--                                        confirm-button-text="是的"-->
<!--                                        cancel-button-text="不，再想想"-->
<!--                                        icon="el-icon-info"-->
<!--                                        icon-color="red"-->
<!--                                        title="确定删除吗?"-->
<!--                                        @confirm="handleDelete(scope.row.id)"-->
<!--                                        @cancel="cancelEvent"-->
<!--                                >-->
<!--                                    <template #reference>-->
<!--                                        <el-button-->
<!--                                                size="mini"-->
<!--                                                type="danger"-->
<!--                                        >删除</el-button>-->
<!--                                    </template>-->
<!--                                </el-popconfirm>-->
<!--                            </template>-->

<!--                        </el-table-column>-->
                    </el-table>
                    <div style="margin: 15px 0px">
                        <el-pagination
                                v-model:currentPage="currentPage2"
                                :page-sizes="[5 , 8, 10]"
                                :page-size="pageSize2"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="total2"
                                @size-change="handleSizeChange2"
                                @current-change="handleCurrentChange2"
                        >
                        </el-pagination>
                    </div>
                </el-card>

                <div style="margin-top: 15px;">
                    <el-card  style="position: relative;">
                        <h3>{{username}}：</h3>
                        <el-input type="textarea" :rows="1" style="width: 90%" placeholder="在这里输入回复内容" v-model="form3.txt"></el-input>
                        <el-button type="primary" style="position: absolute; right: 50px;bottom: 17px" @click="save2">回帖</el-button>
                    </el-card>
                </div>
            </el-dialog>
        </div>
    </div>

</template>

<script>
    import E from "wangeditor"
    import request from "../utils/request";
    import Stgrade from "./Stgrade";

    import { ElNotification } from 'element-plus'

    let editor

    export default {
        name:'Blogs',
        components:{
            Stgrade

        },
        setup() {
            const open = () => {
                ElNotification.info({
                    title: '真没了/(ㄒoㄒ)/~~',
                    message: '正在努力中......',
                    showClose: false,
                })
            }

            return {
                open,
            }
        },
        data() {
            return {
                //默认关闭弹窗
                dialogVisible:false,
                search:'',//搜索
                currentPage:1,//当前所在页
                pageSize:5,//当前每页展示数量
                total:0,//总条数
                tableData:[],
                form:{
                },
                detail:{},
                vis:false,
                tableData2:[],
                form2:{
                },
                currentPage2:1,//评论当前所在页
                pageSize2:5,//评论当前每页展示数量
                total2:0,//评论总条数
                row2:{

                },
                username:sessionStorage.getItem("username"),
                form3:{

                }
            }
        },
        created() {
            if (sessionStorage.getItem("username")==null||sessionStorage.getItem("username")==""){
                this.$router.push('/login')
            }
            this.load()
        },
        methods:{
            details(row){
                this.detail=row
                this.vis=true
                this.row2=JSON.parse(JSON.stringify(row))
                this.loadcomment(this.row2)
            },
            load(){
                // this.tableData=[]
                // request.get("/api/blogs/read",{
                        request.get("/api/blogs",{
                    params:{
                        pageNum:this.currentPage,
                        pageSize:this.pageSize,
                        search:this.search
                    }
                }).then(res => {
                    console.log(res)
                    this.tableData=res.data.records
                    this.total=res.data.total
                })
            },
            //新增弹窗
            add(){
                this.dialogVisible=true
                this.form={}

                this.$nextTick(()=>{
                    //富文本
                    editor = new E("#div1")
                    //配置server接口地址
                    // editor.config.uploadImgServer="/"
                    editor.create()
                })
            },
            save(){
                this.form.content=editor.txt.html() //获取富文本的值

                if (this.form.id){//判断是否是更新
                    request.put("/api/blogs",this.form).then(res=>{
                        console.log(res)
                        if (res.code=='0'){//判断返回结果是否成功
                            this.$message({
                                type:"success",
                                message:"修改成功"
                            })
                        }else {
                            this.$message({
                                type:"error",
                                message:res.msg
                            })
                        }
                        this.load()
                    })
                }else {//新增
                    this.form.author=sessionStorage.getItem("username")
                    // request.post("/api/blogs/write", this.form).then(res => {
                    request.post("/api/blogs", this.form).then(res => {
                        console.log(res)
                        this.$message({
                            type:"success",
                            message:"新增成功"
                        })
                        this.load()
                    })
                }
                this.dialogVisible=false
            },
            //修改
            handleEdit(row){
                this.form=JSON.parse(JSON.stringify(row))
                if (sessionStorage.getItem("username")==row.author||sessionStorage.getItem("userpower")==0){
                    this.$nextTick(()=>{
                        //富文本
                        editor = new E("#div1")
                        editor.create()
                        editor.txt.html(row.content)
                    })
                    this.form=JSON.parse(JSON.stringify(row))
                    this.dialogVisible=true
                }else {
                    alert("您不是管理员！！！没有权限修改他(她)人内容")
                }

            },

            handleDelete(id){//删除
                if (sessionStorage.getItem("userpower")!=0){
                    alert("您不是管理员！！！没有权限删除他(她)人内容")
                }else{
                    console.log(id)
                    request.delete("/api/blogs/"+id).then(res=>{
                        if (res.code=='0'){//判断返回结果是否成功
                            this.$message({
                                type:"success",
                                message:"删除成功"
                            })
                        }else {
                            this.$message({
                                type:"error",
                                message:res.msg
                            })
                        }
                        this.load()
                    })
                }
            },
            handleSizeChange(pageSize){//改变当前每页的个数触发
                this.pageSize=pageSize
                this.load()
            },
            handleCurrentChange(pageNum){//改变当前页数触发
                this.pageNum=pageNum
                this.load()
            },
            loadcomment(row2){//评论区查询
                request.get("/api/comment",{
                    params:{
                        pageNum2:this.currentPage2,
                        pageSize2:this.pageSize2,
                        bid:row2.id
                    }
                }).then(res => {
                    console.log(res)
                    this.tableData2=res.data.records
                    this.total2=res.data.total
                })
                //this.tableData2=row2.comment
            },
            handleSizeChange2(pageSize2){//改变当前每页的个数触发
                this.pageSize2=pageSize2
                this.loadcomment(this.row2)
            },
            handleCurrentChange2(pageNum2){//改变当前页数触发
                this.pageNum2=pageNum2
                this.loadcomment(this.row2)
            },
            save2(){
                this.form3.name=sessionStorage.getItem("username")
                this.form3.bid=this.row2.id
                this.form.author=sessionStorage.getItem("username")
                // request.post("/api/blogs/write", this.form).then(res => {
                request.post("/api/comment", this.form3).then(res => {
                    console.log(res)
                    this.$message({
                        type:"success",
                        message:"新增成功"
                    })
                    this.form3={}
                    this.loadcomment(this.row2)
                })
            }
        }
    }
</script>
<style scoped>
    /deep/ .el-card__header {
        background-color: indianred;
    }
</style>
<style>

</style>
