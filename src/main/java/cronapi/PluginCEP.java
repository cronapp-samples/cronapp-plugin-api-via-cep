package cronapi;

import cronapi.*;
import java.util.concurrent.Callable;


/**
 * Busca endereço a partir de um cep na api ViaCEP ...
 *
 * @author Francisco Iago De Sousa Mendes
 * @version 1.0
 * @since 2021-05-10
 *
 */

@CronapiMetaData(categoryName = "API Externa")
public class PluginCEP {

	@CronapiMetaData(type = "function", name = "PluginCEP", description = "Busca endereço a partir de um cep na api ViaCEP")
	public static Var obterCEP(@ParamMetaData(description = "cep: cep a ser buscado") String cep) throws Exception {
		return new Callable<Var>() {

		private Var ret = Var.VAR_NULL;
		private Var err = Var.VAR_NULL;

		public Var call() throws Exception {

			try {

				ret =
				cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
				Var.VAR_TRUE) , Var.valueOf("dados",
				cronapi.json.Operations.toJson(
				cronapi.util.Operations.getURLFromOthers(
				Var.valueOf("GET"),
				Var.valueOf("application/json"),
				Var.valueOf(
				Var.valueOf("https://viacep.com.br/ws/").toString() +
				cep.toString() +
				Var.valueOf("/json/").toString()), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
				Var.valueOf(""),
				Var.valueOf("BODY")))));
			} catch (Exception err_exception) {
				err = Var.valueOf(err_exception);

				ret =
				cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
				Var.VAR_FALSE) , Var.valueOf("dados",
				Var.valueOf(
				Var.valueOf("Erro: ").toString() +
				err.toString())));
			}
			return ret;
		}
		}.call();
	}

}