layui.use(['table','element','form','jquery'], function(){
    var table = layui.table;
    var $ = layui.jquery;
    var form = layui.form;
    var response = null;
    //初始化表单信息
    table.render({
        elem: '#userInfo'
        ,height: 500
        ,url: '/user/getUser.do' //数据接口
        ,page: true //开启分页
        ,toolbar: ['filter', 'print', 'exports']
        ,cols: [[ //表头
            {field: 'user_id', title: '员工号码', width:150, sort: true, fixed: 'left'}
            ,{field: 'user_name', title: '用户名', width:80}
            ,{field: 'phone', title: '手机', width:80}
            ,{field: 'email', title: '邮箱', width:80}
            ,{field: 'sex', title: '性别', width:80, sort: true}
            ,{field: 'sign', title: '工作信条', width: 150}
            ,{field: 'classify', title: '职位', width: 150}
            ,{field: 'department', title: '部门', width: 80}
            ,{field:'operate', title: '操作', width:150,toolbar:"#barDemo"}
        ]]
        ,done: function(res){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            //根据用户角色判断是否添加修改和删除操作
            var roleId = sessionStorage.getItem("roleId");
            if(roleId==102||roleId==101){
                $(".user-view").hide();
                $(".user-edit").show();
                $(".user-delete").show();
                //$(".user-edit").show();
            }/*else if(roleId==107){
                $(".user-view").hide();
                //$(".user-edit").show();
            }*/
            response=res;
            //分类显示中文名称
            $("[data-field='sex']").children().each(function(){
                if($(this).text()=='1'){
                    $(this).text("男")
                }else if($(this).text()=='0'){
                    $(this).text("女")
                }
            })
        }
    });
    //添加用户
    $(".usersAdd_btn").click(function(){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            area: ['800px', '600px'],
            scrollbar: false,
            content : '../user/addUser.html',
            success : function(data){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回会员列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)

            }
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index);
    });
    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            //do somehing
        } else if(layEvent === 'del'){ //删除
            var id = data.user_id;
            if(id==100001||id==100002||id==100004||id==100003){
                layer.confirm('该用户为管理员，删除后，相关组组成员将会同时被删除,真的删除行么', function(index) {
                    layer.close(index);
                    //向服务端发送删除指令
                    onDelete(obj);
                    //obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                })
            }else{
                layer.confirm('真的删除行么', function(index) {
                    layer.close(index);
                    //向服务端发送删除指令
                    onDelete(obj);
                    //obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                })
            }
        } else if(layEvent === 'user-edit') { //编辑
            layer.open({
//layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                type: 1,
                title: "修改采集设备信息",
                area: ['420px', '330px'],
                content: $("#userUpdate")//引用的弹出层的页面层的方式加载修改界面表单 });
            });
            setFormValue(obj,data);
        }
    });
    //搜索

    $('#searchBtn').on('click',function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    // 点击获取数据
    var  active = {
        getInfo: function () {
            var userName=$('#userName').val();
            if (userName) {
                var index = layer.msg('查询中，请稍候...',{icon: 16,time:false,shade:0});
                setTimeout(function(){
                    table.reload('userInfo', { //表格的id
                        url:'/user/getUser.do',
                        where: {
                            'userName':$.trim(userName)
                        }
                    });
                    layer.close(index);
                },800);
            } else {
                layer.msg("请输入用户名");
            }
        },
    };
    //监听回车事件,扫描枪一扫描或者按下回车键就直接执行查询
    $("#select_orderId").bind("keyup", function (e) {
        if (e.keyCode == 13) {
            var type = "getInfo";
            active[type] ? active[type].call(this) : '';
        }
    });


    /*layui.$('#searchEmailCompany').on('click', function () {
        ids=new Array();
        var type = layui.$(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    element.init();*/
    //删除
    function onDelete(obj){
        var data = obj.data;
        var user_id = data.user_id;
        layui.jquery.ajax({
            //测试数据
            //url: "../main/demo.json",
            //实际请求
            url: "/user/deleteUser.do",
            data:{userId:user_id},
            method: 'POST',
            success: function(res) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                res = JSON.parse(res);
                layer.msg(res.message);
            }
        })
    };
    //监听弹出框表单提交，massage是修改界面的表单数据'submit(demo11),是修改按钮的绑定
    function setFormValue(obj,data){
        form.on('submit(demo11)', function(data) {
            $.ajax({
                url:'/user/updateUserInfo.do',
                async:true,
                type:'POST',
                data:{userName:data.field.userName,
                    phone:data.field.phone,
                    sign:data.field.sign,
                    classify:data.field.classify,
                    department:data.field.department,
                    email:data.field.email,
                    userId:obj.data.user_id
                    },
                success:function (msg) {
                    msg = JSON.parse(msg);
                    //取得返回数据（Sting类型的字符串）的信息进行取值判断
                    if(msg.code==0){
                        layer.closeAll('loading');
                        layer.load(2);
                        layer.msg("修改成功", {icon: 6});
                        setTimeout(function(){
                            obj.update({
                                user_name:data.field.userName,
                                phone:data.field.phone,
                                sign:data.field.sign,
                                classify:data.field.classify,
                                department:data.field.department,
                                email:data.field.email
                            });
                            //修改成功修改表格数据不进行跳转
                            layer.closeAll();//关闭所有的弹出层
                        }, 1000); //加载层-风格
                    }else{
                        layer.msg("修改失败", {icon: 5});
                    }
                }
            });
            return false;
        })
    }
});