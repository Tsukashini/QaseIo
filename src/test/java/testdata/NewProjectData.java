package testdata;

import models.NewProjectModel;
import utilities.FakerMessage;

public class NewProjectData {

    public static NewProjectModel getNewProjectData() {
        return NewProjectModel
                .builder()
                .name(FakerMessage.getProjectName())
                .description(FakerMessage.getDescription())
                .type(FakerMessage.getType())
                .build();
    }
}
