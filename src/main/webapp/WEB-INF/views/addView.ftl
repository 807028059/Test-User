<html>
<head>
    <title>Main</title>
    <script src="${proPath}/statics/js/jquery.js" type=text/javascript></script>
    <script type="text/javascript">
        $(function(){
            $("#back").click(function () {
                window.location.href="main";
            })
            $("#add").click(function () {
                var name = $("#name").val();
                var gender = $("#gender").val();
                var age = $("#age").val();

                if(name!=""&&gender!=""&&age!=""){
                    $.ajax({
                        type:'post',
                        url:'${proPath}/student/add',
                        data:$('#form').serialize(),
                        dataType:'json',
                        success:function (data) {
                            console.log('...');
                            if(data.code==200){
                                console.log(data.mes);
                                window.location.href="main";
                            }else{
                                console.log(data.mes);
                            }
                        }
                    })
                }else{
                    alert("请填写完整...");
                }

            })



        })

    </script>
</head>

<body>
<div style="position:absolute;width:500px;height:200px;top:200px;left:550px">
    <form id="form" method="post" >
        <table border="">
            <tr>
                <td>姓名</td>
                <td><input id="name" type="text" name="name"/></td>
            </tr>
            <tr>
                <td>级别</td>
                <td><input id="gender" type="text" name="gender"/></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input id="age" type="text" name="age"/></td>
            </tr>
            <tr align="center">
                <td colspan="4">
                    <button type="button" id="add">添加</button>
                    <button type="button" id="back">返回</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>