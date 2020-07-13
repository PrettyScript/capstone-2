package com.capstone2.connectfour;

import com.capstone2.connectfour.game.Chip;
import com.capstone2.connectfour.game.ConnectFour;
import com.capstone2.connectfour.game.Player;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectFourResource {

    ConnectFour game = new ConnectFour();
    Player playerOne = new Player(new Chip("X"));
    Player playerTwo = new Player(new Chip("O"));


    @GetMapping("/initializeBoard")
//  http://localhost:8080/initializeBoard
    public String initializeBoard() {
        game.initializeGameBoard();
        return "Board created!";
    }

    @GetMapping("/addPlayers/{playerOneName}/{playerTwoName}/")
//    http://localhost:8080/addPlayers/Jessica/Hugh/
    public void addPlayers(@PathVariable String playerOneName, @PathVariable String playerTwoName) {
        playerOne.setName(playerOneName);
        playerTwo.setName(playerTwoName);
        System.out.println(playerOne.getName());
        System.out.println(playerTwo.getName());
    }

    @GetMapping("/playerMove/{player}/{column}")
 //    http://localhost:8080/playerMove/Jessica/3
    public String[] playerMove(@PathVariable String player, @PathVariable int column) throws Exception {
        String chipPosition = "";
        if(playerOne.getName().equals(player)) {
            chipPosition = game.updateBoard(playerOne, column);
        }
        if(playerTwo.getName().equals(player)) {
            chipPosition = game.updateBoard(playerTwo, column);
        }
        return new String[] {String.valueOf(game.gameOver), String.valueOf(game.playerRedo), chipPosition};
    }

}
