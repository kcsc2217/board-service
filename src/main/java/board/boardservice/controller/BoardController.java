package board.boardservice.controller;

import board.boardservice.domain.Board;
import board.boardservice.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/basic/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model) {
        List<Board> boardList = boardRepository.findByAll();

        model.addAttribute("board", boardList);

        return "basic/boards";

    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable Long boardId, Model model) {
        Board board = boardRepository.findById(boardId);
        model.addAttribute("board", board);

        return "basic/board";
    }

    @GetMapping("/create")
    public String createBoardForm() {
        return "basic/addForm";
    }

    @PostMapping("/create")
    public String createBoard(@ModelAttribute Board board) {
        boardRepository.save(board);
        board.setDate(new Date());


        return "basic/board";

    }

    @GetMapping("/edit/{boardId}")
    public String editForm(@PathVariable Long boardId, Model model){
        Board findBoard = boardRepository.findById(boardId);

        model.addAttribute("board", findBoard);

        return "basic/edit";
    }

    @PostMapping("/edit/{boardId}")
    public String edit(@PathVariable Long boardId, @ModelAttribute Board board){
        boardRepository.upDate(boardId, board);

        return "redirect:/basic/boards/{boardId}";
    }

    @GetMapping("/delete/{boardId}")
    public String delete(@PathVariable Long boardId){
        boardRepository.deleteBoard(boardId);

        return "redirect:/basic/boards";
    }




    @PostConstruct
    public void init() {
        boardRepository.save(new Board("ㅋㅋ", "ㅋㅋ", new Date()));
        boardRepository.save(new Board("ㅋㅋ", "ㅇㅇ", new Date()));

    }


}
