layui.use('table', function(){
    var table = layui.table;
    var url = '/role/getRole.do';
    //初始化表单信息
    table.render({
        elem: '#roleInfo'
        ,height: 650
        ,url: url //数据接口
        ,cols: [[ //表头
            {field: 'role_id', title: '角色ID', width:150, sort: true, fixed: 'left'}
            ,{field: 'role_name', title: '角色名称', width:150, sort: true, fixed: 'left'}
            ,{field:'right', title: '操作', width:300,toolbar:"#barDemo"}
        ]]

    });
//监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            //do somehing
        } else if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    var roleName = data.role_name;
                    onDelete(roleName);
            });
        } else if(layEvent === 'edit'){ //编辑
            //do something
            var assignRoleId = data.role_id;
            sessionStorage.setItem("assignRoleId",assignRoleId);
            var index = layui.layer.open({
                title : "分配权限",
                type : 2,
                area: ['800px', '600px'],
                scrollbar: false,
                content : '../privilege/assignPrivilege.html',
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
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
            //同步更新缓存对应的值
            obj.update({
                username: '123'
                ,title: 'xxx'
            });
        }
    });
    //分配权限
    $("#assignPrivilege").click(function(){
        var index = layui.layer.open({
            title : "分配权限",
            type : 2,
            area: ['800px', '600px'],
            scrollbar: false,
            content : '../privilege/assignPrivilege.html',
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
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
    //删除
    function onDelete(data){
        layui.jquery.ajax({
            //实际请求
            url: "/role/deleteRole.do",
            data:"roleName="+data,
            method: 'POST',
            success: function(res) {
                res = JSON.parse(res);
            }
        })
    }

});