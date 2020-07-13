import React, { useState } from "react";
import ConnectFourDataService from "../api/ConnectFourDataService";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";

export default function Game(props) {
    const { playerMoves, setPlayerMoves } = props;

    const [playerOneName, setPlayerOneName] = useState("");
    const [playerTwoName, setPlayerTwoName] = useState("");
    const [showPlayerName, setShowPlayerName] = useState(false);
    const [playerChoice, setPlayerChoice] = useState();
    const [playerOneTurn, setPlayerOneTurn] = useState(true);
    const [invalidMove, setInvalidMove] = useState(false);
    const [gameover, setGameover] = useState(false);

    const handleStartGame = () => {
        ConnectFourDataService.startGame()
            .then(res => console.log(res))
            .catch(error => console.log(error));
    };

    const handlePlayers = () => {
        setShowPlayerName(true);
        ConnectFourDataService.retrievePlayer(playerOneName, playerTwoName)
            .then(response => {
                console.log(response);
            })
            .catch(error => console.log(error));
    };

    const handleUpdateBoard = () => {
        let playerName;
        if (playerOneTurn) {
            playerName = playerOneName;
        } else {
            playerName = playerTwoName;
        }
        ConnectFourDataService.playerMove(playerName, playerChoice)
            .then(response => {
                console.log(response);
                let isGameOver = response.data[0] == "true";
                let isInvalidMove = response.data[1] == "true";
                if (!isInvalidMove) {
                    let chipPosition = response.data[2];
                    if (playerOneTurn) {
                        document.getElementById(chipPosition).style =
                            "background-color: red";
                    } else {
                        document.getElementById(chipPosition).style =
                            "background-color: yellow";
                    }
                    setPlayerOneTurn(!playerOneTurn);
                }
                setGameover(isGameOver);
                setInvalidMove(isInvalidMove);
            })
            .catch(error => console.log(error));
    };

    const handleResetGame = () => {
        document.getElementById("playerTurn").value = "";
        let cells = document.getElementsByClassName("makeStyles-cell-8");
        for (let i = 0; i < cells.length; i++) {
            cells[i].style = "background-color: white";
        }

        setGameover(false);
        setPlayerOneName("");
        setPlayerTwoName("");
        setPlayerOneTurn(true);
        setInvalidMove(false);
        setShowPlayerName(false);
    };

    return (
        <div>
            <Button
                variant="contained"
                color="primary"
                onClick={handleStartGame}
                style={{ marginBottom: "1rem" }}
            >
                Start
            </Button>
            <div>
                {!showPlayerName && (
                    <div>
                        <label>Player one enter your name: </label>
                        <TextField
                            id="playerOneName"
                            variant="outlined"
                            onChange={e => setPlayerOneName(e.target.value)}
                            name="playerOneName"
                        />
                        <label style={{ marginLeft: "1rem" }}>
                            Player two enter your name:{" "}
                        </label>
                        <TextField
                            variant="outlined"
                            onChange={e => setPlayerTwoName(e.target.value)}
                            name="playerTwoName"
                            id="playerTwoName"
                        />
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={handlePlayers}
                        >
                            Get Players Name
                        </Button>
                    </div>
                )}
                {showPlayerName && (
                    <p>
                        Player one: {playerOneName} <br />
                        Player two: {playerTwoName}
                    </p>
                )}
            </div>
            <div>
                <div className="playerButton">
                    <label>
                        {showPlayerName &&
                            `Player turn: 
                        ${playerOneTurn ? playerOneName : playerTwoName}
                    `}
                    </label>
                    {showPlayerName && (
                        <div>
                            <TextField
                                variant="outlined"
                                id="playerTurn"
                                onChange={e => setPlayerChoice(e.target.value)}
                            />
                            <Button
                                variant="contained"
                                color="primary"
                                onClick={gameover ? null : handleUpdateBoard}
                            >
                                Get player's move
                            </Button>
                        </div>
                    )}
                </div>
                {invalidMove && (
                    <div>
                        {playerOneTurn ? playerOneName : playerTwoName}, that is
                        an invalid move. Please try again.
                    </div>
                )}
                {gameover && (
                    <div>
                        {!playerOneTurn ? playerOneName : playerTwoName} won!
                        <button onClick={handleResetGame}>Reset</button>
                    </div>
                )}
            </div>
        </div>
    );
}
