package trello.test.cucumber;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String buildEndpoind(Helper context, String endPoint) {
        String[] endpoindSplit = endPoint.split("/");

        for (int i = 0; i < endpoindSplit.length; i++) {
            Pattern pattern = Pattern.compile("(?<=\\[)(.*?)(?=\\])");
            Matcher matcher = pattern.matcher(endpoindSplit[i]);
            if (matcher.find()){
                endpoindSplit[i] = getElementResponse(context, matcher.group(1));
            }
        }
        return String.join("/", endpoindSplit);
    }

    private static String getElementResponse(Helper context, String group) {
        String[] elementSplit = group.split("\\.");
        Response response = (Response) context.context.get(elementSplit[0]);
        return response.jsonPath().getString(elementSplit[1]);
    }

    public static String buildBody(Helper context, String body) {
        int index = 0; // manejamos un indice para saber en que parte del body string estamos
        StringBuilder result = new StringBuilder(); // agregamos un builder para concatenar el body
        Pattern pattern = Pattern.compile("(?<=\\[)(.*?)(?=\\])"); // Regex para encontrar los parametros q tengan el formato [test.id]
        Matcher matcher = pattern.matcher(body); // buscamos las conicidencias
        while (matcher.find()){
            result.append(body, index,matcher.start()).append(getElementResponse(context, matcher.group(1)));
            // remplazamos la primera conincidencia
            index = matcher.end();
        }
        if (index < body.length()){
            result.append(body, index, body.length()); // agregamos el resto del body si no hay mas conincidencias
        }
        return cleanString(result.toString()); // quitamos los corchetes del body
    }

    private static String cleanString(String stringResult) {
        return stringResult.replace("[", "").replace("]", "");
    }
}
