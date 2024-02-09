package board.boardservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {

    private Long id;
    private String sub;
    private String content;
    private Date date;
    private int count;

    public Board(String sub, String content, Date date) {
        this.sub = sub;
        this.content = content;
        this.date = date;
    }

    public void view(){
        count++;
    }


}
