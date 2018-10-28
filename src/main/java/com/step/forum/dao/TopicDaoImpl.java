package com.step.forum.dao;

import com.step.forum.model.Comment;
import com.step.forum.model.Topic;
import com.step.forum.model.User;
import com.step.forum.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TopicDaoImpl implements TopicDao {
    private final String GET_ALL_TOPIC_SQL = "select t.id_topic, t.title, t.description, t.share_date, t.view_count, u.id_user, u.email, u.first_name, u.last_name, c.id_comment, c.description, c.write_date from topic t inner join user u on t.id_user = u.id_user left join comment c on c.id_topic = t.id_topic order by t.share_date desc";
    private final String GET_TOPIC_BY_ID_SQL = "select t.id_topic, t.title, t.description as t_description, t.share_date, t.view_count, u.id_user as t_id_user, u.first_name as t_first_name,  u.last_name as t_last_name, c.id_comment, c.description as c_description, c.write_date, u1.id_user as c_id_user, u1.first_name as c_first_name, u1.last_name as c_last_name  from topic t inner join user u on t.id_user=u.id_user\n" +
            "left join comment c on t.id_topic=c.id_topic left join user u1 on c.id_user=u1.id_user where t.id_topic=? order by write_date asc";
    private final String GET_POPULAR_TOPICS_SQL = "select t.id_topic, t.title, count(c.id_comment) as comments from topic t left join comment c on t.id_topic=c.id_topic group by t.title having comments>0  order by comments desc limit 7";

    @Override
    public List<Topic> getAllTopic() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Topic> list = new ArrayList<>();

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_TOPIC_SQL);
            rs = ps.executeQuery();
            Map<Integer, Topic> map = new LinkedHashMap<>();
            while (rs.next()) {
                Topic t = map.get(rs.getInt("id_topic"));

                if (t == null) {
                    t = new Topic();
                    t.setId(rs.getInt("id_topic"));
                    t.setTitle(rs.getString("title"));
                    t.setDesc(rs.getString("description"));
                    t.setShareDate(rs.getTimestamp("share_date").toLocalDateTime());
                    t.setViewCount(rs.getInt("view_count"));

                    User u = new User();
                    u.setId(rs.getInt("id_user"));
                    u.setEmail(rs.getString("email"));
                    u.setFirstName(rs.getString("first_name"));
                    u.setLastName(rs.getString("last_name"));
                    t.setUser(u);
                    map.put(t.getId(), t);
                }

                if (rs.getInt("id_comment") != 0) {
                    Comment c = new Comment();
                    c.setId(rs.getInt("id_comment"));
                    c.setDesc(rs.getString("description"));
                    c.setWriteDate(rs.getTimestamp("write_date").toLocalDateTime());
                    t.addComment(c);
                }
            }

            list = new ArrayList<>(map.values());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(con, ps, rs);
        }

        return list;
    }

    @Override
    public Topic getTopicById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Topic topic = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_TOPIC_BY_ID_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                topic = new Topic();
                topic.setId(rs.getInt("id_topic"));
                topic.setTitle(rs.getString("title"));
                topic.setDesc(rs.getString("t_description"));
                topic.setShareDate(rs.getTimestamp("share_date").toLocalDateTime());
                topic.setViewCount(rs.getInt("view_count"));

                User user = new User();
                user.setId(rs.getInt("t_id_user"));
                user.setFirstName(rs.getString("t_first_name"));
                user.setLastName(rs.getString("t_last_name"));
                topic.setUser(user);
                if (rs.getInt("id_comment") != 0) {
                    do {
                        Comment comment = new Comment();
                        comment.setId(rs.getInt("id_comment"));
                        comment.setDesc(rs.getString("c_description"));
                        comment.setWriteDate(rs.getTimestamp("write_date").toLocalDateTime());
                        User user1 = new User();
                        user1.setId(rs.getInt("c_id_user"));
                        user1.setFirstName(rs.getString("c_first_name"));
                        user1.setLastName(rs.getString("c_last_name"));
                        comment.setUser(user1);
                        topic.addComment(comment);
                    } while (rs.next());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return topic;
    }

    @Override
    public List<Topic> getPopularTopics() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Topic> listTopic = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_POPULAR_TOPICS_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getInt("id_topic"));
                topic.setTitle(rs.getString("title"));
                topic.setCommentCount(rs.getInt("comments"));
                listTopic.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return listTopic;
    }
}
