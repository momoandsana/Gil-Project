package com.web.gilproject.dto.BoardDTO;

import com.web.gilproject.domain.Path;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public record BoardPathDTO(
        Long id,
        String title,
        String content,
        Integer time,
        double distance,
        double startLat,
        double startLong,
        List<Map<String, Double>> route
) {
    public static BoardPathDTO from(Path path) {
        return new BoardPathDTO(
                path.getId(),
                path.getTitle(),
                path.getContent(),
                path.getTime(),
                path.getDistance(),
                path.getStartLat(),
                path.getStartLong(),
                Arrays.stream(path.getRoute().getCoordinates())
                        .map(coord -> Map.of("lat", coord.y, "lng", coord.x))
                        .toList()
        );
    }
}
