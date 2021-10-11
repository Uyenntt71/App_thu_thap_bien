package TrafficSign.Service;


import TrafficSign.Dao.UserDao;
import TrafficSign.Modal.map_state;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public map_state getTrafficSign(UUID id){
        return userDao.getTrafficSign(id);
    }
    public map_state delTrafficSign(UUID id){
        return userDao.delTrafficSign(id);
    }
    public map_state modifyTrafficSign(map_state ms){
        return userDao.modifyTrafficSign(ms);
    }

    public map_state addTrafficSign(map_state ms){
        return userDao.addTrafficSign(ms);
    }

    public map_state modyfyTrafficSign(UUID id, double lat, double lng){
        return  userDao.modyfyTrafficSign( id,  lat,  lng);
    }
}
