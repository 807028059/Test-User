<html>
<head>
    <title>Main</title>
    <script src="${proPath}/statics/js/jquery.js" type=text/javascript></script>
    <script type="text/javascript">
        $(function(){

            $("#back").click(function () {
                window.location.href="${proPath}/student/main";
            })



            $("#update").click(function () {
                var name = $("#name").val();
                var gender = $("#gender").val();
                var age = $("#age").val();

                if(name!=""&&gender!=""&&age!=""){
                    $.ajax({
                        type:'post',
                        url:'${proPath}/student/update',
                        data:$('#form').serialize(),
                        dataType:'json',
                        success:function (data) {
                            console.log('...');
                            if(data.code==200){
                                console.log(data.mes);
                                window.location.href="${proPath}/student/main";
                            }else{
                                window.location.href="${proPath}/user/index";
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
        <input type="hidden" id="id" name="id" value="${student.id}" />
        <table border="">
            <tr>
                <td>姓名</td>
                <td><input id="name" type="text" name="name" value="${student.name}"/></td>
            </tr>
            <tr>
                <td>级别</td>
                <td><input id="gender" type="text" name="gender" value="${student.gender}"/></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input id="age" type="text" name="age" value="${student.age}"/></td>
            </tr>
            <tr align="center">
                <td colspan="4">
                    <button type="button" id="update">修改</button>
                    <button type="button" id="back">返回</button>
                </td>

            </tr>
        </table>
    </form>
</div>
</body>
</html>