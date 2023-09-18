package MainClasses;

import helpers.ViewHelper;

public class Service {

    public static String importation(String NameOfModel) {
        String string = "package services;\n";
        string += "import java.sql.Connection;\n";
        string += "import java.sql.SQLException;\n";
        string += "import java.util.List;\n";
        string += "import repositories." + NameOfModel + "Repository;\n";
        string += "import models." + NameOfModel + ";\n\n";

        return string;
    }

    public static String constructor(String NameOfService, String NameOfModel) {

        String string = "    public " + NameOfService + "(Connection connection) {\n";
        string += "        " + NameOfModel.toLowerCase() + "Repository = new " + NameOfModel
                + "Repository(connection);\n";
        string += "    }\n\n";

        return string;
    }

    public static String insert(String NameOfModel) {

        String string = "    public void create" + NameOfModel + "(" + NameOfModel + " " + NameOfModel.toLowerCase()
                + ") throws SQLException {\n";
        string += "        " + NameOfModel.toLowerCase() + "Repository.create" + NameOfModel + "("
                + NameOfModel.toLowerCase() + ");\n";
        string += "    }\n\n";

        return string;
    }

    public static String update(String NameOfModel) {

        String string = "    public void update" + NameOfModel + "(" + NameOfModel + " " + NameOfModel.toLowerCase()
                + ") throws SQLException {\n";
        string += "        " + NameOfModel.toLowerCase() + "Repository.update" + NameOfModel + "("
                + NameOfModel.toLowerCase() + ");\n";
        string += "    }\n\n";

        return string;
    }

    public static String delete(String NameOfModel, String[] NameOfAttributes, String[] TypeOfAttributes) {

        String string = "    public void delete" + NameOfModel + "(" + TypeOfAttributes[0] + " " + NameOfAttributes[0]
                + ") throws SQLException {\n";
        string += "        " + NameOfModel.toLowerCase() + "Repository.delete" + NameOfModel + "("
                + NameOfAttributes[0] + ");\n";
        string += "    }\n\n";

        return string;
    }

    public static String getAll(String NameOfModel) {

        String string = "    public List<" + NameOfModel + "> getAll" + NameOfModel + "s() throws SQLException {\n";
        string += "        return " + NameOfModel.toLowerCase() + "Repository.getAll" + NameOfModel + "s();\n";
        string += "    }\n\n";

        return string;
    }

    public static String getOne(String NameOfModel, String[] NameOfAttributes, String[] TypeOfAttributes) {
        String string = "    public " + NameOfModel + " getOne" + NameOfModel + "(" + TypeOfAttributes[0] + " "
                + NameOfAttributes[0] + ") throws SQLException {\n";
        string += "        return " + NameOfModel.toLowerCase() + "Repository.getOne" + NameOfModel + "("
                + NameOfAttributes[0] + ");\n";
        string += "    }\n\n";

        return string;
    }

    public static String getCount(String NameOfModel) {
        String string = "    public int getCount" + NameOfModel + "s() throws SQLException {\n";
        string += "        return " + NameOfModel.toLowerCase() + "Repository.getCount" + NameOfModel + "s();\n";
        string += "    }\n";

        return string;
    }

    public static String search(String NameOfModel, String[] NameOfAttributes, String[] TypeOfAttributes) {
        String string = "";

        for (int i = 0; i < NameOfAttributes.length; i++) {
            String attributeName = NameOfAttributes[i];
            String searchMethodName = "search" + NameOfModel + "sBy" + ViewHelper.BigFirstChar(attributeName);
            string += "    public List<" + NameOfModel + "> " + searchMethodName + "(" + TypeOfAttributes[i] + " "
                    + attributeName + ") throws SQLException {\n";
            string += "        return " + NameOfModel.toLowerCase() + "Repository." + searchMethodName + "("
                    + attributeName + ");\n";
            string += "    }\n\n";
        }

        return string;
    }

}