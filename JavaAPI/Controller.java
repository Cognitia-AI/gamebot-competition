import java.io.*;
import java.net.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Controller
{
    ServerSocket welcomeSocket;
    Socket clientSocket;
    InetAddress addr;
    int port;
    String player="1";
    Controller(String p)
    {
        try
        {
            addr=InetAddress.getByName("127.0.0.1");
            this.player=p;
            if (player.equals("1")){
                this.port=9999;
            }
            else if (player.equals("2")){
                this.port=10000;
            }
            welcomeSocket=new ServerSocket(this.port,50,addr);
        }
        catch (Exception e)
        {
            System.out.println("ERROR IN CONNECTING");
        }
    }
    void connect()
    {
        //For making a connection with the game
        try
        {
            System.out.println("Waiting for client to connect ...");
            this.clientSocket=welcomeSocket.accept();
            System.out.println("CONNECTED SUCCESSFULLY");
        }
        catch (Exception e)
        {
            System.out.println("ERROR IN ACCEPTING");
        }
    }
    GameState receive()
    {
        //receive the game state and return game state 
        try
        {
            InputStream in=clientSocket.getInputStream();
            byte bytes[]=new byte[1024];
            in.read(bytes);
            String payLoad=new String(bytes);
            final JSONObject allInfo = new JSONObject(payLoad);
            GameState gameState=new GameState(allInfo);
            return gameState;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    Command fight(GameState gameState){
        //the function you have to implement
        Command myCommand=new Command();
        if (player.equals("1")){
             myCommand.playerButtons.up=true; //Example of changing the values (Jumping)   
            }
        else if (player.equals("2")){
            myCommand.player2Buttons.up=true;
        }
        /*
                    YOUR CODE GOES HERE
        You need to change the values of the playerButtons if your player is player1 and if your player
        is player2 then change player2Buttons respectively.
        
        */
        return myCommand;
    }
    void send(Command myCommand){
        //This function will send your updated command to Bizhawk so that game reacts according to your command.
        JSONObject json=myCommand.ObjectToJSON();
        String cmd=json.toString();
        byte[] payLoad=cmd.getBytes();
        try{
            OutputStream out=clientSocket.getOutputStream();
            out.write(payLoad);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String []args)
    {
        Controller aiBot=new Controller(args[0]); //Initialize
        aiBot.connect(); //connect to Game
        GameState currentGameState=null;
        int round_count=0;
        boolean roundSupport=false;
        while (currentGameState==null || currentGameState.isRoundOver==false){
            currentGameState=aiBot.receive(); //get the current state of the game
            Command myCommand=aiBot.fight(currentGameState); //get the command
            aiBot.send(myCommand); //send command to the game.
        }
    }
}