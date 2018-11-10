<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forum :: New account</title>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/imports.jsp"/>

</head>
<body class="newaccountpage">

<div class="container-fluid">

    <c:import url="${pageContext.request.request.contextPath}/WEB-INF/fragment/header.jsp"/>


    <section class="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 breadcrumbf">
                    <p>Create New account</p>
                </div>
            </div>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8">


                    <!-- POST -->
                    <div class="post">
                        <form action="${pageContext.request.contextPath}/us?action=doRegister" class="form newtopic" method="post" enctype="multipart/form-data">
                            <div class="postinfotop">
                                <h2>Create New Account</h2>
                            </div>

                            <!-- acc section -->
                            <div class="accsection">
                                <div class="acccap">
                                    <div class="userinfo pull-left">&nbsp;</div>
                                    <div class="posttext pull-left"><h3>Required Fields</h3></div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="topwrap">
                                    <div class="userinfo pull-left">

                                    </div>
                                    <div class="posttext pull-left">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <input type="text" placeholder="First Name" name="firstName" class="form-control"/>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <input type="text" placeholder="Last Name" name="lastName" class="form-control"/>
                                            </div>
                                        </div>
                                        <div>
                                            <input type="text" placeholder="Email" name="email" class="form-control"/>
                                        </div>
                                        <div>
                                            <input type="file" name="img" class="form-control" accept="image/jpeg, image/jpg, image/png">
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <input type="password" placeholder="Password" class="form-control"
                                                       id="pass" name="pass"/>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <input type="password" placeholder="Retype Password"
                                                       class="form-control" id="pass2" name="pass2"/>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <!-- acc section END -->

                            <div class="postinfobot">

                                <div class="pull-right postreply">
                                    <div class="pull-left">
                                        <button type="submit" class="btn btn-primary">Sign Up</button>
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