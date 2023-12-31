package MainClasses;

import helpers.ViewHelper;

public class Models {

    public static String fields(String[] NameOfAttributes, String[] TypeOfAttributes) {
        String string = "";

        for (int i = 0; i < NameOfAttributes.length; i++) {
            string += "    public " + TypeOfAttributes[i] + " " + NameOfAttributes[i] + ";\n";
        }

        return string;
    }

    public static String constructor(String NameOfModel, String[] NameOfAttributes, String[] TypeOfAttributes) {

        String string = "public " + NameOfModel + "() {\n\n";
        string += "}\n\n";

        string += "public " + NameOfModel + "(";

        for (int i = 0; i < NameOfAttributes.length; i++) {
            string += TypeOfAttributes[i] + " " + NameOfAttributes[i];

            if (i < NameOfAttributes.length - 1) {
                string += ", ";
            }
        }

        string += ") {\n\n";

        for (int i = 0; i < NameOfAttributes.length; i++) {
            string += "    this." + NameOfAttributes[i] + " = " + NameOfAttributes[i] + ";\n";
        }

        string += "}\n\n";

        return string;
    }

    public static String gettersAndSetters(String[] NameOfAttributes, String[] TypeOfAttributes) {
        String string = "";

        for (int i = 0; i < NameOfAttributes.length; i++) {
            string += "    public " + TypeOfAttributes[i] + " get" + ViewHelper.BigFirstChar(NameOfAttributes[i])
                    + "() {\n";
            string += "        return " + NameOfAttributes[i] + ";\n";
            string += "    }\n";

            string += "    public void set" + ViewHelper.BigFirstChar(NameOfAttributes[i]) + "("
                    + TypeOfAttributes[i] + " "
                    + NameOfAttributes[i] + ") {\n";
            string += "        this." + NameOfAttributes[i] + " = " + NameOfAttributes[i] + ";\n";
            string += "    }\n";
        }
        return string;
    }

}
