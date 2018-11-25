package com.step.forum.constants;

public class NavigationConstants {
    public static final String ACTION_LOGIN = "login";
    public static final String ACTION_DO_REGISTER = "doRegister";
    public static final String ACTION_GET_TOPIC_BY_USER_ID = "getTopicByUserId";
    public static final String ACTION_DO_LOGIN = "doLogin";
    public static final String ACTION_LOGOUT = "logout";
    public static final String ACTION_ADD_COMMENT = "addComment";
    public static final String ACTION_GET_POPULAR_TOPICS = "getPopularTopics";
    public static final String ACTION_ADD_NEW_TOPIC = "addNewTopic";
    public static final String ACTION_GET_SIMILAR_TOPICS = "getSimilarTopics";
    public static final String ACTION_GET_COMMENTS_BY_TOPIC_ID = "getCommentsByTopicId";
    public static final String ACTION_TOPIC = "topic";
    public static final String ACTION_NEW_TOPIC ="newTopic";
    public static final String ACTION_NEW_ACCOUNT="newAccount";

    //JSP
    private static final String PAGE_PREFIX_VIEW = "/WEB-INF/view/";
    private static final String PAGE_PREFIX_FRAGMENT = "/WEB-INF/fragment/";

    //View
    public static final String PAGE_INDEX = PAGE_PREFIX_VIEW + "index.jsp";
    public static final String PAGE_LOGIN = PAGE_PREFIX_VIEW + "login.jsp";
    public static final String PAGE_NEW_ACCOUNT = PAGE_PREFIX_VIEW + "new-account.jsp";
    public static final String PAGE_TOPIC = PAGE_PREFIX_VIEW + "topic.jsp";
    public static final String PAGE_NEW_TOPIC = PAGE_PREFIX_VIEW + "new-topic.jsp";
    //Fragment
    public static final String PAGE_HEADER = PAGE_PREFIX_FRAGMENT + "header.jsp";
    public static final String PAGE_FOOTER = PAGE_PREFIX_FRAGMENT + "footer.jsp";
    public static final String PAGE_IMPORTS = PAGE_PREFIX_FRAGMENT + "imports.jsp";
    public static final String PAGE_RIGHT_MENI = PAGE_PREFIX_FRAGMENT + "right-menu.jsp";
    public static final String PAGE_SIMILAR_TOPICS_FRAGMENTS = PAGE_PREFIX_FRAGMENT + "similar-topics-fragments.jsp";
    public static final String PAGE_COMMENTS = PAGE_PREFIX_FRAGMENT + "comments.jsp";
}
