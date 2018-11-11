<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joshgun
  Date: 10/21/2018
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '/ts?action=getPopularTopics',
            type: 'GET',
            dataType: 'json',
            success: function (topicList) {
                $('#idPopularTopic').empty();
                topicList.forEach(function (topic) {
                    $('#idPopularTopic').append('<li><a href="/ns?action=topic&id=' + topic.id + '">' + topic.title + ' <span class="badge pull-right">' + topic.commentCount + '</span></a></li>');

                })
            },
            error: function () {
                $('#idPopularTopic').empty();
                topicList.forEach(function (topic) {
                    $('#idPopularTopic').append('<p>Error</p>');
                })
            }
        })
    })

    function getTopicsByUserId() {
        $.ajax({
            url: '/ts?action=getTopicByUserId',
            type: 'GET',
            dataType: 'json',
            success: function (listTopic) {
                $('#idDivMyTopics').empty();
                listTopic.forEach(function (topic) {
                    $('#idDivMyTopics').append(' <div class="divline"></div><div class="blocktxt"><a href="/ns?action=topic&id='+topic.id+'">'+topic.title+'</a></div>')

                })
            }
        })
    }
</script>

<div class="col-lg-4 col-md-4">


    <!-- -->
    <div class="sidebarblock">
        <h3 class="bg-primary">Popular Topics</h3>
        <div class="divline"></div>
        <div class="blocktxt">
            <ul id="idPopularTopic" class="cats">
                <p>Loading popular topics</p>
            </ul>
        </div>
    </div>

    <!-- -->
    <c:if test="${sessionScope.user ne null}">
        <script> getTopicsByUserId(); </script>
        <div class="sidebarblock">
            <h3 class="bg-primary">My Topics</h3>
            <div id="idDivMyTopics">

            </div>
        </div>
    </c:if>


</div>

