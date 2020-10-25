package CNVP_Lab3_Server;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;

public class OperationDispatch {
    public static String getOperation(String receivedData) throws IOException {
        return JsonParser.convertFromJson(receivedData);
    }

    public static boolean getStatusOfOperation(String receivedData) throws IOException {
        String operation = getOperation(receivedData);
        if (operation.equals("exit")) return false;
        else return true;
    }

    public static byte[] getTodayData() throws JsonProcessingException {
        LocalDate localDate = getLocalDate();
        String todayDate = localDate.toString();
        return DataToSend.convertJsonToBytes(todayDate);
    }

    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public static byte[] getCurrentTime() throws JsonProcessingException {
        LocalTime localTime = getLocalTime();
        String currentTime = localTime.toString();
        return DataToSend.convertJsonToBytes(currentTime);
    }


    public static byte[] getSurnames() throws JsonProcessingException {
        String dataToSend = String.join(" ", "ПОЛІЩУК", "ШЕВЧУК", "ПОПОВА", "ХАЧАТУРЯН", "СЕРДЮК");
        return DataToSend.convertJsonToBytes(dataToSend);
    }


}
