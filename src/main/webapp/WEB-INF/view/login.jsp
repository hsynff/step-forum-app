<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/imports.jsp"/>

    <script type="text/javascript">
        $(function () {
            <c:if test="${message ne null}">
                alert('${message}');
            </c:if>
            });
    </script>

</head>
<body class="newaccountpage">

<div class="container-fluid">

    <c:import url="${pageContext.request.request.contextPath}/WEB-INF/fragment/header.jsp"/>


    <section class="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 breadcrumbf">
                    <p>Login</p>
                </div>
            </div>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8">


                    <!-- POST -->
                    <div class="post">
                        <form action="${pageContext.request.contextPath}/us?action=doLogin" class="form newtopic" method="post">
                            <div class="postinfotop">
                                <h2>Login</h2>
                            </div>

                            <!-- acc section -->
                            <div class="accsection">
                                <div class="acccap">
                                <div class="userinfo pull-left">&nbsp;</div>
                                <div class="posttext pull-left"></div>
                                <div class="clearfix"></div>
                            </div>
                                <div class="topwrap">
                                    <div class="userinfo pull-left">

                                    </div>
                                    <div class="posttext pull-left">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                            </div>
                                        </div>
                                        <div>
                                            <input type="text" name="email" placeholder="E-Mail" class="form-control"/>
                                        </div>
                                        <div>
                                            <input type="password" name="password" placeholder="Password" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <!-- acc section END -->

                            <div class="postinfobot">

                                <div class="pull-right postreply">
                                    <div class="pull-left">
                                        <button type="submit" class="btn btn-primary">Login</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>


                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                    <!-- POST -->


                </div>
                <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/right-menu.jsp"/>
            </div>
        </div>

    </section>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/footer.jsp"/>
</div>


</body>

</html>
