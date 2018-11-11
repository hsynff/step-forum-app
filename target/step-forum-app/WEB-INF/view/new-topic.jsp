<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forum :: New topic</title>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/imports.jsp"/>
    <script type="text/javascript">
        $(function () {
           $('#idInputTitle').blur(function () {
              var title=$('#idInputTitle').val();
              $.ajax({
                  url: '/ts?action=getSimilarTopics' ,
                  type: 'GET',
                  data: 'title='+title,
                  dataType: 'html',
                  success: function (data) {
                      $('#idSimilarTopics').html(data);

                  }
              })
           });
        });

    </script>

</head>
<body>

<div class="container-fluid">

    <c:import url="${pageContext.request.request.contextPath}/WEB-INF/fragment/header.jsp"/>

    <section class="content">
        <br><br>


        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-8">


                    <!-- POST -->
                    <div class="post">
                        <form action="${pageContext.request.contextPath}/ts?action=addNewTopic" class="form newtopic"
                              method="post">
                            <div class="topwrap">
                                <div class="userinfo pull-left">
                                    <div class="avatar">
                                        <img src="${pageContext.request.contextPath}/uploads/${sessionScope.user.imagePath}"
                                             alt=""/>
                                    </div>
                                </div>
                                <div class="posttext pull-left">

                                    <div>
                                        <input type="text" name="title" id="idInputTitle"
                                               placeholder="Enter Topic Title" class="form-control"/>
                                    </div>


                                    <div>
                                        <textarea required name="desc" id="desc" placeholder="Description"
                                                  class="form-control"></textarea>
                                    </div>

                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="postinfobot">

                                <div class="pull-right postreply">
                                    <div class="pull-left">
                                        <button type="submit" class="btn btn-primary">Post</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>


                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                    <!-- POST -->



                    <div id="idSimilarTopics">

                    </div>


                </div>
                <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/right-menu.jsp"/>
            </div>
        </div>

    </section>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/footer.jsp"/>

</div>


</body>

<!-- Mirrored from forum.azyrusthemes.com/new-topic.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 16 Oct 2018 07:34:53 GMT -->
</html>