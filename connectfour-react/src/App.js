import React, { useState } from "react";
import "./App.css";
import Game from "./components/Game";
import Gameboard from "./components/Gameboard";

function App() {
    const [playerMoves, setPlayerMoves] = useState([[], [], [], [], [], []]);

    return (
        <div className="App">
            <header className="App-header">
                <h2>Connect Four</h2>
            </header>
            <Game playerMoves={playerMoves} setPlayerMoves={setPlayerMoves} />
            <Gameboard
                playerMoves={playerMoves}
                setPlayerMoves={setPlayerMoves}
            />
        </div>
    );
}

export default App;
