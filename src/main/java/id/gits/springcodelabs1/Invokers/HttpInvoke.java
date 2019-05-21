package id.gits.springcodelabs1.Invokers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.gits.springcodelabs1.BaseCommand;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HttpInvoke<T> {

    public ResponseEntity<T> invoke(BaseCommand command){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","application/json");
        Gson gsonBuilder = new GsonBuilder().create();
        T json = (T) gsonBuilder.toJson(command.execute());
        if (!json.equals("null"))
            return ResponseEntity.ok().headers(responseHeaders).body(json);
        return ResponseEntity.noContent().build();
    }
}
