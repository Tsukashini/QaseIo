package testdata;


import models.ProjectTitlesModel;

public class ProjectListData {

    public static ProjectTitlesModel getProjectTitle(String title) {
        return ProjectTitlesModel
                .builder()
                .title(title)
                .build();
    }
}
