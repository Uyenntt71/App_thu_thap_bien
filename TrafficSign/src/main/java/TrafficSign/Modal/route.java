package TrafficSign.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class route {
    private UUID id;
    private double start_lat;
    private double start_lng;
    private double end_lat;
    private double end_lng;
    private long start_time;
    private long end_time;
    private ArrayList<geo_points> geo_points;
    private Timestamp create_at;
    private Timestamp update_at;
}
