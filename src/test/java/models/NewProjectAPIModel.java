package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class NewProjectAPIModel {
    private String title;
    private String code;
    private String description;
    private String access;
}
