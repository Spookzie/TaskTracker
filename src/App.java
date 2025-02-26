import main.TaskManager;
import utils.InputHandler;


public class App
{  

    public static void main(String[] args) throws Exception
    {
        TaskManager taskManager = new TaskManager();
        InputHandler inputHandler = new InputHandler(taskManager);

        inputHandler.DisplayMenu();
    }
}