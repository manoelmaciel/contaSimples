var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	var url = 'http://localhost:8080/contaSimples/rs/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	
	$scope.novo = function(){
		$scope.cliente = {};
		$scope.mensagens = [];
	}

	// monta a lista de mensagens ... !
	$scope.montaMensagemErro = function(listaErro) {
		// alert("Cheguei aqui ... !")
		$scope.mensagens = [];
		$scope.mensagens.push('Falha(s) de validação retornada(s) do servidor: ');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

	// $scope.montaMensagemErro;
	
    $scope.salvar = function() {
		if ($scope.cliente.codigo == undefined || $scope.cliente.codigo == '') {
			// alert('Post ... ! - ' + $scope.cliente.codigo);
			$http.post(url,$scope.cliente).success(function(cliente) {
				$scope.mensagens.push('Cliente salvo com sucesso');
				$scope.clientes.push($scope.cliente);
				$scope.novo();
				$scope.pesquisar();
			}).error(function (erro) {
				// alert(erro + ' post');
				// $scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);				
			});
		} else {
			$http.put(url,$scope.cliente).success(function(cliente) {
				// alert('Put ... !');
				$scope.mensagens.push('Cliente alterado com sucesso');
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				// alert(erro + ' put');
				// $scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);				
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.codigo == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = url+'/'+$scope.cliente.codigoCliente;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});