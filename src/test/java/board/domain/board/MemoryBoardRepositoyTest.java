package board.domain.board;

import board.domain.Board;
import board.repository.BoardRepository;
import board.repository.MemoryBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;


public class MemoryBoardRepositoyTest {

    BoardRepository boardRepository = new MemoryBoardRepository();

    @AfterEach
    void afterEach() {
        boardRepository.clearStore();
    }

    @Test
    void contextLoads() {
        Board board = new Board("ㅋㅋ", "안녕", new Date());
        Board saveBoard = boardRepository.save(board);

        Board findByBoard = boardRepository.findById(board.getId());


        Assertions.assertThat(saveBoard).isEqualTo(findByBoard);


    }

    @Test
    void findAll() {
        Board board1 = new Board("박형수", "엄마", new Date());
        Board board2 = new Board("ZZ", "DD", new Date());

        boardRepository.save(board1);
        boardRepository.save(board2);

        List<Board> findAll = boardRepository.findByAll();

        Assertions.assertThat(findAll).contains(board1, board2);


    }

    @Test
    void upDate() {
        Board board1 = new Board("ㅋㅋ", "ㅋㅋ", new Date());

        boardRepository.save(board1);

        Board saveBoard = boardRepository.findById(board1.getId());

        Board board2 = new Board("안녕", "ㅋㅋ", new Date());

        boardRepository.upDate(board1.getId(), board2);

        Board findBoard = boardRepository.findById(board1.getId());

        Assertions.assertThat(findBoard.getContent()).isEqualTo(board2.getContent());
        Assertions.assertThat(findBoard.getDate()).isEqualTo(board2.getDate());
        Assertions.assertThat(findBoard.getSub()).isEqualTo(board2.getSub());


    }


    @Test
    void delete(){
        Board board1 = new Board("ㅋㅋ", "ㅋㅋ", new Date());
        Board board2 = new Board("안녕", "ㅋㅋ", new Date());

        boardRepository.save(board1);
        boardRepository.save(board2);

        boardRepository.deleteBoard(board1.getId());


        List<Board> findBoard = boardRepository.findByAll();

        Assertions.assertThat(findBoard).doesNotContain(board1);

    }

}
