package TrafficSign.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class map_state {
    private UUID id;
    private double lat;
    private double lng;
    private double acc;
    private double azimuth;
    private long insert_time;
    private UUID type_id;
    private int speed;
    private String info;
    private UUID parent_id;
    private UUID image_id;
    private String action;
    private String description;
    private UUID route_id;
    private boolean validated;
    private Timestamp create_at;
    private Timestamp update_at;
}
