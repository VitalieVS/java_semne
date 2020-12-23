import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Simplified {
    @Test
    public void solve() throws ScriptException {
        char[] combinational = {'+', '-', '*', '/'};
        int x = 15;

        for (char a : combinational) {
            for (char b : combinational) {
                for (char c : combinational) {
                    for (char d : combinational) {
                        String toEval = "(((1" + a + "2)" + b + "3)" + c + "4)" + d + 5;
                        ScriptEngineManager manager = new ScriptEngineManager();
                        ScriptEngine engine = manager.getEngineByName("js");
                        Object result = engine.eval(toEval);

                        if (result.toString().equals(String.valueOf(x))) {
                            System.out.println(toEval);
                        }
                    }
                }
            }
        }
    }
}
