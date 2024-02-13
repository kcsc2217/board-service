package board.boardservice.repository;

import board.boardservice.domain.Board;

import java.util.List;


public interface BoardRepository {

    Board save(Board board);
    Board findById(Long id);

    Board findBysub(String sub);
    List<Board> findByAll();

    void upDate(Long id, Board board);

    void deleteBoard(Long id);

    void clearStore();








}
