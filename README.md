# Gamebot-Competition
This repository holds the starter API for the GameBot Competition being held at NaSCon '18, FAST-NUCES Islamabad, Pakistan.

### Prequisites/Dependencies

* Operating System: Windows 7 or above (64-bit)

* The Python API is made in version 3.6.3 and tested only for this version but it should run on any version above 3. For running it in Python versions below 3, some slight changes are required. Probably you would be able to figure them out yourselves but you can always contact the event head for your problem resolution.

* Java API is made and tested in JDK 10 but it should also work with other versions.

* Download and install the pre-requisites for the BizHawk emulator from this [link](https://github.com/TASVideos/BizHawk-Prereqs/releases/download/2.1/bizhawk_prereqs_v2.1.zip).

### Running the game and executing the API code

1. For running a single bot (your bot vs CPU), open the single-player folder. For running two of your bots at the same time both fighting each other, open the two-players folder.
2. Run EmuHawk.exe.
3. From File drop down, choose Open ROM. (Shortcut: Ctrl+O)
4. From the same single-player folder, choose the Street Fighter II Turbo (U).smc file.
5. From Tools drop down, open the Tool Box. (Shortcut: Shift+T)
6. Once you have performed the above steps, leave the emulator window and tool box open and open the command prompt in the directory of the API and run the following commands:

    For Python API: `python controller.py 1`

    For Java API: 
    
    `javac -cp lib\json-20160212.jar *.java` (For compiling)
    
    `java -cp 'lib\json-20160212.jar;.' Controller 1` (For executing)
    
    Note: The '1' at the end of each execution command is a command-line argument. '1' is for controlling player 1 through your bot (left hand side player in the game). '2' if you want to contol player 2 (right hand side player in the game). Any command-line arguments other than '1' or '2' (without the quotes) will cause the code to give an error. (Yes we haven't done exception handling. Deal with it.)

7. After executing the code, go and select your player(s) in the game after choosing normal mode. Controls for selecting players can be set or seen from the controllers option in the config drop down of the emulator.
8. Now click on the second icon in the top row (Gyroscope Bot). This will cause the emulator to establish a connection with the program you ran and you will see "Connected to the game!" or "CONNECTED SUCCESSFULLY" on the terminal.
9. If you have completed all of these steps successfully then you have successfully run the GameBot starter code.
10. The program will stop once a single round is finished. Repeat this process for running the emulator and the code again.

### API Details

Both the API's contain similar code structure and files. Brief explanation of each file is explained as follows:

* Buttons: Contains the Button class which represents a simple SNES gamepad used for playing Street Fighter. Each gamepad contains twelve buttons. So does the Buttons class which contains 12 members each representing a single button. The function of each button in the game of Street Fighter II can be seen in the below image:

Street Fighter Controls: 

![alt text](https://github.com/Cognitia-AI/gamebot-competition/blob/master/Controls.PNG "Street Fighter Controls")

SNES Gamepad Layout:

![alt text](https://github.com/Cognitia-AI/gamebot-competition/blob/master/snes_controller_layout.png "SNES Gamepad Layout")

* Player: Contains the Player class which represents a player.