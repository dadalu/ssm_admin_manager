layui.use('table', function(){
    var table = layui.table;
    var roleId = sessionStorage.getItem("roleId");
    var url = '/privilege/getPrivilege.do?roleId='+roleId;
    //初始化表单信息
    table.render({
        elem: '#userInfo'
        ,height: 650
        ,url: url //数据接口
        ,cols: [[ //表头
            {field: 'privilege_id', title: '权限id', width:150, sort: true, fixed: 'left'}
            ,{field: 'privilege_name', title: '权限名称', width:150, sort: true, fixed: 'left'}
        ]]

    });

});