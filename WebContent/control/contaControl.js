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
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.conta = {};
	}

    $scope.salvar = function() {
		if ($scope.conta.codigoConta == '') {
			$http.post(url,$scope.conta).success(function(conta) {
				$scope.contas.push($scope.cliente);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.conta).success(function(conta) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
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
});