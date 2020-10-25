package CNVP_Lab3_Server;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataToSend {
    public static byte[] getDataToSend(String receivedData) throws IOException {
        String operation = OperationDispatch.getOperation(receivedData);
        if (operation.equals("GetTodayDate")) {
            return OperationDispatch.getTodayData();
        } else if (operation.equals("GetCurrentTime")) {
            return OperationDispatch.getCurrentTime();
        } else if (operation.equals("GetNumberOfMyBrigadeAndSurnames")) {
            return OperationDispatch.getSurnames();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static byte[] convertJsonToBytes(String dataToSend) throws JsonProcessingException {
        String json = JsonParser.convertToJson(dataToSend);
        return json.getBytes(StandardCharsets.UTF_8);
    }
}
