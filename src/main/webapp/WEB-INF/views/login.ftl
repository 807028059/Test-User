<html>
<head>

    <title>Login page</title>
    <script src="${proPath}/statics/js/jquery-1.11.3.js"></script>
    <script src="${proPath}/statics/js/jquery.js"></script>
    <script type="text/javascript">
        function flushCode() {
            // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
            var time = new Date();
            document.getElementById("scode").src = "${proPath}/user/yzm?time=" + time;
        }

        function check() {
            var userName = $("#name").val();
            var password = $("#password").val();
            if(userName == ""){
                alert("用户名不能为空");
                return;
            }
            if(password == ""){
                alert("密码不能为空");
                return;
            }

            $.ajax({
                url:'${proPath}/user/check',
                data:{
                    code:$("#yzm").val()
                },
                type:'post',
                dataType:'json',
                success:function (data) {
                    if(data.code==200){
                        $.ajax({
                            url:'${proPath}/user/login',
                            data:{
                                userName:userName,
                                userPassword:password
                            },
                            type:'post',
                            dataType:'json',
                            success:function (data) {
                                if(data.code == 200){
                                    window.location.href="${proPath}/student/main";
                                }else{
                                    alert(data.mes);
                                }
                            }
                        })
                    }else{
                        alert(data.mes);
                    }
                }
            })




        }
    </script>
</head>
<body>
<div id="loginDiv">
    <div style="position:absolute;width:500px;height:200px;top:200px;left:550px">
        <table border="">
            <tr>
                <td>
                    <label for="name">账号:</label>
                </td>
                <td>
                    <input type="text" id="name" name="userName" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">密码:</label>
                </td>
                <td>
                    <input type="text" id="password" name="userPassword" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="yzm">验证码:</label>
                </td>
                <td>
                    <input type="text" id="yzm" name="userYzm" />
                    <img alt="验证码" id="scode" src="${proPath}/user/yzm" >
                    <a href="#" onclick="javascript:flushCode();">看不清?</a>
                </td>

            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" onclick="check()">登录</button>
                </td>
            </tr>
        </table>
    </div>
    <div style="color:red">${requestScope.msg}</div>
</div>
</body>
</html>