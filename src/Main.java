import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    static int x = 15;

    final char[] array = {'+', '-', '*', '/'};
    @Test
    public void semne() throws ScriptException {
       solve();
    }

    public void solve() throws ScriptException {
         printAllKLength(array, 4);
    }

    public static void printAllKLength(char[] set, int k) throws ScriptException {
        int n = set.length;
        combine(set, "", n, k);
    }

    public static void combine(char[] set, String prefix, int n, int k) throws ScriptException {
        if (k == 0)
        {
            String toEval = "(((1" + prefix.charAt(0) + "2)" + prefix.charAt(1) + "3)" + prefix.charAt(2) + "4)" + prefix.charAt(3) + 5;
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = engine.eval(toEval);

            if (result.toString().equals(String.valueOf(x))) {
                System.out.println(toEval);
            }


            return;
        }
        for (int i = 0; i < n; ++i)
        {
            String newPrefix = prefix + set[i];
            combine(set, newPrefix,
                    n, k - 1);
        }
    }
}
