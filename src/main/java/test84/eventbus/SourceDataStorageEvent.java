package test84.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class SourceDataStorageEvent implements BaseEvent {

    private String dataJson;
    private String targetDbTable;

}
