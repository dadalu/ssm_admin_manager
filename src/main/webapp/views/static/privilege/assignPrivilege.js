var $;
layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
        //var roleId = sessionStorage.getItem("roleId");
        /*layui.jquery.ajax({
            //实际请求
            url: "/privilege/getPrivilege.do?roleId="+roleId,
            async:false,
            method: 'POST',
            success: function(res) {
                res = JSON.parse(res);
                var resdata = res.data;
                var html="";
                for(var i = 0;i< resdata.length;i++){
                 /!*html=html+'<input type="checkbox" name="'+resdata[i].privilege_name+'" value="'+resdata[i].privilege_id+'"'
                + 'title="'+resdata[i].privilege_name+'">';
                }*!/
                 html=html+
                     "<input type=\"radio\" name=\"sex\" lay-filter=\"erweima\" value=\"二维码\" title=\"二维码\">"
               // "<input type=\"checkbox\">"+resdata[i].privilege_name+"<br/>";
                }
                layui.jquery("#assignPrivilege").html(html);
                layui.element.init();

            }
        });*/


    form.on("submit(assignPrivilege)", function (data) {
        //弹出loading

            var obj = document.getElementsByName("test");
            var arr = [];
            for(var k in obj){
                if(obj[k].checked){
                    var privilege = {};
                    privilege['privilegeId'] = obj[k].value;
                    arr.push(privilege);
                }
            }
            var params = JSON.stringify(arr);
        var msg = document.getElementById("register");
        var index = layer.msg('正在提交，请稍候', {icon: 16, time: false});
        $.ajax({
            type: "post",
            url: "/privilege/assignPrivilege.do?roleId="+sessionStorage.getItem("assignRoleId"),
            data:  "params="+params,
            dataType:"json",
            success: function (data) {
                layer.close(index);
                if (data.code == 0||data.code == '0') {
                    layer.msg("权限分配成功!");
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
