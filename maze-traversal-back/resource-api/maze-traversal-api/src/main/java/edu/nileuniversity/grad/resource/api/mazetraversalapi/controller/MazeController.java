package edu.nileuniversity.grad.resource.api.mazetraversalapi.controller;

import com.activedge.test.resource.pojo.RestResponsePojo;
import edu.nileuniversity.grad.resource.api.mazetraversalapi.dto.MazeDto;
import edu.nileuniversity.grad.resource.api.mazetraversalapi.services.MazeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/maze")
@Slf4j
public class MazeController {
    private final MazeService mazeService;

    public MazeController(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @CrossOrigin
    @PostMapping("")
    public RestResponsePojo<MazeDto> solveMaze(@Valid @RequestBody MazeDto mazeDto) {
        RestResponsePojo<MazeDto> responsePojo = new RestResponsePojo<>();

        mazeDto = mazeService.solveMaze(mazeDto);

        responsePojo.setMessage("Maze successfully solved.");
        responsePojo.setData(mazeDto);
        return responsePojo;
    }
}
