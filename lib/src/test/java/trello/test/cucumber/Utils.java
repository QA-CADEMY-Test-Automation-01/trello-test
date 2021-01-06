package trello.test.cucumber;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String buildEndpoind(Helper context, String endPoint) {
        String[] endpoindSplit = endPoint.split("/");
        for (int i = 0; i < endpoindSplit.length; i++) {
            Pattern pattern = Pattern.compile("(?<=\\()(.*?)(?=\\))");
            Matcher matcher = pattern.matcher(endpoindSplit[i]);
            if (matcher.find()) {
                endpoindSplit[i] = getElementResponse(context, matcher.group(1));
            }
        }
        return String.join("/", endpoindSplit);
    }

    private static String getElementResponse(Helper helper, String group) {
        String[] elementSplit = group.split("\\.");
        Response response = (Response) helper.context.get(elementSplit[0]);
        return response.jsonPath().getString(elementSplit[1]);
    }

    public static String buildBody(Helper helper, String body) {
        if (!body.contains("(")) {
            return body;
        }
        int index = 0;
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("(?<=\\()(.*?)(?=\\))");
        Matcher matcher = pattern.matcher(body);
        while (matcher.find()) {
            result.append(body, index, matcher.start()).append(getElementResponse(helper, matcher.group(1)));
            index = matcher.end();
        }
        if (index < body.length()) {
            result.append(body, index, body.length());
        }

        return cleanString(result.toString());
    }

    private static String cleanString(String stringResult) {
        return stringResult.replace("(", "").replace(")", "");
    }
}
