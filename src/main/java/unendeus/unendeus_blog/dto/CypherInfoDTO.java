package unendeus.unendeus_blog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CypherInfoDTO {
    private String playerId;
    private String nickname;
    private int grade;
    private boolean tierTest;
    private RepresentDTO represent;
    private String clanName;
    private int ratingPoint;
    private int maxRatingPoint;
    private String tierName;
    private List<RecordDTO> records;
    private MatchesDTO matches;
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RepresentDTO {
    private String characterId;
    private String characterName;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RecordDTO {
    private String gameTypeId;
    private int winCount;
    private int loseCount;
    private int stopCount;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MatchesDTO {
    private DateDTO date;
    private String gameTypeId;
    private String next;
    private List<MatchRowDTO> rows;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class DateDTO {
    private String start;
    private String end;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MatchRowDTO {
    private String date;
    private String matchId;
    private MapDTO map;
    private PlayInfoDTO playInfo;
    private PositionDTO position;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MapDTO {
    private String mapId;
    private String name;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PlayInfoDTO {
    private String result;
    private boolean random;
    private int partyUserCount;
    private List<?> partyInfo; // Adjust type accordingly
    private String playTypeName;
    private String characterId;
    private String characterName;
    private int level;
    private int killCount;
    private int deathCount;
    private int assistCount;
    private int attackPoint;
    private int damagePoint;
    private int battlePoint;
    private int sightPoint;
    private int towerAttackPoint;
    private int backAttackCount;
    private int comboCount;
    private int spellCount;
    private int healAmount;
    private int sentinelKillCount;
    private int demolisherKillCount;
    private int trooperKillCount;
    private int guardianKillCount;
    private int guardTowerKillCount;
    private int getCoin;
    private int spendCoin;
    private int spendConsumablesCoin;
    private int playTime;
    private int responseTime;
    private int minLifeTime;
    private int maxLifeTime;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PositionDTO {
    private String name;
    private String explain;
    private List<AttributeDTO> attribute;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AttributeDTO {
    private Integer level;
    private String id;
    private String name;
}