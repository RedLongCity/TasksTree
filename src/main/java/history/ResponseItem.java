package history;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseItem {

    private String eventId;
    private String editor;
    private String fieldName;
    private String field;
    private String entityName;

    /**
     * e.g. 2019-02-12T13:54:38.770+0000
     */
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSZ")
    private LocalDateTime changeDate;

    private long entityId;
    private String eventType;
    private String value;

}
