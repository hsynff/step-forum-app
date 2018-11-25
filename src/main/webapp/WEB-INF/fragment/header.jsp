<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joshgun
  Date: 10/21/2018
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div class="headernav">
        <div class="container">
            <div class="row">
                <div class="col-lg-1 col-xs-3 col-sm-2 col-md-2 logo "><a
                        href="${pageContext.request.contextPath}/"><img
                        src="${pageContext.request.contextPath}/resources/images/logo.jpg"
                        alt=""/></a></div>
                <div class="col-lg-3 col-xs-9 col-sm-5 col-md-3 selecttopic">

                </div>
                <div class="col-lg-4 search hidden-xs hidden-sm col-md-3">
                    <div class="wrap">
                        <form action="#" method="post" class="form">
                            <div class="pull-left txt"><input type="text" class="form-control"
                                                              placeholder="Search Topics"></div>
                            <div class="pull-right">
                                <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                            </div>
                            <div class="clearfix"></div>
                        </form>
                    </div>
                </div>

                <c:choose>
                    <c:when test="${sessionScope.user ne null}">
                    <div class="col-lg-4 col-xs-12 col-sm-5 col-md-4 avt">
                        <div class="stnt pull-left">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/ns?action=newTopic">New Topic</a>
                        </div>

                        <div class="avatar pull-left dropdown">
                            <a data-toggle="dropdown" href="#"><img
                                    src="${pageContext.request.contextPath}/uploads/${user.imagePath}" alt=""/></a> <b
                                class="caret"></b>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation"><a role="menuitem" tabindex="-3" href="/us?action=logout">Log Out</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-4"
                                                           href="${pageContext.request.contextPath}/ns?action=newAccount">Create
                                    account</a></li>
                            </ul>
                        </div>

                        <div class="clearfix"></div>
                    </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-lg-4 col-xs-12 col-sm-5 col-md-4 avt">
                            <div class="stnt pull-left">
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/ns?action=login">Login</a>
                            </div>

                            <div class="avatar pull-left dropdown">
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/ns?action=newAccount">Register</a>
                            </div>

                            <div class="clearfix"></div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</head>
<body>

</body>
</html>
