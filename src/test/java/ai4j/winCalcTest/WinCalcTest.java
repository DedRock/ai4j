package ai4j.winCalcTest;

import ai4j.AutoitJavaAdapter;
import ai4j.utils.ClipBoard;
import org.junit.*;

public class WinCalcTest {

    static AutoitJavaAdapter adapter = new AutoitJavaAdapter();
    static String clipBoardText = new String();

    @Before
    public void clearCalc(){
        adapter.runProgramm("calc.exe");
        adapter.winWaitActive("Калькулятор");
        adapter.sendCmd("!1"); // Вид-Обычный
        adapter.sleep(100);
        adapter.runScript();
    }

    @Test
    public void testCalcSum(){
        adapter.winActivate("Калькулятор");
        adapter.controlClick("Калькулятор", "", "Button13"); // Калькулятор:Обычный - C (Clear)
        adapter.controlClick("Калькулятор", "", "Button9"); // Калькулятор:Обычный - 8
        adapter.controlClick("Калькулятор", "", "Button23"); // Калькулятор:Обычный - +
        adapter.controlClick("Калькулятор", "", "Button10"); // Калькулятор:Обычный - 5
        adapter.controlClick("Калькулятор", "", "Button28"); // Калькулятор:Обычный - =
        adapter.clipPut();
        adapter.runScript();
        clipBoardText = ClipBoard.clipGet();
        Assert.assertTrue(clipBoardText.equals("13") ); // Должны получить 13 = 8 + 5
    }

    @Test
    public void testCalcDiv(){
        adapter.winActivate("Калькулятор");
        adapter.controlClick("Калькулятор", "", "Button13"); // Калькулятор:Обычный - C (Clear)
        adapter.controlClick("Калькулятор", "", "Button9"); // Калькулятор:Обычный - 8
        adapter.controlClick("Калькулятор", "", "Button20"); // Калькулятор:Обычный - /
        adapter.controlClick("Калькулятор", "", "Button11"); // Калькулятор:Обычный - 2
        adapter.controlClick("Калькулятор", "", "Button28"); // Калькулятор:Обычный - =
        adapter.clipPut();
        adapter.runScript();
        clipBoardText = ClipBoard.clipGet();
        Assert.assertTrue(clipBoardText.equals("4") );  // Должны получить 4 = 8 / 2
    }

    @After
    public void closeCalc(){
        adapter.winClose("Калькулятор");
        adapter.runScript();
    }

}
