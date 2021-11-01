<template>
    <div style="margin: 15px;width: 100%">

        <el-button type="primary" icon="el-icon-circle-plus-outline" @click="add">新增</el-button>
<!--        <el-button type="warning" icon="el-icon-bottom">导入</el-button>-->
<!--        <el-button type="success" icon="el-icon-top">导出</el-button>-->
        <el-upload
                action="http://localhost:9090/student/import"
                :on-success="handleUploadSuccess"
                :show-file-list=false
                :limit="1"
                accept='.xlsx'
                style="display: inline-block; margin: 0 10px"
        >
            <el-button type="warning" icon="el-icon-bottom">导入</el-button>
        </el-upload>
        <el-button type="success" icon="el-icon-top" @click="exportUser">导出</el-button>
        <el-popconfirm
                confirm-button-text="是的"
                cancel-button-text="不，再想想"
            title="确定删除吗？"
            @confirm="deleteBatch"
        >
            <template #reference>
                <el-button icon="el-icon-delete" type="danger">批量删除</el-button>
            </template>
        </el-popconfirm>

        <el-input v-model="search" style="width: 255px;right: 180px;position: absolute;" placeholder="请输入查询姓名" clearable></el-input>
        <el-button type="primary" style="position: absolute;right: 124px" icon="el-icon-search" @click="load"></el-button>
        <el-table
                empty-text="数据为空"
                :data="tableData"
                stripe
                style="width: 100%;border-radius: 15px;margin-top: 20px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);"
                @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" />
            <el-table-column
                    align="center"
                    prop="id"
                    label="ID"
                    sortable
                    width="50">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="studentid"
                    label="学生编号"
                    sortable
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="name"
                    label="姓名"
                    width="px">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="sex"
                    label="性别"
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="age"
                    label="年龄"
                    width="">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="phone"
                    label="电话"
                    width="">
            </el-table-column>
            <el-table-column
                    prop="classid"
                    align="center"
                    label="班级号">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="classname"
                    label="班级名">
            </el-table-column>
            <el-table-column
                    align="center"
                    prop="dormitoryid"
                    label="宿舍号">
            </el-table-column>
            <el-table-column
                    align="center"
                    fixed="right"
                    label="操作"
                    width="150">
                <template #default="scope">
                    <el-button size="mini" @click="handleEdit(scope.row)"
                    >编辑</el-button
                    >
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
<!--        <el-empty image="" image-size="0" description=" ">-->
<!--            <img src="../assets/img/web-development.png" height="300">-->
<!--            <p style="color: #99a9bf">程序员正在加班(掉头发ing)~~~</p>-->
<!--        </el-empty>-->
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
                    width="30%">
                <el-form :model="form" label-width="150px">
                    <el-form-item label="学生编号：">
                        <el-input v-model="form.studentid" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名：">
                        <el-input v-model="form.name" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="性&nbsp;&nbsp;&nbsp;&nbsp;别：">
                        <el-radio v-model="form.sex" label="男">男</el-radio>
                        <el-radio v-model="form.sex" label="女">女</el-radio>
                    </el-form-item>

                    <el-form-item label="年&nbsp;&nbsp;&nbsp;&nbsp;龄：">
                        <el-input v-model="form.age" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="电&nbsp;&nbsp;&nbsp;&nbsp;话：">
                        <el-input v-model="form.phone" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="班&nbsp;&nbsp;级&nbsp;&nbsp;号：">
                        <el-input v-model="form.classid" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="班&nbsp;&nbsp;级&nbsp;&nbsp;名：">
                        <el-input v-model="form.classname" style="width: 70%"></el-input>
                    </el-form-item>
                    <el-form-item label="宿&nbsp;&nbsp;舍&nbsp;&nbsp;号：">
                        <el-input v-model="form.dormitoryid" style="width: 70%"></el-input>
                    </el-form-item>
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
        </div>
    </div>

</template>

<script>
import request from "../utils/request";
export default {
  name:'Home',
  components:{
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
            ids:[]
        }
    },
    created() {
        if (sessionStorage.getItem("username")==null||sessionStorage.getItem("username")==""){
            this.$router.push('/login')
        }
        // this.drawLine()
      this.load()
    },
    methods:{
      deleteBatch(){
        if (!this.ids.length){
            this.$message.warning("请选择数据！")
            return
        }
        request.post("/api/student/deleteBatch",this.ids).then(res=>{
            if (res.code==='0'){
                this.$message.success("批量删除成功")
                this.load()
            }else{
                this.$message.error(res.msg)
            }
        })
      },
        handleSelectionChange(val){
          this.ids=val.map(v=>v.id)
        },
        load(){
            // this.tableData=[]
            request.get("/api/student",{
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
        },
        save(){
            if (this.form.id){//判断是否是更新
                request.put("/api/student",this.form).then(res=>{
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
                request.post("/api/student", this.form).then(res => {
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
            this.dialogVisible=true
        },

        handleDelete(id){//删除
            console.log(id)
            request.delete("/api/student/"+id).then(res=>{
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
        },
        handleSizeChange(pageSize){//改变当前每页的个数触发
            this.pageSize=pageSize
            this.load()
        },
        handleCurrentChange(pageNum){//改变当前页数触发
            this.pageNum=pageNum
            this.load()
        },
        handleUploadSuccess(res) {
            if (res.code === "0") {
                this.$message.success("导入成功")
                this.load()
            }
        },
        exportUser() {
            // alert(window.server)
            // location.href = "http://" + window.server.filesUploadUrl + ":9090/classs/export";
            location.href = "http://localhost:9090/student/export";
        },

    },

}
</script>
