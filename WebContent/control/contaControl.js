var app = angular.module('contaModule',[]);

app.controller('contaControl',function($scope,$http){
	
	var url = 'http://localhost:8080/contaSimples/rs/conta';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (contasRetorno) {
			$scope.contas = contasRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.novo = function(){
		$scope.conta = {};
		$mensagens = [{}];
	}

	// monta a lista de mensagens ... !	
	$scope.montaMensagemErro = function(listaErro) {
		alert("Cheguei aqui ... !")
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {
    	// alert('Salvar ... !')
		if ($scope.conta.codigoConta == udefined || $scope.conta.codigoConta == '') {
			alert('Salvar ... !')
			$http.post(url,$scope.conta).success(function(conta) {
				$scope.contas.push($scope.cliente);
				$scope.novo();
			}).error(function (erro) {
				alert(erro + ' salvar');
				$scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				// $scope.montaMensagemErro(erro.parameterViolations);				
			});
		} else {
			$http.put(url,$scope.conta).success(function(conta) {
				alert('alterar');
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro + ' alterar');
				$scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				// $scope.montaMensagemErro(erro.parameterViolations);				
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.conta.codigoConta == '') {
			alert('Selecione uma conta');
		} else {
			urlExcluir = url+'/' + $scope.conta.codigoConta;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(contaTabela) {
		$scope.conta = contaTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});