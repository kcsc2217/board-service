package board.boardservice.repository;

import board.boardservice.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryBoardRepository implements BoardRepository{

    private static final Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board save(Board board) {
        board.setId(sequence++);
        store.put(board.getId(), board);
        board.view();
        return board;
    }

    @Override
    public Board findById(Long id) {
        return store.get(id);
    }

    @Override
    public Board findBysub(String sub){

    }

    @Override
    public List<Board> findByAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void upDate(Long id, Board board) {
        Board findBoard = findById(id);
        findBoard.setDate(new Date());
        findBoard.setSub(board.getSub());
        findBoard.setContent(board.getContent());
    }

    @Override
    public void deleteBoard(Long id) {
        if(store.containsKey(id)){
            store.remove(id);
            log.info("삭제 완료");
        }
        else{
            log.info("해당 아이디는 없습니다");
        }
    }

    @Override
    public void clearStore(){
        store.clear();
    }
}
