    layui.use('element','layer', function() {
        function checkLastItem(arr, i) {
            return arr.length == (i + 1);
        }

        function getAhtml(obj){
            return "<a href=\"javascript:;\" onclick=\"addTab('" + obj.name + "','" + obj.url + "')\" >" + obj.name + "</a>";
        }
        //动态菜单
        layui.jquery.ajax({
            //测试数据
            //url: "../main/demo.json",
            //实际请求
            url: "../../menu/getMenu.do",
            method: 'POST',
            success: function(res) {
                res = JSON.parse(res);
                var html = "";
                for(var i = 0; i < res.length; i++) {
                    var strli = "<li class=\"layui-nav-item lay-unselect \" >";
                    if (res[i].url =='#'){
                        strli = strli + "<a href=\"javascript:;\">" + res[i].name + "</a>";
                        //console.log(res[i].name)
                    }else{
                        //strli = strli + getAhtml(res[i]);
                    }
                    if(res[i].pId == "0" && !checkLastItem(res, i)/* && res[i + 1].pId != "0"*/) {
                        var resId = res[i].id;
                        strli = strli + "<dl class=\"layui-nav-child\" >";
                        for(var j = 0; /*!checkLastItem(res, j)&&*/j< res.length/*&& res[i + 1].pId == resId*/; j++) {
                            if(res[j].pId == resId){
                                strli = strli + "<dd>"+getAhtml(res[j])+"</dd>";
                            }
                        }
                        strli = strli + "</dl>";
                    }
                    strli = strli + "</li>";
                    html = html + strli;
                }
                layui.jquery("#memus").html(html);
                layui.element.init(); //一定初始化一次
            }
        })
    });

    //添加选项卡
    function addTab(name, url) {
        if (layui.jquery(".layui-tab-title li[lay-id='" + name + "']").length > 0) {
            //选项卡已经存在
            layui.element.tabChange('tabDemo', name);
            layer.msg('切换-' + name)
        } else {
            //动态控制iframe高度
            var tabheight = layui.jquery(window).height() - 95;
            contentTxt = '<iframe src="' + url + '" scrolling="no" width="100%" height="' + (tabheight) + 'PX"></iframe>';
            //新增一个Tab项
            layui.element.tabAdd('tabDemo', {
                title: name,
                content: contentTxt,
                id: name
            })
            //切换刷新
            layui.element.tabChange('tabDemo', name)
            layer.msg('新增-' + name)
        }
    }
    $(".topTab").hide();
