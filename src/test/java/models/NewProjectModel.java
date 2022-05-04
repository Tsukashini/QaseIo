package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class NewProjectModel {
    private String name;
    private String code;
    private String description;
    private int type;
}
