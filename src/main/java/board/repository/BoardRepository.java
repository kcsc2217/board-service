package board.repository;

import board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    Board findById(Long id);
    List<Board> findByAll();

    void upDate(Long id, Board board);

    void deleteBoard(Long id);

    void clearStore();








}
