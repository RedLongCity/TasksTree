package history;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Parser {

    private final RestTemplate rest;
    private final ObjectMapper objectMapper;
    private final String url;

    protected List<ResponseItem> extract() throws IOException {
        String response = rest.getForObject(url, String.class);
        return objectMapper.readValue(response, new TypeReference<List<ResponseItem>>() {});
    }

}
