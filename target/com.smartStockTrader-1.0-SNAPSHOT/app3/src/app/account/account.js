angular.module('ngBoilerplate.account', ['ui.router'])
.config(function($stateProvider) {
    $stateProvider
    .state('login', {
        url:'/login',
        views: {
            'main': {
                templateUrl:'account/login.tpl.html',
                controller: 'LoginCtrl'
            }
        },
        data : { pageTitle : "Login" }
    })
    .state('register', {
            url:'/register',
            views: {
                'main': {
                    templateUrl:'account/register.tpl.html',
                    controller: 'RegisterCtrl'
                }
            },
            data : { pageTitle : "Registration" }
            }
    );
}).factory('accountFactory', function($state, $http){
    return {
        login:function(data){
            
             localStorage.setItem("session", data);
             $state.go('display');

        },
        logout:function(){
            localStorage.removeItem("session");
            $state.go('home');
        },
        isLoggedIn:function(){
            return  localStorage.getItem("session")!==null;
        },
        register:function(data){
            return  $http.post('../register/',data).then(function(success){
                $state.go('home');
            },
                    function (failure){
                        alert("Error ! Check Email, Date");
                    }
            );
        }
        
    };
})
.controller("LoginCtrl", function($scope,accountFactory, $http ) {
    var self=this;
    self.user={user_Id:"", name:"", phone:"", city:"", email:"", image:"", remark1:"", remark:"",dob:"",  password:""};
    
    $scope.login = function() {
        
        return        $http.get('../login/'+$scope.account.email+'/'+$scope.account.remark+'/').then(function(result){
                     
               accountFactory.login($scope.account);
                },
                function(error){
                   
                    alert('Wrong credentials');
                     
                
                }
                );

          
    
    };
  
    
})
.controller("RegisterCtrl", function($scope, accountFactory) {
    $scope.register = function() {
        accountFactory.register($scope.account);
//        accountFactory.login($scope.account);
    };
});


