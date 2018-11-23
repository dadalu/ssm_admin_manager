layui.use('table', function(){
    var table = layui.table;
alert(1111);
    //初始化表单信息
    table.render({
        elem: '#userInfo'
        ,height: 312
        ,url: '/user/getUser.do' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'user_id', title: '员工号码', width:150, sort: true, fixed: 'left'}
            ,{field: 'user_name', title: '用户名', width:80}
            ,{field: 'sex', title: '性别', width:80, sort: true}
            ,{field: 'city', title: '城市', width:80}
            ,{field: 'sign', title: '工作信条', width: 150}
            ,{field: 'salary', title: '工资', width: 80, sort: true}
            ,{field: 'score', title: '绩效', width: 80, sort: true}
            ,{field: 'classify', title: '职位', width: 150}
            ,{field: 'department', title: '部门', width: 80}
            ,{field: 'joinDate', title: '入职日期', width: 150}
            ,{field: 'university', title: '毕业院校', width: 150}
        ]]
    });

});