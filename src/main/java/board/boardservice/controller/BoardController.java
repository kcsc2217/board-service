package board.boardservice.controller;

import board.boardservice.domain.Board;
import board.boardservice.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/basic/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model){
        List<Board> boardList = boardRepository.findByAll();

        model.addAttribute("board", boardList);

        return "basic/boards";

    }



    @PostConstruct
    public void init() {
    boardRepository.save(new Board("ㅋㅋ", "ㅋㅋ", new Date()));
        boardRepository.save(new Board("ㅋㅋ", "ㅇㅇ", new Date()));

    }


}
