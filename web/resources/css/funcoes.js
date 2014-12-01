function EntradaNumerico(evt) {

    var key_code = evt.keyCode  ? evt.keyCode  :
                   evt.charCode ? evt.charCode :
                   evt.which    ? evt.which    : void 0;

                   
        // Habilita teclas <DEL>, <TAB>, <ENTER>, <ESC> e <BACKSPACE>
        if (key_code == 8  ||  key_code == 9  ||  key_code == 13  ||  key_code == 27  ||  key_code == 46) {
            return true;
        }
        // Habilita teclas <HOME>, <END>, mais as quatros setas de navegação (cima, baixo, direta, esquerda)
        else if ((key_code >= 35)  &&  (key_code <= 40)) {
            return true
        }
        // Habilita números de 0 a 9
        // 48 a 57 são os códigos para números
        else if ((key_code >= 48)  &&  (key_code <= 57)) {
            return true
        }
        return false;
}


function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;   
    //strCPF  = RetiraCaracteresInvalidos(strCPF,11);
    if (strCPF == "00000000000")
	return false;
    for (i=1; i<=9; i++)
	Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i); 
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11)) 
	Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) )
	return false;
	Soma = 0;
    for (i = 1; i <= 10; i++)
       Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11)) 
	Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) )
        return false;
    return true;
}

function validarCPF(cpf) {
	var form = pegaObj("theForm");
	if (pegaObj("id_cpf").value == "") {
	    alert("Por favor, preencha o cpf");	
		pegaObj("id_cpf").focus();
	    return;
	}
}