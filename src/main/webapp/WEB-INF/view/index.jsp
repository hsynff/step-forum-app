<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forum :: Home Page</title>

    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/imports.jsp"/>

</head>
<body>

<div class="container-fluid">

    <div class="headernav">
        <div class="container">
            <div class="row">
                <div class="col-lg-1 col-xs-3 col-sm-2 col-md-2 logo "><a href="index.jsp"><img src="images/logo.jpg"
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
                <div class="col-lg-4 col-xs-12 col-sm-5 col-md-4 avt">
                    <div class="stnt pull-left">
                        <form action="http://forum.azyrusthemes.com/03_new_topic.html" method="post" class="form">
                            <button class="btn btn-primary">Start New Topic</button>
                        </form>
                    </div>

                    <div class="avatar pull-left dropdown">
                        <a data-toggle="dropdown" href="#"><img src="images/avatar.jpg" alt=""/></a> <b
                            class="caret"></b>
                        <ul class="dropdown-menu" role="menu">
                            <li role="presentation"><a role="menuitem" tabindex="-3" href="#">Log Out</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-4" href="04_new_account.html">Create
                                account</a></li>
                        </ul>
                    </div>

                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>


    <section class="content">

        <div class="container">
            <h1>All Topics</h1>
            <div class="row">
                <div class="col-lg-8 col-md-8">

                    <!-- POST -->
                    <div class="post">
                        <div class="wrap-ut pull-left">
                            <div class="userinfo pull-left">
                                <div class="avatar">
                                    <img src="images/avatar.jpg" alt=""/>
                                </div>
                            </div>
                            <div class="posttext pull-left">
                                <h2><a href="02_topic.html">10 Kids Unaware of Their Halloween Costume</a></h2>
                                <p>It's one thing to subject yourself to a Halloween costume mishap because, hey, that's
                                    your prerogative.</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="postinfo pull-left">
                            <div class="comments">
                                <div class="commentbg">
                                    560
                                    <div class="mark"></div>
                                </div>

                            </div>
                            <div class="views"><i class="fa fa-eye"></i> 1,568</div>
                            <div class="time"><i class="fa fa-clock-o"></i> 24 min</div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- POST -->

                    <!-- POST -->
                    <div class="post">
                        <div class="wrap-ut pull-left">
                            <div class="userinfo pull-left">
                                <div class="avatar">
                                    <img src="images/avatar.jpg" alt=""/>
                                </div>
                            </div>
                            <div class="posttext pull-left">
                                <h2><a href="02_topic.html">10 Kids Unaware of Their Halloween Costume</a></h2>
                                <p>It's one thing to subject yourself to a Halloween costume mishap because, hey, that's
                                    your prerogative.</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="postinfo pull-left">
                            <div class="comments">
                                <div class="commentbg">
                                    560
                                    <div class="mark"></div>
                                </div>

                            </div>
                            <div class="views"><i class="fa fa-eye"></i> 1,568</div>
                            <div class="time"><i class="fa fa-clock-o"></i> 24 min</div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- POST -->


                    <!-- POST -->
                    <div class="post">
                        <div class="wrap-ut pull-left">
                            <div class="userinfo pull-left">
                                <div class="avatar">
                                    <img src="images/avatar.jpg" alt=""/>
                                </div>
                            </div>
                            <div class="posttext pull-left">
                                <h2><a href="02_topic.html">10 Kids Unaware of Their Halloween Costume</a></h2>
                                <p>It's one thing to subject yourself to a Halloween costume mishap because, hey, that's
                                    your prerogative.</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="postinfo pull-left">
                            <div class="comments">
                                <div class="commentbg">
                                    560
                                    <div class="mark"></div>
                                </div>

                            </div>
                            <div class="views"><i class="fa fa-eye"></i> 1,568</div>
                            <div class="time"><i class="fa fa-clock-o"></i> 24 min</div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- POST -->


                    <!-- POST -->
                    <div class="post">
                        <div class="wrap-ut pull-left">
                            <div class="userinfo pull-left">
                                <div class="avatar">
                                    <img src="images/avatar.jpg" alt=""/>
                                </div>
                            </div>
                            <div class="posttext pull-left">
                                <h2><a href="02_topic.html">10 Kids Unaware of Their Halloween Costume</a></h2>
                                <p>It's one thing to subject yourself to a Halloween costume mishap because, hey, that's
                                    your prerogative.</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="postinfo pull-left">
                            <div class="comments">
                                <div class="commentbg">
                                    560
                                    <div class="mark"></div>
                                </div>

                            </div>
                            <div class="views"><i class="fa fa-eye"></i> 1,568</div>
                            <div class="time"><i class="fa fa-clock-o"></i> 24 min</div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- POST -->


                </div>
                <div class="col-lg-4 col-md-4">

                    <!-- -->
                    <div class="sidebarblock">
                        <h3 class="bg-primary">Popular Topics</h3>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <ul class="cats">
                                <li><a href="#">Trading for Money <span class="badge pull-right">20</span></a></li>
                                <li><a href="#">Vault Keys Giveway <span class="badge pull-right">10</span></a></li>
                                <li><a href="#">Misc Guns Locations <span class="badge pull-right">50</span></a></li>
                                <li><a href="#">Looking for Players <span class="badge pull-right">36</span></a></li>
                                <li><a href="#">Stupid Bugs &amp; Solves <span class="badge pull-right">41</span></a>
                                </li>
                                <li><a href="#">Video &amp; Audio Drivers <span class="badge pull-right">11</span></a>
                                </li>
                                <li><a href="#">2K Official Forums <span class="badge pull-right">5</span></a></li>
                            </ul>
                        </div>
                    </div>

                    <!-- -->
                    <div class="sidebarblock">
                        <h3 class="bg-primary">My Active Threads</h3>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <a href="#">This Dock Turns Your iPhone Into a Bedside Lamp</a>
                        </div>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <a href="#">Who Wins in the Battle for Power on the Internet?</a>
                        </div>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <a href="#">Sony QX10: A Funky, Overpriced Lens Camera for Your Smartphone</a>
                        </div>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <a href="#">FedEx Simplifies Shipping for Small Businesses</a>
                        </div>
                        <div class="divline"></div>
                        <div class="blocktxt">
                            <a href="#">Loud and Brave: Saudi Women Set to Protest Driving Ban</a>
                        </div>
                    </div>


                </div>
            </div>
        </div>

        <br><br>

    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-1 col-xs-3 col-sm-2 logo "><a href="#"><img src="images/logo.jpg" alt=""/></a></div>
                <div class="col-lg-8 col-xs-9 col-sm-5 ">Copyrights 2014, websitename.com</div>
            </div>
        </div>
    </footer>
</div>


</body>

<!-- Mirrored from forum.azyrusthemes.com/index.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 16 Oct 2018 05:38:53 GMT -->
</html>