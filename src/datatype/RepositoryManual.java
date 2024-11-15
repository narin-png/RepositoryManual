package datatype;



import java.lang.reflect.Field;
import java.util.Arrays;

public class RepositoryManual {
    static String[][] person = {{"int", "id"}, {"String", "name"}, {"String", "surname"}};

    public static void main (String[] args){
        Field[] fields = RepositoryManual.class.getDeclaredFields();
        String fieldsnew = Arrays.toString(fields);
        String a = RepositoryManual.class.getName();
        int b = fieldsnew.indexOf(a);
        int alength = a.length();
        int fieldslenght = fieldsnew.length();
        String arrayname = fieldsnew.substring(b + alength + 1, fieldslenght - 1);
        String firstletter = String.valueOf(arrayname.charAt(0)).toUpperCase();
        String[] splitname = (arrayname.split(String.valueOf(arrayname.charAt(0))));
        String finalclassname = firstletter.concat(splitname[1]);


        System.out.println("public class " + finalclassname + "{");
        for (int i = 0; i < person.length; i++) {
            String firstpart = Arrays.toString(person[i]).substring(1, person[i][0].length() + 1);
            String secondpart = Arrays.toString(person[i]).substring(person[i][0].length() + 2).replace("]", "");
            System.out.println("private" + " " + firstpart + " " + secondpart + ";");
        }

        System.out.print("public " + finalclassname + "(");
        for (int i = 0; i < person.length; i++) {
            String firstpart = Arrays.toString(person[i]).substring(1, person[i][0].length() + 1);
            String secondpart = Arrays.toString(person[i]).substring(person[i][0].length() + 2).replace("]", "");
            System.out.print(firstpart + " " + secondpart);

            if (i < person.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(") { ");

        for (int i = 0; i < person.length; i++) {
            String secondpart = Arrays.toString(person[i]).substring(person[i][0].length() + 2).replace("]", "");
            System.out.println("this."+secondpart+"="+secondpart+";");

        }
        System.out.println("}");

        for (int i = 0; i < person.length; i++) {
            String firstpart = Arrays.toString(person[i]).substring(1, person[i][0].length() + 1);
            String secondpart = Arrays.toString(person[i]).substring(person[i][0].length() + 2).replace("]", "").trim();

            System.out.println("public " + firstpart + " get" + secondpart.substring(0, 1).toUpperCase() + secondpart.substring(1) + "() {");
            System.out.println("    return " + secondpart + ";");
            System.out.println("}");
        }

        for (int i = 0; i < person.length; i++) {
            String firstpart = Arrays.toString(person[i]).substring(1, person[i][0].length() + 1);
            String secondpart = Arrays.toString(person[i]).substring(person[i][0].length() + 2).replace("]", "").trim();

            System.out.println("public " + "void" + " set" + secondpart.substring(0, 1).toUpperCase() + secondpart.substring(1) + "() {");
            System.out.println("    this." + secondpart +"="+secondpart+ ";");
            System.out.println("}");
        }


        System.out.println("public String toString() {");
        System.out.print("    return \"" + finalclassname + "{\" +\n");

        for (int i = 0; i < person.length; i++) {
            String secondPart = person[i][1];  // Field name from the array
            if (i == 0) {
                // For the first field, no comma
                System.out.println("        \"" + secondPart + "=\" + " + secondPart);
            } else {
                // For subsequent fields, add a comma
                System.out.println(" + \", " + secondPart + "='\" + " + secondPart + " + \"'\"");
            }
        }
        System.out.println(" + '}';");
        System.out.println("}");
    }


}






