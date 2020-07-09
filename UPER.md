<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
In a series of modules, we have learned the concepts of OOP, as well as the fundamentals, 
and we even touched on advanced concepts of Java. Our biggest priority is to apply the knowledge 
that we have gained to create a terminal game in Java. If we are confident and have managed our 
time well, we can add bonus functionality such as adhering to SOLID principles of Object-Oriented Design, 
adding a 3rd party Java library, or use React to showcase the functionality of the game. 
*
*
*
*
*
*
*
<h2>
    2. Planning the Solution
</h2>
In my first capstone, I didn't draw/use a diagram to plan out my project. I plan to utilize a UML diagram (Creately) 
to have a high-level vision of the classes/components to create my game. Also, I found that when I used a to-do list 
it was easy to keep track of the status of my completion and made it easy to manage my time.  
*
*
*
*
*
*
*
<h2>
    3. Executing the Plan
</h2>
- Game Development
    ✔ Create the draw interface
    - Main
        ✔ IO 
        ✔ Get players' name
        ✔ Display board
        ✔ Coordinate players chip placement 
        ✔ display board 
        ✔ while loop IO so that the checkState() can keep track of the chip placements
    - GameBoard Class
        ✔ updateBoard()
        ✔ checkState()
            ✔ checkHorizontal()
            ✔ checkVertical()
            ✔ checkDiagonals()
                ** takes care of left and right diagonal
            ✔ gameOver()
                - prints out the player that has won
            ✔ gameOver()
                - prints that no one has won
    ✔ Player Class
    ✔ Chips Class
        ✔ Create a method that will assign chips to a player
    - Error Handling
        ✔ If invalid number entered
        ✔ if the allotted columns/rows are filled, you wouldn't be 
            able enter that value
            - Create a logic for the updateBoard else check: where a player enters 
                a number for a column that is full
- Paperwork
    - Create Instructions for the game
    - Complete UPER file
    - Complete OOP Questions
    - Add UML file to capstone folder
    
- Challenges 
    - Creating the algorithm to check for the winners (horizontal, vertical, diagonal)
    ✔ Configuring the FX file
        - I was able to create a GUI for the connect four game, but it was 
            taking too much to configure my logic to work with the GUI.
            I plant to use whatever free time I have left to work on it.
        
    
*
*
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>
*
*
*
*
*
*
*
*