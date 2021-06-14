package edu.nileuniversity.grad.resource.api.mazetraversalapi.services;

import edu.nileuniversity.grad.resource.api.mazetraversalapi.dto.MazeDto;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class MazeService {

    public MazeDto solveMaze(MazeDto mazeDto) {
        String initialMaze = mazeDto.getInitialMaze();

        Maze maze = new Maze(initialMaze);
        String solvedMaze = dfs(maze);

        mazeDto.setSolvedMaze(solvedMaze);

        return mazeDto;
    }

    private static String dfs(Maze maze) {
        DFSMazeSolver dfs = new DFSMazeSolver();
        List<Coordinate> path = dfs.solve(maze);

        Assert.isTrue(path.size() != 0, "Maze has no solution.");

        String solvedMaze = maze.getPath(path);
        maze.reset();

        return solvedMaze;
    }
}
