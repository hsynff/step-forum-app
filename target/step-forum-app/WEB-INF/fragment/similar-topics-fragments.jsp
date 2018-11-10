<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joshgun
  Date: 11/3/2018
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row similarposts">
    <div class="col-lg-10"><i class="fa fa-info-circle"></i>
        <p>Similar Posts according to your Topic Title.</p></div>
</div>
<c:forEach var="topic" items="${topicList}">
    <!-- POST -->
    <div class="post">
        <div class="wrap-ut pull-left">
            <div class="userinfo pull-left">
                <div class="avatar">
                    <img src="${pageContext.request.contextPath}/uploads/${topic.user.imagePath}" alt="${topic.user.firstName} ${topic.user.lastName}" title="${topic.user.firstName} ${topic.user.lastName}"/>
                </div>
            </div>
            <div class="posttext pull-left">
                <h2><a href="${pageContext.request.contextPath}/ns?action=topic&id=${topic.id}">${topic.title}</a></h2>
                <p>${topic.desc}</p>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="postinfo pull-left">
            <div class="comments">
                <div class="commentbg">
                        ${topic.commentList.size()}
                    <div class="mark"></div>
                </div>

            </div>
            <div class="views"><i class="fa fa-eye"></i> ${topic.viewCount}</div>
            <div class="time"><i class="fa fa-clock-o"></i> ${topic.topicAge}</div>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- POST -->
</c:forEach>
