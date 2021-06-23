window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.CEPCliente = window.blockly.js.blockly.CEPCliente || {};

/**
 * CEPCliente
 */
window.blockly.js.blockly.CEPCliente.preencherCEPArgs = [];
window.blockly.js.blockly.CEPCliente.preencherCEP = async function() {
 var dadosCEP;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.CEPServidor:buscarCEP', async function(sender_dadosCEP) {
      dadosCEP = sender_dadosCEP;
    this.cronapi.screen.changeValueOfField("vars.logradouro", this.cronapi.object.getProperty(this.cronapi.object.getProperty(dadosCEP, 'dados'), 'logradouro'));
    this.cronapi.screen.changeValueOfField("vars.localidade", this.cronapi.object.getProperty(this.cronapi.object.getProperty(dadosCEP, 'dados'), 'localidade'));
    this.cronapi.screen.changeValueOfField("vars.uf", this.cronapi.object.getProperty(this.cronapi.object.getProperty(dadosCEP, 'dados'), 'uf'));
  }.bind(this), this.cronapi.screen.getValueOfField("vars.cep"));
}
