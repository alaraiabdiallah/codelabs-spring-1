package id.gits.springcodelabs1.Invokers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.Responses.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApiResponseInvoke<T> {

    private HttpHeaders responseHeaders;
    private Gson gsonBuilder;


    public ApiResponseInvoke(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/json");
        gsonBuilder = new GsonBuilder().create();
    }
    public ResponseEntity<ApiResponse> invoke(BaseCommand command) throws Exception {
        T result = (T) command.execute();
        T json = (T) gsonBuilder.toJson(result);
        ApiResponse response = new ApiResponse(200,result);
        return ResponseEntity.status(200)
                .headers(responseHeaders)
                .body(response);

    }

}
