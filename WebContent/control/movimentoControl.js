var app = angular.module('movimentoModule',[]);

app.controller('movimentoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/contaSimples/rs/movimento';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (movimentosRetorno) {
			$scope.movimentos = movimentosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.movimento = {};
	}

    $scope.salvar = function() {
		if ($scope.movimento.codigo == '') {
			$http.post(url,$scope.movimento).success(function(movimento) {
				$scope.movimentos.push($scope.movimento);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.movimento).success(function(movimento) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.movimento.codigoMovimento == '') {
			alert('Selecione um movimento');
		} else {
			urlExcluir = url+'/'+$scope.movimento.codigoMovimento;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert("Houve algum erro ... ");
			});
		}
	}
	
	$scope.seleciona = function(movimentoTabela) {
		$scope.movimento = movimentoTabela;
	}
});