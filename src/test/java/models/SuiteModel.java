package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class SuiteModel {
    private String description;
    private String precondition;
    private String suiteName;

}
