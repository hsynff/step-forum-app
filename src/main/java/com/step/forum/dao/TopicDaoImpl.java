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

public class TopicDaoImpl implements TopicDAO {
    private final String GET_ALL_TOPIC_SQL = "select t.id_topic, t.title, t.description, t.share_date, t.view_count, u.id_user, u.email, u.first_name, u.last_name, c.id_comment, c.description, c.write_date from topic t inner join user u on t.id_user = u.id_user left join comment c on c.id_topic = t.id_topic order by t.share_date desc";

    @Override
    public List<Topic> getAllTopic() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Topic> list = new ArrayList<>();

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_TOPIC_SQL);
            rs = ps.executeQuery();
            Map<Integer, Topic> map = new LinkedHashMap<>();
            while (rs.next()){
                Topic t = map.get(rs.getInt("id_topic"));

                if (t == null){
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

                if (rs.getInt("id_comment") != 0){
                    Comment c = new Comment();
                    c.setId(rs.getInt("id_comment"));
                    c.setDesc(rs.getString("description"));
                    c.setWriteDate(rs.getTimestamp("write_date").toLocalDateTime());
                    t.addComment(c);
                }
            }

            list = new ArrayList<>(map.values());


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con, ps, rs);
        }

        return list;
    }
}
