package testdata;

import models.SuiteModel;
import utilities.FakerMessage;

public class NewSuiteData {

    public static SuiteModel getNewSuitData() {
        return SuiteModel
                .builder()
                .suiteName(FakerMessage.getProjectName())
                .description(FakerMessage.getDescription())
                .precondition(FakerMessage.getPrecondition())
                .build();
    }
}
