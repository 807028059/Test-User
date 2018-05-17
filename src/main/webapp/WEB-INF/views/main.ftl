<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Main</title>
    <script src="${proPath}/statics/js/jquery.js" type=text/javascript></script>
    <script type="text/javascript">
        $(function () {
            $.pageSkip = function(pageNumber) {
                $("#pageNumber").val(pageNumber);
                $("#student").submit();
                return false;
            }
        })
    </script>
</head>

<body>
    <div style="position:absolute;width:500px;height:200px;top:200px;left:550px">
        <form id="student" action="${proPath}/student/main" method="post">
            <input type="hidden" id="pageNumber" name="page" value="${student.page}" />
            <input type="hidden" id="pageSize" name="pageSize" value="${student.pageSize}" />
            <table border="">
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>级别</td>
                    <td>年龄</td>
                    <td>操作</td>
                </tr>
                [#if students?has_content]
                        [#list students as student]
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.gender}</td>
                                <td>${student.age}</td>
                                <td>
                                    <a href="${proPath}/student/buyView/${student.id}">购买</a>|
                                    <a href="${proPath}/student/updateView/${student.id}">编辑</a>|
                                    <a href="${proPath}/student/delete/${student.id}">删除</a>
                                </td>
                            </tr>
                        [/#list]
                    [#else]
                        <tr align="center">
                            <td colspan="5">无数据...</td>
                        </tr>
                [/#if]
                <tr align="center">
                    <td colspan="5">
                        [#if pagenator.totalPages>1]
                            [#if pagenator.isFirstPage()]
                                [#else]
                                <a href="javascript: $.pageSkip(1);" class="">首页</a>
                            [/#if]


                            [#if pagenator.hasPrePage]
                                <a href="javascript: $.pageSkip(${pagenator.prePage});" class="previousPage">上一页</a>
                                [#else]
                                    <span class="previousPage">&nbsp;</span>
                            [/#if]


                            [#list pagenator.slider(3) as slider ]
                                [#if slider==pagenator.page ]
                                    <span class="currentPage">${slider}</span>
                                    [#else]
                                        <a href="javascript: $.pageSkip(${slider});">${slider}</a>
                                [/#if]

                            [/#list]


                            [#if pagenator.hasNextPage]
                                <a href="javascript: $.pageSkip(${pagenator.nextPage});" class="nextPage">下一页</a>
                            [#else]
                                <span class="nextPage">&nbsp;</span>
                            [/#if]


                            [#if pagenator.isLastPage()]
                                <span class="lastPage" >&nbsp;</span>
                                [#else]
                                    <a href="javascript: $.pageSkip(${pagenator.totalPages});" class="lastPage">末页</a>
                            [/#if]
                        [/#if]
                    </td>
                </tr>

                <tr align="center" >
                    <td colspan="5">
                        <a href="${proPath}/student/addView">添加</a>
                        <a href="${proPath}/user/out">退出</a>
                    </td>
                </tr>
            </table>
        </form
    </div>
</body>
</html>