import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";

const useStyles = makeStyles(theme => ({
    root: {
        width: "100%",
        flexGrow: 1,
        display: "flex",
        flexDirection: "column",
        justifyContent: "center"
    },
    container: {
        margin: "auto",
        marginTop: "5rem",
        width: "25rem",
        height: "25rem",
        display: "flex",
        flexDirection: "row",
        justifyContent: "center",
        border: "2px solid blue",
        backgroundColor: "blue"
    },
    row: {
        width: "100%",
        display: "flex",
        flexDirection: "row",
        justifyContent: "center"
    },
    cell: {
        width: "2rem",
        height: "2rem",
        border: "2px solid white",
        borderRadius: "1rem",
        margin: "0.6rem",
        backgroundColor: "white"
    }
}));

export default function Gameboard(props) {
    const { playerMoves, setPlayerMoves } = props;

    const classes = useStyles();

    function Cell(props) {
        return (
            <div>
                <div
                    className={classes.cell}
                    id={props.id}
                    onMouseEnter={null}
                    onMouseLeave={null}
                ></div>
            </div>
        );
    }
    function CellRow(props) {
        const cells = [];

        for (let i = 0; i < 7; i++) {
            console.log(props.row);
            cells.push(<Cell key={i} id={`${props.row}-${i}`} />);
        }

        return <div className={classes.row}>{cells}</div>;
    }

    return (
        <div className={classes.root}>
            <div className={classes.container}>
                <Grid container spacing={1}>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={0} />
                    </Grid>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={1} />
                    </Grid>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={2} />
                    </Grid>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={3} />
                    </Grid>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={4} />
                    </Grid>
                    <Grid container item xs={12} spacing={1}>
                        <CellRow row={5} />
                    </Grid>
                </Grid>
            </div>
        </div>
    );
}
