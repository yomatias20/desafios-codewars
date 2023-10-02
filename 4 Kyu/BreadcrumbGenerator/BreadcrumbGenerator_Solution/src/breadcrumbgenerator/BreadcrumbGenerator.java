package breadcrumbgenerator;

import java.util.Arrays;

public class BreadcrumbGenerator {

    public static void main(String[] args) {
        String url = "www.codewars.com/users/GiacomoSorbi"; // try other values
        String separator = " : "; // try other values
        String result = generate_bc(url, separator); 
        System.out.println("URL ingresada: " + url);
        System.out.println("Separador ingresado: \"" + separator + "\"\n");
        System.out.println("Resultado: " + result + "\n");
    }
    
    public static String generate_bc(String url, String separator) {
        String result;
        String partModified;
        String completePath = "/";
        String[] wordsToIgnore = {"the","of","in","from","by","with","and", "or", "for", "to", "at", "a"};
        if (url.startsWith("http://")) url = url.substring(7);
        if (url.startsWith("https://")) url = url.substring(8);
        url = url.split("[#?]")[0];
        String[] parts = url.split("/");
        String[] partsWithoutIndex = parts.length > 1 && parts[parts.length -1].startsWith("index.") 
                ? Arrays.copyOf(parts, parts.length - 1) : Arrays.copyOf(parts, parts.length);
        if (partsWithoutIndex.length == 1) {
            return "<span class=\"active\">HOME</span>";
        }
        result = "<a href=\"/\">HOME</a>" + separator;
        for (int i = 1; i < partsWithoutIndex.length; i++) {
            completePath += partsWithoutIndex[i] + "/";
            partModified = partsWithoutIndex[i].toUpperCase();
            partModified = partModified.replace('-', ' ').replace('_', ' ');
            if (partModified.length() > 30 ) {
                String[] initials = Arrays.stream(partModified.split(" "))
                        .filter(s -> Arrays.stream(wordsToIgnore).noneMatch(t -> t.equalsIgnoreCase(s)))
                        .map(s -> s.substring(0, 1)).toArray(String[] :: new);
                partModified = "";
                for (int j = 0; j < initials.length; j++) {
                    partModified += initials[j];
                }
            }
            if (i == partsWithoutIndex.length - 1) {
                partModified = partModified.split("\\.")[0];
                result = result + "<span class=\"active\">" + partModified + "</span>";
            } else {
                result = result + "<a href=\"" + completePath + "\">" + partModified + "</a>" + separator;
            }
        }
        return result;
    }
    
}
