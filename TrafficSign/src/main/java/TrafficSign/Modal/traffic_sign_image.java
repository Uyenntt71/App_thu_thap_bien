package TrafficSign.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class traffic_sign_image {
    private UUID id;
    private byte image;
    private Timestamp create_at;
    private Timestamp update_at;
}
