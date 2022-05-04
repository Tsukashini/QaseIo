package testdata;

import models.TestCaseModel;
import utilities.FakerMessage;

public class NewTestCaseData {

    public static TestCaseModel getNewTestCaseData() {
        return TestCaseModel
                .builder()
                .title(FakerMessage.getProjectName())
                .description(FakerMessage.getDescription())
                .build();
    }
}
