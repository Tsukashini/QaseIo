package testdata;

import models.NewProjectAPIModel;
import utilities.FakerMessage;

public class NewProjectAPIData {

    public static NewProjectAPIModel getNewProjectAPIData() {
        return NewProjectAPIModel
                .builder()
                .title(FakerMessage.getProjectName())
                .code(FakerMessage.getCode())
                .description(FakerMessage.getDescription())
                .access("none")
                .build();
    }
}
