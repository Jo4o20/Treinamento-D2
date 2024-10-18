window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Home = window.blockly.js.blockly.Home || {};

/**
 * @function verificarPeriodo
 *
 *
 *
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:47:40
 *
 */
window.blockly.js.blockly.Home.verificarPeriodoArgs = [];
window.blockly.js.blockly.Home.verificarPeriodo = async function() {
 var vericarAdminPeriodo;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.PeriodoControl:verifyPeriodoAtivo', async function(sender_vericarAdminPeriodo) {
      vericarAdminPeriodo = sender_vericarAdminPeriodo;
    //
    console.log(vericarAdminPeriodo);
    //
    if (vericarAdminPeriodo) {
      //
      this.cronapi.notification.confirmDialogAlert('info', 'Você não tem nenhum período ativo!', 'Cadastre um período.', this.cronapi.notification.buttonConfirmDialogAlert('true', 'Ok, entendi.', async function() {
        }.bind(this)));
    }
  }.bind(this));
}
