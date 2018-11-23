var $;
layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
   //表单提交
    form.on("submit(addUser)", function (data) {
        // window.sessionStorage.setItem("addUser",JSON.stringify(addUserArray));
        //弹出loading
        var formjson = $("#addUserForm").serialize();
        var msg = document.getElementById("register");
        var index = layer.msg('正在提交，请稍候', {icon: 16, time: false});
        $.ajax({
            type: "post",
            url: "/user/insertUser.do",
            data: formjson,
            success: function (data) {
                data = JSON.parse(data);
                layer.close(index);
                if (data.code == 0) {
                    layer.msg("用户添加成功!");
                    layer.close(parent.index);
                    parent.init();

                } else {
                    msg.style.color = "red";
                    msg.innerHTML = data.message;
                }
            }, error: function () {
                layer.close(index);
            }
        });
        return false;
    })

})
