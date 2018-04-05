from buttons import Buttons

class Command:

    def __init__(self):

        self.player_buttons = Buttons()
        self.player2_buttons = Buttons()
        self.__type = "buttons"
        self.__player_count = 2
        self.__save_game_path = ""

    def object_to_dict(self):
        
        command_dict = {}

        command_dict['p1'] = self.player_buttons.object_to_dict()
        command_dict['p2'] = self.player2_buttons.object_to_dict()
        command_dict['type'] = self.__type
        command_dict['player_count'] = self.__player_count
        command_dict['savegamepath'] = self.__save_game_path

        return command_dict