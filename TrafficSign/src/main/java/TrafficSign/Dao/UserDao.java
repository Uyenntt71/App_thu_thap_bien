package TrafficSign.Dao;

import TrafficSign.Modal.map_state;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.UUID;

@Repository
public class UserDao {
    private String connectionUrl = "jdbc:postgresql://localhost/traffic_signs";
    private String user = "postgres";
    private String pass = "12345678";
    private Connection conn;

    public UserDao() {
        conn = connect(connectionUrl, user, pass);
    }

    public Connection connect(String url, String user, String pass) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to the PosgreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public map_state getTrafficSign(UUID id) {
        map_state ms = new map_state();
        String sqlSelectATrafficSign = "select * from traffic_signs.map_state where id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
            ps.setObject(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double lat = rs.getDouble("lat");
                double lng = rs.getDouble("lng");
                ;
                double acc = rs.getDouble("acc");
                ;
                double azimuth = rs.getDouble("azimuth");
                ;
                long insert_time = rs.getLong("insert_time");
                UUID type_id = (UUID) rs.getObject("type_id");
                int speed = rs.getInt("speed");
                String info = rs.getString("info");
                UUID parent_id = (UUID) rs.getObject("parent_id");
                UUID image_id = (UUID) rs.getObject("image_id");
                String action = rs.getString("action");
                String description = rs.getString("description");
                UUID route_id = (UUID) rs.getObject("route_id");
                boolean validated = rs.getBoolean("validated");
                Timestamp create_at = rs.getTimestamp("create_at");
                Timestamp update_at = rs.getTimestamp("update_at");
                ms = new map_state(id, lat, lng, acc, azimuth, insert_time, type_id, speed, info, parent_id, image_id,
                        action, description, route_id, validated, create_at, update_at);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return ms;
    }

    public map_state delTrafficSign(UUID id) {
        String sqlSelectATrafficSign = "update traffic_signs.map_state set action = 'delete' where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        map_state ms = getTrafficSign(id);
        return ms;
    }


//    public map_state modifyTrafficSign(UUID id, double lat, double lng, double acc, double azimuth, long insert_time,
//                                 UUID type_id, int speed, String info, UUID parent_id, UUID image_id, String action,
//                                    String description, UUID route_id, boolean validated, Timestamp create_at,
//                                    Timestamp update_at) {
//        String sqlSelectATrafficSign = "update map_state set (id, lat, lng, acc, azimuth, insert_time, type_id, " +
//                "speed, info, parent_id, image_id, action, description, route_id, validated, create_at, update_at) " +
//                "values (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where id = ?";
//        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
//            ps.setObject(1, id);
//            ps.setDouble(2, lat);
//            ps.setDouble(3, lng);
//            ps.setDouble(4, acc);
//            ps.setDouble(5, azimuth);
//            ps.setLong(6, insert_time);
//            ps.setObject(7, type_id);
//            ps.setInt(8, speed);
//            ps.setString(9, info);
//            ps.setObject(10, parent_id);
//            ps.setObject(11, image_id);
//            ps.setString(12, action);
//            ps.setString(13, description);
//            ps.setObject(14, route_id);
//            ps.setBoolean(15, validated);
//            ps.setTimestamp(16, create_at);
//            ps.setTimestamp(17, update_at);
//            ps.setObject(18, id);
//            ResultSet rs = ps.executeQuery();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return getTrafficSign(id);
//    }
    public map_state modifyTrafficSign(map_state ms) {
//        String sqlSelectATrafficSign = "update map_state set (id, lat, lng, acc, azimuth, insert_time, type_id, " +
//                "speed, info, parent_id, image_id, action, description, route_id, validated, create_at, update_at) " +
//                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where id = ?";
        String sqlSelectATrafficSign = "update  traffic_signs.map_state set " +
                "id = ?," +
                "lat = ?," +
                "lng = ?" +
                "acc = ?," +
                "azimuth = ?," +
                "insert_time = ?," +
                "type_id = ?," +
                "speed = ?" +
                "info =?," +
                "parent_id = ?," +
                "image_id = ?," +
                "action = ?" +
                "description = ?," +
                "route_id = ?," +
                "validated = ?," +
                "create_at = ?," +
                "update_at = ?" +
                " where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
            ps.setObject(1, ms.getId());
            ps.setDouble(2, ms.getLat());
            ps.setDouble(3, ms.getLng());
            ps.setDouble(4, ms.getAcc());
            ps.setDouble(5, ms.getAzimuth());
            ps.setLong(6, ms.getInsert_time());
            ps.setObject(7, ms.getType_id());
            ps.setInt(8, ms.getSpeed());
            ps.setString(9, ms.getInfo());
            ps.setObject(10, ms.getParent_id());
            ps.setObject(11, ms.getImage_id());
            ps.setString(12, ms.getAction());
            ps.setString(13, ms.getDescription());
            ps.setObject(14, ms.getRoute_id());
            ps.setBoolean(15, ms.isValidated());
            ps.setTimestamp(16, ms.getCreate_at());
            ps.setTimestamp(17, ms.getUpdate_at());
            ps.setObject(18, ms.getId());
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return getTrafficSign(ms.getId());
    }
    public map_state modyfyTrafficSign(UUID id, double lat, double lng){
        String sqlSelectATrafficSign = "insert into traffic_signs.map_state (id, lat, lng) values (?, ?, ?)";
        //id = UUID.randomUUID();
        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
            ps.setObject(1, id);
            ps.setObject(2, lat);
            ps.setObject(3, lng);
            ResultSet rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        map_state ms = getTrafficSign(id);
        return ms;
    }
    public map_state addTrafficSign(map_state ms){
        String sqlSelectATrafficSign = "insert into traffic_signs.map_state (id, lat, lng, acc, azimuth, insert_time, type_id, " +
                "speed, info, parent_id, image_id, action, description, route_id, validated, create_at, update_at) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlSelectATrafficSign);) {
            ps.setObject(1, ms.getId());
            ps.setDouble(2, ms.getLat());
            ps.setDouble(3, ms.getLng());
            ps.setDouble(4, ms.getAcc());
            ps.setDouble(5, ms.getAzimuth());
            ps.setLong(6, ms.getInsert_time());
            ps.setObject(7, ms.getType_id());
            ps.setInt(8, ms.getSpeed());
            ps.setString(9, ms.getInfo());
            ps.setObject(10, ms.getParent_id());
            ps.setObject(11, ms.getImage_id());
            ps.setString(12, ms.getAction());
            ps.setString(13, ms.getDescription());
            ps.setObject(14, ms.getRoute_id());
            ps.setBoolean(15, ms.isValidated());
            ps.setTimestamp(16, ms.getCreate_at());
            ps.setTimestamp(17, ms.getUpdate_at());
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return getTrafficSign(ms.getId());
    }
}