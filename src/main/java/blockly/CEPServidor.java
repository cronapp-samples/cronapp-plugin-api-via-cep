package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CEPServidor {

public static final int TIMEOUT = 300;

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// CEPServidor
public static Var buscarCEP(@ParamMetaData(description = "cep") Var cep) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
Var.valueOf(cronapi.PluginCEP.obterCEP(cep.getTypedObject(String.class)));
   }
 }.call();
}

}

