layui.use('table', function(){
    var table = layui.table;
    var userName = sessionStorage.getItem("username");
    var url = '/user/getUserPrivateInfo.do?userName='+userName;
    //初始化表单信息
    table.render({
        elem: '#userInfo'
        ,height: 312
        ,url: url //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'user_id', title: '用户ID', width:150, sort: true, fixed: 'left'},
            {field: 'user_name', title: '用户名', width:150, sort: true, fixed: 'left'},
            {field: 'phone', title: '薪水', width:150, sort: true, fixed: 'left'},
            {field: 'email', title: '邮箱', width:150, sort: true, fixed: 'left'},
            {field: 'department', title: '部门', width:150, sort: true, fixed: 'left'},
            {field: 'classify', title: '岗位', width:150, sort: true, fixed: 'left'},
            {field: 'sign', title: '工作信条', width:150, sort: true, fixed: 'left'},
            {field: 'sex', title: '性别', width:150, sort: true, fixed: 'left'}
        ]]
        ,done: function(res){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
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

});