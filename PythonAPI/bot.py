from command import Command

def fight(current_game_state,player):

    my_command = Command()
    '''
    YOUR CODE GOES HERE
    You need to change the values of the playerButtons if your player is player1 and if your player
    is player2 then change player2Buttons respectively.
    Following is the example of changing the values
    '''
    if (player=='1'):
        my_command.player_buttons.up = True
    elif(player=='2'):
        my_command.player2_buttons.up = True
    return my_command