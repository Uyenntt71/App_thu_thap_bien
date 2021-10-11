package TrafficSign.Controller;

import TrafficSign.Modal.map_state;
import TrafficSign.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get-traffic-sign")
    public map_state getTrafficSign(@RequestParam UUID id){
        return userService.getTrafficSign(id);
    }

    @GetMapping("/del-traffic-sign/{id}")
    public map_state delTraffic(@PathVariable UUID id){
        return userService.delTrafficSign(id);
    }
    @GetMapping("/modify-traffic-sign")
//    public map_state modifyTrafficSign(@RequestParam UUID id,@RequestParam double lat,@RequestParam double lng,@RequestParam double acc,@RequestParam double azimuth,@RequestParam long insert_time,
//                               @RequestParam UUID type_id,@RequestParam int speed,@RequestParam String info,@RequestParam UUID parent_id,@RequestParam UUID image_id,@RequestParam String action,
//                               @RequestParam String description,@RequestParam UUID route_id,@RequestParam boolean validated,@RequestParam Timestamp create_at,
//                               @RequestParam Timestamp update_at){
//        return userService.modifyTrafficSign(id,  lat,  lng,  acc,  azimuth,  insert_time,
//                type_id,  speed,  info,  parent_id,  image_id,  action, description,
//                route_id,  validated,  create_at, update_at);
//    }
    public map_state modifyTrafficSign(@RequestBody map_state ms){
        return userService.modifyTrafficSign(ms);
    }

    @GetMapping("/add-traffic-sign")
    public map_state addTrafficSign(@RequestBody map_state ms){
        return userService.addTrafficSign(ms);
    }
    @GetMapping("/modyfy-traffic")
    public map_state modyfyTrafficSign(@RequestParam UUID id,@RequestParam double lat,@RequestParam double lng){
        return userService.modyfyTrafficSign( id,  lat,  lng);
    }
}
