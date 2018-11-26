layui.use(['table','element','laypage'], function(){
    var table = layui.table;
    var laypage = layui.laypage;
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
            success : function(layero, index){
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
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        onDelete(data);
                })
            }else{
                layer.confirm('真的删除行么', function(index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        onDelete(data);
                })
            }
        } else if(layEvent === 'edit'){ //编辑
            layer.prompt({
                formType: 2
                ,title: '修改 ID 为 ['+ data.id +'] 的访问量'
                ,value: data.uv
            }, function(value, index){
                //这里一般是发送修改的Ajax请求
                onEdit(data,value,index,obj);
            });
            //do something
            //同步更新缓存对应的值
            obj.update({
                username: '123'
                ,title: 'xxx'
            });
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


    layui.$('#searchEmailCompany').on('click', function () {
        ids=new Array();
        var type = layui.$(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    element.init();
    //删除
    function onDelete(data){
        var user_id = data.user_id;
        layui.jquery.ajax({
            //测试数据
            //url: "../main/demo.json",
            //实际请求
            url: "/user/deleteUser.do",
            data:"userId="+user_id,
            method: 'POST',
            success: function(res) {
                res = JSON.parse(res);
                layer.msg(res.message);
            }
        })
    };
    function  onEdit(data,value,index,obj) {
        $.ajax({
            url: "/user/updateUser.do",
            type: "POST",
            data:{"uvid":data.id,"memthodname":"edituv","aid":data.aid,"uv":value},
            dataType: "json",
            success: function(data){

                if(data.state==1){
                    //关闭弹框
                    layer.close(index);
                    //同步更新表格和缓存对应的值
                    obj.update({
                        uv: value
                    });
                    layer.msg("修改成功", {icon: 6});
                }else{
                    layer.msg("修改失败", {icon: 5});
                }
            }

        });
    };
});