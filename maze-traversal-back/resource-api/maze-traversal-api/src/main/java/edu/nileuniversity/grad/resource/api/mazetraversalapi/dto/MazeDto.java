package edu.nileuniversity.grad.resource.api.mazetraversalapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MazeDto {
    @NotBlank(message = "Initial Maze is mandatory.")
    String initialMaze;

    String solvedMaze;
}
