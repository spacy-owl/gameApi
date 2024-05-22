package unendeus.unendeus_blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import unendeus.unendeus_blog.dto.CypherDTO;
import unendeus.unendeus_blog.dto.CypherInfoDTO;


@RestController
@RequestMapping("/cyphers")
@RequiredArgsConstructor
public class CyphersController {
    private final String api_key = "pdfTTotm5syUvD9dt0B8sE2c8cVYJUdH";

    @PostMapping
    public ResponseEntity<CypherInfoDTO> CypherName(@RequestBody CypherDTO cypherDTO){
        String playerId = null;

        if (cypherDTO.gameTypeId == null) {
            cypherDTO.gameTypeId = "rating";
        }

        WebClient webClient = WebClient.builder().build();

        String getPlayerId = "https://api.neople.co.kr/cy/players?nickname="+cypherDTO.name+"&apikey="+api_key;

        String ret = webClient.get()
                .uri(getPlayerId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파싱
            JsonNode rootNode = objectMapper.readTree(ret);

            // "rows" 배열에서 첫 번째 요소 선택
            JsonNode rowsNode = rootNode.get("rows").get(0);

            // "playerId" 필드 값 추출
            playerId = rowsNode.get("playerId").asText();

            String getMatches = "https://api.neople.co.kr/cy/players/"+playerId+"/matches?gameTypeId="+cypherDTO.gameTypeId+"&limit=10&apikey="+api_key;

            CypherInfoDTO response = webClient.get()
                    .uri(getMatches)
                    .retrieve()
                    .bodyToMono(CypherInfoDTO.class)
                    .block();

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
