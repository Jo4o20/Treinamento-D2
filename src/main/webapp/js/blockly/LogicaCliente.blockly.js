window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.LogicaCliente = window.blockly.js.blockly.LogicaCliente || {};

/**
 * @function Executar
 *
 *
 *
 * @param entrada
 *
 * @author João Gabriel De Lima Castro
 * @since 09/10/2024, 09:38:11
 *
 */
window.blockly.js.blockly.LogicaCliente.ExecutarArgs = [{ description: 'entrada', id: 'ffb890ef' }];
window.blockly.js.blockly.LogicaCliente.Executar = async function(entrada) {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.LogicaServidor:Executar', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.notification.customNotify('info', item, 'fade', 'top', 'center', 'false');
  }.bind(this), entrada);
}
