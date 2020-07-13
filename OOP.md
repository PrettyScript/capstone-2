Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation:
Encapsulation allows for methods and variables to be private/hidden from outside classes. 
This prevents those methods/variables from being accessed and/or manipulated. Another reason to use 
encapsulation within your classes is so that inner workings of methods aren't revealed. For instance, 
I have an updateBoard method that places the player's chip on the board, and within this updateBoard method, 
I call checkState method. checkState checks when there is a winner and ends the game, it is private because 
outside classes/developers don't need to know the details from that method.










********************
2. Inheritance:
Inheritance is when a class inherits the methods and variables from its parent class. This provides a relationship
 between classes. If I had a Vehicle class (parent class), I could create a motorcycle class that would extend from 
 the vehicle. The motorcycle class would inherit all of the behaviors of a vehicle but in its own right, some 
 properties make a motorcycle different from a sedan. Such as a motorcycle only has two wheels (maybe 3 depending 
 on the kind you have I guess) but a sedan would have 4 wheels. 








********************
3. Abstraction:
Abstraction is when you show relevant data and hide unnecessary details. It sounds very much like encapsulation 
except they are both implemented differently. You can have interface methods and abstract classes that can be 
extended to classes. However, Abstract classes cannot be instantiated. In my code, I created an abstract class 
called game, it is a generalized class with abstract methods within that class that could be inherited in other 
game classes if I had different games created. Every game would need to initialize the board, check the state of the game, 
and a game over method that will end the game. 







********************
4. Polymorphism:
This pillar allows for objects to take in different forms. You can have a method that behaves differently depending 
on the situation. In my code, I have two gameOver methods, one returns the player that won and the gameOver is called
 when no one wins. It doesn't happen often where I played connect four and no one wins but there are a few cases when 
 it does happen. 
 
   






Please write a 1-3 paragraphs explaining these 4 concepts further.  
Please provide a sufficient explanation about these pillars, 
as well as some examples to illustrate the practical use cases of these principles.  



