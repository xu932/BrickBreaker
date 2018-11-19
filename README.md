#Brick Breaker in Java


The entire game developed using Java `JFrame`. 

The `Main` folder contain the `GameMain.java` which creates the `JFrame` window as well as `GamePanel.java` which 
initializes the thread, the game, the graphics, the interactions, etc.

The `GameState` folder contains the class `GameState` which is how all different classes run under the same thread; it 
controls how each state interact with one another as well as the interactions.

The `Game` folder contains all game files: the menu page, the game page, setting, etc.

`Entities` folder has four classes defined, the ball, the block, the board and collision. 

`Mapping/Maps.java` creates the game map from `res/Maps/*.map` files. All `.map` files are readable directly instead of 
binary file.

The `Media` folders have classes controlling the audio and the image handling.

`Ranking` system is not complete since the ranking will be lost every time the game ends (as of right now).

####Note

All images are acquired from internet (mainly from a formal game called Brick Breaker on iOS). If will be taken down if violates copy right.


