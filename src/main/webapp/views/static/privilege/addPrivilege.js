var $;
layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;


    form.on("submit(addPrivilege)", function (data) {
        //弹出loading
        var formjson = $("#addPrivilege").serialize();
        var msg = document.getElementById("register");
        var index = layer.msg('正在提交，请稍候', {icon: 16, time: false});
        $.ajax({
            type: "post",
            url: "/privilege/insertPrivilege.do",
            data: formjson,
            success: function (data) {
                data = JSON.parse(data);
                layer.close(index);
                if (data.code == 0||data.code == '0') {
                    layer.msg("权限添加成功!");
                    layer.close(parent.index);
                    parent.init();

                } else {
                    msg.style.color = "red";
                    layer.msg("权限添加失败");
                    msg.innerHTML = data.message;
                }
            }, error: function () {
                layer.close(index);
            }
        });
        return false;
    })

})
