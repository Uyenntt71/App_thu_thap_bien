package TrafficSign.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class traffic_signs_type {
    private UUID id;
    private String type;
    private String name;
    private String description;
    private String sign;
    private Timestamp create_at;
    private Timestamp update_at;
}
