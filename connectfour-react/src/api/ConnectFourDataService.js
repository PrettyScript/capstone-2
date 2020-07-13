import axios from "axios";

class ConnectFourDataService {
    startGame() {
        return axios.get("http://localhost:8080/initializeBoard");
    }

    retrievePlayer(playerOneName, playerTwoName) {
        return axios.get(
            `http://localhost:8080/addPlayers/${playerOneName}/${playerTwoName}/`
        );
    }

    playerMove(player, column) {
        return axios.get(
            `http://localhost:8080/playerMove/${player}/${column}`
        );
    }
}

export default new ConnectFourDataService();
